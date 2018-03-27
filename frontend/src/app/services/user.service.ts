import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Endpoints } from '../constant/endpoints.constant';
import { UserList } from '../models/user.model';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }

  lookup(): Observable<UserList[]> {
    return this.http.get<UserList[]>(Endpoints.USER.lookup);
  }
}
