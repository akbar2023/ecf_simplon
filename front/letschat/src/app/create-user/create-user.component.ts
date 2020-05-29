import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserApiService} from "../service/user-api.service";
import {Router} from "@angular/router";
import {User} from "../models/user";

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  signUpForm: FormGroup;
  errors: any;

  message: string;


  createForm() {
    this.signUpForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      birthDate: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
    })
  }

  constructor(private service: UserApiService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.createForm()
  }

  createUser() {
    // debugger;
    const user: User = {
      email: this.signUpForm.value.email,
      password: this.signUpForm.value.password,
      firstName: this.signUpForm.value.firstName,
      lastName: this.signUpForm.value.lastName,
      birthDate: this.signUpForm.value.birthDate,
      lastKnownPresence: Date.now().toString(),
    }
    this.service.createUser(user).subscribe(result => {
        // Handle result
        console.log(result)
        // this.service.id = result.body.id;
      alert("success!")
      },
      error => {
        this.errors = error;
        console.log(this.errors, "--errors");
        alert(this.errors.status + " Error");
      },
      () => {
        // 'onCompleted' callback.
        // No errors, route to new page here
        this.router.navigate(['login'])
          .then(r => console.log(r));
      });
  }

}
