import { Project } from "./project";

export class Player {
    playerId:number;
    name:string;
    age:number;
    projects:Array<Project>;

    constructor(playerId:number, name:string, age:number, projects:Array<Project>){
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.projects = projects;
    }
}