import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {UserApiService} from "../service/user-api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  user: User;

  errors: any;

  constructor(private service: UserApiService) { }

  ngOnInit(): void {
    // debugger
    this.service.getProfile().subscribe(result => {
        // Handle result
        console.log(result)
      debugger
        this.user = result;
      },
      error => {
        this.errors = error;
        console.log(this.errors, "--errors");
        alert(this.errors.status + " NOT FOUND");
      },
      () => {
        // 'onCompleted' callback.
        // No errors, route to new page here
        console.log("Hello!")
      })
  }

}
