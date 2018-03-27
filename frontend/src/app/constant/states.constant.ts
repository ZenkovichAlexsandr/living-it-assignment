export class States {
  /* tslint:disable */

  // Authentication
  static readonly LOGIN = 'login';

  static readonly ACCOUNTS = 'accounts';
  static readonly ACCOUNT_CREATE = `${States.ACCOUNTS}/create`;
  static readonly ACCOUNT_DETAILS = (id: number) => `${States.ACCOUNTS}/${id}`;

  static readonly TRANSACTION_CREATE = `transactions/create`;
  /* tslint:enable */
}
