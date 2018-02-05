import { Brand } from "./brand";
import { Camera } from "./camera";
import { Company } from "./company";

export class Store {
    storeId:number;
    location:string;
    employee:number;
    brands:Array<Brand>;
    constructor(storeId:number, location:string, employee:number, brands:Array<Brand>){
        this.storeId = storeId;
        this.location = location;
        this.employee = employee;
        this.brands = brands;
    }
}