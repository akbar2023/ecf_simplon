import {Component, OnInit} from '@angular/core';
import {UserApiService} from "../service/user-api.service";
import {UserLogin} from "../models/user-login";
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  errors: any;


  createForm() {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  constructor(private service: UserApiService, private fb: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.createForm()
  }


  userLogin() {
    // debugger;
    const user: UserLogin = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    }
    this.service.login(user).subscribe(result => {
        // Handle result
        console.log(result)
        this.service.id = result.body.id;
      },
      error => {
        this.errors = error;
        console.log(this.errors, "--errors");
        alert(this.errors.status + " NOT FOUND");
      },
      () => {
        // 'onCompleted' callback.
        // No errors, route to new page here
        this.router.navigate(['home'])
          .then(r => console.log(r));
      });
  }

}
