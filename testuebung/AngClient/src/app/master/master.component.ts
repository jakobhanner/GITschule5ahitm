import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Company } from '../company';
import { Store } from '../store';
import { Brand } from '../brand';
import { Camera } from '../camera';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {

  private rest;

  private companies:Array<Company> = new Array();
  private stores:Array<Store>;
  private brands:Array<Brand>;
  private cameras:Array<Camera>;

  private selectedCompany:Company;
  private selectedStore:Store;
  private selectedBrand:Brand;
  private selectedCamera:Camera;
  
  constructor(rest: RestService) {
    this.rest = rest;
  }

  initDB(){
    this.rest.findAllCompanies().subscribe(data => {this.companies = data});
  }

  ngOnInit() {
    console.log(this.companies.length)
  }

  selectedCo(co:Company){
    this.selectedCompany = co;
    this.rest.findAllStores(co.companyId).subscribe(data => {this.stores = data});    
  }

  selectedS(s:Store){
    this.selectedStore = s;
    this.rest.findAllStores(s.storeId).subscribe(data => {this.stores = data});    
  }

  selectedB(b:Brand){
    this.selectedBrand = b;
    this.rest.findAllStores(b.brandId).subscribe(data => {this.stores = data});    
  }

}
