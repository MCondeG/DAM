import {Gender} from './Gender'

export interface User {
    username: string;
    name: string;
    lastname:string;
    email:string;
    gender:Gender;
    terms:boolean;
}