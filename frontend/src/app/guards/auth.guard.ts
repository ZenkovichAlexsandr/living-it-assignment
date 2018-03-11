import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanLoad, Route, Router } from '@angular/router';

import { States } from '../constant/states.constant';

import { SecurityService } from '../services/security.service';

@Injectable()
export class AuthGuard implements CanActivate, CanLoad {

  constructor(private securityService: SecurityService,
              private router: Router) {
  }

  canLoad(route: Route): boolean {
    return this.checkLogin(`/${route.path}`);
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    return this.checkLogin(state.url);
  }

  checkLogin(redirectUrl: string): boolean {
    if (this.securityService.isLoggedIn()) {
      return true;
    }

    this.redirect(redirectUrl, States.LOGIN);
    return false;
  }

  private redirect(redirectUrl: string, state: string) {
    this.router.navigate([ state ]);
  }
}
