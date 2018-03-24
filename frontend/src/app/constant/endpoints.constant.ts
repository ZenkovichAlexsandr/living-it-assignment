import { environment } from '../../environments/environment';

class Auth {
  static readonly login = `${environment.gateway}/auth/login`;
}

export class Endpoints {
  static readonly AUTH = Auth;

  static readonly notSecuredEndpoints = [
    Auth.login,
  ];

  static isNotSecured(url: string): boolean {
    return Endpoints.notSecuredEndpoints.some(endpoint => url.indexOf(endpoint) >= 0);
  }

  static isSecured(url: string): boolean {
    return !Endpoints.isNotSecured(url);
  }
}
