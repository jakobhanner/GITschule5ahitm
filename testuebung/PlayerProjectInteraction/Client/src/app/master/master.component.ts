import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Player } from '../player';
import { Project } from '../project';
import { Interaction } from '../interaction';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {

  private players:Array<Player>;
  private projects:Array<Project>;
  private interactions:Array<Interaction>;
  private selectedPlayer:Player;
  private selectedProject:Project;

  private newInteraction:string;

  private rest;

  constructor(rest:RestService) {
    this.rest = rest;
  }

  ngOnInit() {
    this.rest.loadPlayer().subscribe(data => {this.players = data});
  }

  newSelectedPlayer(player){
    this.selectedPlayer = player;
    this.projects = player.projects;
  }

  newSelectedProject(project){
    this.selectedProject = project;
    this.interactions = project.interactions;
  }

  getColor(player){
    if(player == this.selectedPlayer){
      return 'lightgray';
    } else {
      return 'white';
    }
  }

  getColorP(project){
    if(project == this.selectedProject){
      return 'lightgray';
    } else {
      return 'white';
    }
  }

  updateProject(){
    this.rest.updateProject(this.selectedProject).subscribe(data=>{console.log(data)});
  }

  deleteProject(){
    this.rest.deleteProject(this.selectedProject).subscribe(data=>{console.log(data)});
  }

  addInteraction(){
    this.rest.addInteraction(this.selectedProject, this.newInteraction).subscribe(data=>{console.log(data)});
  }
}
