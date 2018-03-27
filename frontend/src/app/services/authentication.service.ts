import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Endpoints } from '../constant/endpoints.constant';
import { AuthConstants } from '../constant/auth.constant';
import { States } from '../constant/states.constant';
import { Router } from '@angular/router';
import { LoginResponse, User } from '../models/user.model';

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient,
              private router: Router) {
  }

  login(loginRequest: FormData): Observable<LoginResponse> {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json');

    return this.http.post<LoginResponse>(Endpoints.AUTH.login, JSON.stringify(loginRequest), {
      headers
    }).do(token => {
      localStorage.setItem(AuthConstants.AUTH_TOKEN_NAME, token.token);
    });
  }

  getMe():Observable<User> {
    return this.http.get<User>(Endpoints.AUTH.getMe);
  }

  logOut() {
    localStorage.removeItem(AuthConstants.AUTH_TOKEN_NAME);
    this.router.navigateByUrl(States.LOGIN);
  }
}
