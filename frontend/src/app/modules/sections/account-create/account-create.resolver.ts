import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { UserList } from '../../../models/user.model';
import { Observable } from 'rxjs/Observable';
import { UserService } from '../../../services/user.service';

@Injectable()
export class AccountCreateResolver implements Resolve<UserList[]> {
  constructor(private userService: UserService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<UserList[]> {
    return this.userService.lookup();
  }
}
