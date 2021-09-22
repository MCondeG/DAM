import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

    validations_form: FormGroup;
    genders: Array<string>;

    constructor(
        public formBuilder: FormBuilder,
        private navCtrl: NavController
    ) { }

    ngOnInit() {

        this.genders = [
            "Male",
            "Female"
        ];
        this.validations_form = this.formBuilder.group({
            username: new FormControl('', Validators.compose([
                this.inValidUsername,
                Validators.maxLength(25),
                Validators.minLength(5),
                Validators.pattern('^[a-zA-Z]{1}[a-zA-Z0-9]+$'),
                Validators.required
            ])),
            password: new FormControl("", Validators.required),
            confirmpassword: new FormControl("", Validators.required),
            name: new FormControl('', Validators.required),
            lastname: new FormControl('', Validators.required),
            email: new FormControl('', Validators.compose([
                Validators.required,
                Validators.pattern('^[a-zA-Z0-9_.+-]+[@]{1}[a-zA-Z0-9-]+[.]{1}[a-zA-Z]+$')
            ])),
            gender: new FormControl(this.genders[0], Validators.required),
            terms: new FormControl(false, Validators.pattern('true'))
        });
    }

    onSubmit(values) {
        console.log(values);
        let navigationExtras: NavigationExtras = {
            queryParams: {
                user: JSON.stringify(values),
                numero: 3
            }
        };
        this.navCtrl.navigateForward('/user', navigationExtras);
    }

    inValidUsername(fc: FormControl) {
        if (fc.value.toLowerCase() === "abc123" || fc.value.toLowerCase() === "cba321") {
            return ({ inValidUsername: true });
        } else {
            return (null);
        }
    }

}//end_class