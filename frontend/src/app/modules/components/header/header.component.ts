import { Component } from '@angular/core';
import { AuthenticationService } from '../../../services/authentication.service';
import { SecurityService } from '../../../services/security.service';
import { States } from '../../../constant/states.constant';
import { Router } from '@angular/router';

@Component({
  selector: 'l-it-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

  constructor(private authenticationService: AuthenticationService,
              private securityService: SecurityService,
              private router: Router) {
  }

  logOut() {
    this.authenticationService.logOut();
  }

  isLoggedIn = () => this.securityService.isLoggedIn();

  createAccount() {
    this.router.navigateByUrl(States.ACCOUNT_CREATE);
  }

  createTransaction() {
    this.router.navigateByUrl(States.TRANSACTION_CREATE);
  }

}
