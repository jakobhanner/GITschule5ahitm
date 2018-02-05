import { Injectable } from '@angular/core'; 
import { HttpClient } from '@angular/common/http';
import { Brand } from "./brand";
import { Company } from "./company";
import { Store } from "./store";
import { Camera } from "./camera";

@Injectable()
export class RestService {
  private testBool:boolean = false;
  private http;
  constructor(http: HttpClient) {
    this.http = http;
  }

  findAllCompanies() {
    return this.http.get("http://localhost:8080/server/api/rest/findAllCompanies");
  }

  findAllStores(cID:string){
    return this.http.get("http://localhost:8080/server/api/rest/findStoreByComp/" + cID);
    
  }

  findAllBrands(sID:string){
    return this.http.get("http://localhost:8080/server/api/rest/findBrandByStore/" + sID);
    
  }

  findAllCameras(bID:string){
    return this.http.get("http://localhost:8080/server/api/rest/findCamsByBrand/" + bID);
    
  }

}

