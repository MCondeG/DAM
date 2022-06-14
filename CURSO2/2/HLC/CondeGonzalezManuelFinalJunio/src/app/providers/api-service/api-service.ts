import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { InterfaceProvider } from './InterfaceProvider';

@Injectable()
export class ApiServiceProvider  {

    private URL = "http://localhost:3000";

    constructor(public http: HttpClient) {
    }
}