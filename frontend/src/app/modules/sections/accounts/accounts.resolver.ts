import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { AccountList } from '../../../models/accounts.model';
import { AccountsService } from '../../../services/accounts.service';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';

@Injectable()
export class AccountsResolver implements Resolve<AccountList[]> {
  constructor(private service: AccountsService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AccountList[]> {
    return this.service.findAll();
  }
}
