import { Brand } from "./brand";
import { Camera } from "./camera";
import { Store } from "./store";

export class Company {
    companyId:number;
    companyName:string;
    ceo:string;
    stores:Array<Store>;
    constructor(companyId:number, companyName:string, ceo:string, stores:Array<Store>){
        this.companyId = companyId;
        this.companyName = companyName;
        this.ceo = ceo;
        this.stores = stores;
    }
}