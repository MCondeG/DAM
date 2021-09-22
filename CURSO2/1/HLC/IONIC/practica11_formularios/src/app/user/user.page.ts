import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-user',
    templateUrl: './user.page.html',
    styleUrls: ['./user.page.scss'],
})

export class UserPage implements OnInit {

    private user: any;
    private numero: number;

    constructor(private activatedRoute: ActivatedRoute) {
        this.activatedRoute.queryParams.subscribe(params => {
            this.user = params["user"];
            this.numero = JSON.parse(params["numero"]);
        });
    }

    ngOnInit() {
        console.log(this.user);
    }
}