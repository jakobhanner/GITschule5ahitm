import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from './player';
import { Project } from './project';

@Injectable()
export class RestService {
  private http;


  constructor(http:HttpClient) {
    this.http = http;
  }

  loadPlayer(){
    return this.http.get("http://localhost:8080/server/api/rest/loadAllPlayer");
  }

  updateProject(project:Project){
    return this.http.put("http://localhost:8080/server/api/rest/updateProject/" + project.projectId, project);
  }

  deleteProject(project:Project){
    return this.http.delete("http://localhost:8080/server/api/rest/deleteProject/" + project.projectId);
  }

  addInteraction(project:Project, interaction:string){
    return this.http.put("http://localhost:8080/server/api/rest/addInteraction/" + interaction, project);
  }
}