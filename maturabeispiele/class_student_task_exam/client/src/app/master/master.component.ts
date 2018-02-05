import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';

import { Student } from '../student';
import { Team } from '../team';
import { Task } from '../task';


@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {

  private teams: Array<Team>;
  private students: Array<Student> = new Array();
  private tasks: Array<Task>;
  private nStd: Boolean;
  private nTsk: Boolean;
  private save: Boolean;
  private update:Boolean;

  private taskDescription:string;

  private rest;
  private selectedTeam;
  private selectedStudent;
  private selectedTask;
  private responseVar;

  private newStudentFirstName;
  private newStudentLastName;

  
  constructor(rest:RestService) {
    this.rest = rest;
  }

  ngOnInit() {
    this.students.push(new Student(null, "", "", null, null, null));
    this.rest.findTeams().subscribe(data => {this.teams = data});
  }

  selectTeam(team:Team){
    this.selectedTeam = team;
    console.log("SELECTED TEAM: " + team.teamId);
    this.rest.findStudentsByTeam(this.selectedTeam.teamId).subscribe(data => {this.students = data ;});
    this.selectedStudent = new Student(null, "", "", null, null, null);
    this.update = false;
    this.nStd = true;
  }

  getTeamColor(team:Team){
    if (team == this.selectedTeam){
      return "lightgray";
    }
  }

  selectStudent(student:Student){
    this.selectedStudent = student;
    this.tasks = this.selectedStudent.tasks;
    this.nTsk = true;
    this.update = true;
  }

  getStudentColor(student:Student){
    if (student == this.selectedStudent){
      return "lightgray";
    }
  }

  getTaskColor(task:Task){
    if (task == this.selectedTask){
      return "lightgray";
    }
  }

  newTask() {
    if (this.tasks == null) {
      this.tasks = new Array();
      this.tasks.push(new Task(0, this.taskDescription));          
      this.selectedStudent.tasks = this.tasks;
    } else {
      this.tasks.push(new Task(this.tasks.length, this.taskDescription));
      this.selectedStudent.tasks = this.tasks;
    }
    console.log(this.taskDescription);
  }
  

  newStudent(){
    var newStdt:Student = new Student(null, this.newStudentFirstName, this.newStudentLastName, null, this.selectedTeam, null);
    this.students.push(newStdt);
    this.rest.createStudents(newStdt).subscribe(data=>{this.responseVar = data});
    this.selectedStudent = newStdt;
    this.newStudentFirstName = "";
    this.newStudentLastName = "";
    this.nTsk = true;
    this.update = true;
    this.tasks = null;
  }

  updateStudent(){
    this.selectedStudent.tasks = this.tasks;
    this.rest.editStudent(this.selectedStudent).subscribe(data=>{this.responseVar = data});
  }

  removeStudent() {
    this.rest.deleteStudent(this.selectedStudent).subscribe(data=>{this.responseVar = data});    
    
    this.students.forEach(element => {
      if (element.studentId == this.selectedStudent.studentId){
        var index = this.students.indexOf(element);
        this.students.splice(index, 1);
      }
    });
    this.selectedStudent = null;
    this.tasks = null;
  }

  allowAddTask(){
    if (this.taskDescription){
      return true;
    } else {
      return false;
    }
  }

  allowAddStudent(){
    if (this.newStudentFirstName && this.newStudentLastName){
      return true;
    } else {
      return false;
    }
  }

  removeTask(task:Task){
    this.tasks.forEach(element => {
      if (element.taskId == task.taskId){
        console.log(task.description + " deleted!");
        var index = this.tasks.indexOf(element);
        this.tasks.splice(index, 1);
      }
    });
  }

}