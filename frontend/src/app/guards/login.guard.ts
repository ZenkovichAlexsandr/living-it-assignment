import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Route, Router, CanLoad } from '@angular/router';
import { SecurityService } from '../services/security.service';

@Injectable()
export class LoginGuard implements CanActivate, CanLoad {

  constructor(private securityService: SecurityService, private router: Router) {
  }

  canLoad(route: Route): boolean {
    return this.checkLogin();
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    return this.checkLogin();
  }

  checkLogin(): boolean {
    if (!this.securityService.isLoggedIn()) {
      return true;
    }

    this.router.navigate([ '/' ]);
    return false;
  }
}
