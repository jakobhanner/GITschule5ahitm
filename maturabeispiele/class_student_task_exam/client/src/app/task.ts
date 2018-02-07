import { Team } from "./team";
import { Student } from "./student";

export class Task {
    taskId:number;
    description:string;

    constructor(taskId:number, description:string){
        this.taskId = taskId;
        this.description = description;
    }
}