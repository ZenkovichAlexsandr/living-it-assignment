import { environment } from '../../environments/environment';

class Auth {
  static readonly login = `${environment.gateway}/auth/login`;
}

class Accounts {
  static readonly base = `${environment.gateway}/account`;
}

class User {
  static readonly lookup = `${environment.gateway}/user`;
}

class Transaction {
  static readonly base = `${environment.gateway}/transaction`;
}

export class Endpoints {
  static readonly AUTH = Auth;
  static readonly ACCOUNTS = Accounts;
  static readonly TRANSACTION = Transaction;
  static readonly USER = User;

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
