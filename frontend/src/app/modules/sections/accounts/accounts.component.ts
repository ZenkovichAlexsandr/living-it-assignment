import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountList } from '../../../models/accounts.model';
import { States } from '../../../constant/states.constant';

@Component({
  selector: 'l-it-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: [ './accounts.component.scss' ]
})
export class AccountsComponent implements OnInit {
  accounts: AccountList[] = [];

  constructor(private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.accounts = this.route.snapshot.data[ 'accounts' ]
  }

  create() {
    this.router.navigateByUrl(States.ACCOUNT_CREATE);
  }
}
