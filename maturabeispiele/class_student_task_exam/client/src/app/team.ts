import { Student } from "./student";
import { Task } from "./task";

export class Team {
    teamId:string;
    teamRoom:string;
    constructor(teamId:string, teamRoom:string){
        this.teamId = teamId;
        this.teamRoom = teamRoom;
    }
}