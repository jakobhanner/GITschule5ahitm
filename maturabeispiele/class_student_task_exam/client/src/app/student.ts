import { Team } from "./team";
import { Task } from "./task";

export class Student {
    studentId:number;
    firstName:string;
    lastName:string;
    weight:number;
    team:Team;
    tasks:Array<Task>;

    constructor (studentId:number,firstName:string,lastName:string, weight:number, team:Team,tasks:Array<Task>){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.team = team;
        this.tasks = tasks;
    }
}