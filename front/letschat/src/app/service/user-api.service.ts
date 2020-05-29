import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import {UserLogin} from "../models/user-login";
import {stringify} from "querystring";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  user?: UserLogin;
  id: number;

  apiUrl = "http://localhost:9090/user";

  constructor(private http: HttpClient) { }

  public login(user: UserLogin): Observable<any> {
    this.user = user;
    // debugger;
    return this.http.post(`${this.apiUrl}/login`,user, {observe: 'response'});
  }

  public getProfile(): Observable<any> {
    // debugger
    return this.http.post(`${this.apiUrl}/profile/${this.id}`, this.user)
  }

  public createUser(newUser: User): Observable<any> {
    return this.http.post(`${this.apiUrl}/new`, newUser, {observe: 'response'})
  }

}
