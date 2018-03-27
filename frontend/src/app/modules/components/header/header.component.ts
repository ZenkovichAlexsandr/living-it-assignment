import { Component } from '@angular/core';
import { AuthenticationService } from '../../../services/authentication.service';
import { SecurityService } from '../../../services/security.service';

@Component({
  selector: 'l-it-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

  constructor(private authenticationService: AuthenticationService,
              private securityService: SecurityService) {
  }

  logOut() {
    this.authenticationService.logOut();
  }

  isLoggedIn = () => this.securityService.isLoggedIn();

}
