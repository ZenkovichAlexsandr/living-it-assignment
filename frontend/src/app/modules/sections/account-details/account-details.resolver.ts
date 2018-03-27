import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { AccountDetails } from '../../../models/accounts.model';
import { AccountsService } from '../../../services/accounts.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AccountDetailsResolver implements Resolve<AccountDetails> {
  constructor(private service: AccountsService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AccountDetails> {
    return this.service.findOne(route.params[ 'id' ]);
  }
}
