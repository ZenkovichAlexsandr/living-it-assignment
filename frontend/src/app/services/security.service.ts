import { Injectable } from '@angular/core';
import { AuthConstants } from '../constant/auth.constant';

@Injectable()
export class SecurityService {

  constructor() {
  }

  isLoggedIn() {
    return !!localStorage.getItem(AuthConstants.AUTH_TOKEN_NAME);
  }
}
