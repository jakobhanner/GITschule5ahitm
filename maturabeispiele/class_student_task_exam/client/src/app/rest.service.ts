import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student } from './student';
import { Task } from './task';
import { Team } from './team';


@Injectable()
export class RestService {
   
  private http;

  constructor(http: HttpClient) {
    this.http = http;
  }

  findTeams() {
    return this.http.get("http://localhost:8080/server/api/rest/findT");
  }

  findStudentsByTeam(teamid:string) {
    console.log("LINK: " + "http://localhost:8080/server/api/rest/findSbyT/"+teamid);
    return this.http.get("http://localhost:8080/server/api/rest/findSbyT/"+teamid);
  }

  editStudent(student:Student){
    return this.http.put("http://localhost:8080/server/api/rest/updateS/"+student.studentId, student);
  }

  deleteStudent(student:Student){
    return this.http.delete("http://localhost:8080/server/api/rest/deleteS/"+student.studentId);
  }

  createStudents(student:Student){
    console.log("create student"+student.firstName);    
    return this.http.put("http://localhost:8080/server/api/rest/createS", student);
  }

}
