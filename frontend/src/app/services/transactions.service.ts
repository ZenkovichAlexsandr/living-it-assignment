import { Injectable } from '@angular/core';
import { CreateService } from './create.service';
import { Transaction } from '../models/transactions.model';
import { HttpClient } from '@angular/common/http';
import { Endpoints } from '../constant/endpoints.constant';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TransactionsService extends CreateService<Transaction> {
  constructor(private http: HttpClient) {
    super();
  }

  create(formData: FormData): Observable<Transaction> {
    return this.http.post<Transaction>(Endpoints.TRANSACTION.base, formData);
  }
}
