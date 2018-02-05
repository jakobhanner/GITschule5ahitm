import { Brand } from "./brand";
import { Company } from "./company";
import { Store } from "./store";

export class Camera {
    camId:number;
    name:string;
    amount:number;
    constructor(camId:number, name:string, amount:number){
        this.camId = camId;
        this.name = name;
        this.amount = amount;
    }
}