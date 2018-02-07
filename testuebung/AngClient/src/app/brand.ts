import { Camera } from "./camera";
import { Company } from "./company";
import { Store } from "./store";

export class Brand {
    brandId:number;
    brandName:string;
    location:string;
    contactPerson:string;
    cameras:Array<Camera>;

    constructor(brandId:number, brandName:string, location:string, contactPerson:string, cameras:Array<Camera>){
        this.brandId = brandId;
        this.brandName = brandName;
        this.location = location;
        this.contactPerson = contactPerson;
        this.cameras = cameras;
    }
}