import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Endpoints } from '../constant/endpoints.constant';
import { AuthConstants } from '../constant/auth.constant';
import { States } from '../constant/states.constant';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationService {

  constructor(private httpClient: HttpClient,
              private router: Router) {
  }

  login(loginRequest: FormData): Observable<any> {
    //TODO: any
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json');

    return this.httpClient.post<any>(Endpoints.AUTH.login, JSON.stringify(loginRequest), {
      headers,
      withCredentials: true
    }).do(token => {
      localStorage.setItem(AuthConstants.AUTH_TOKEN_NAME, token.access_token);
      this.router.navigateByUrl(States.PAGE);
    });
  }
}
