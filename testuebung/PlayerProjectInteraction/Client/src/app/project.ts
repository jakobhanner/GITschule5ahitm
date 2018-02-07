import { Player } from './player';
import { Interaction } from './interaction';

export class Project {
    projectId:number;
    projectTitle:string;

    interactions:Array<Interaction>;

    constructor(projectId:number, projectTitle:string, interactions:Array<Interaction>){
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.interactions = interactions;
    }
}