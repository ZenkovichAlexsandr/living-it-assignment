import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Account, AccountList } from '../models/accounts.model';
import { Endpoints } from '../constant/endpoints.constant';
import { CreateService } from './create.service';

@Injectable()
export class AccountsService extends CreateService<Account> {
  constructor(private http: HttpClient) {
    super();
  }

  findAll(): Observable<AccountList[]> {
    return this.http.get<AccountList[]>(Endpoints.ACCOUNTS.base);
  }

  create(formData: FormData): Observable<Account> {
    return this.http.post<Account>(Endpoints.ACCOUNTS.base, formData);
  }
}
