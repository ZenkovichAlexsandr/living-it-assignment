import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { User } from '../../../models/user.model';
import { Observable } from 'rxjs/Observable';
import { UserService } from '../../../services/user.service';

@Injectable()
export class AccountCreateResolver implements Resolve<User[]> {
  constructor(private userService: UserService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<User[]> {
    return this.userService.lookup();
  }
}
