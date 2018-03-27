import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountList } from '../../../models/accounts.model';
import { User } from '../../../models/user.model';
import { AuthConstants } from '../../../constant/auth.constant';
import { States } from '../../../constant/states.constant';

@Component({
  selector: 'l-it-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: [ './accounts.component.scss' ]
})
export class AccountsComponent {
  accounts: AccountList[] = [];
  user: User;

  constructor(private route: ActivatedRoute,
              private router: Router) {
    this.user = JSON.parse(localStorage.getItem(AuthConstants.USER)) as User;
    this.accounts = this.route.snapshot.data[ 'accounts' ]
  }

  accountDetails(id: number) {
    this.router.navigateByUrl(States.ACCOUNT_DETAILS(id));
  }
}
