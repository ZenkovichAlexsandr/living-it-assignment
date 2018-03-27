import { Component, OnInit } from '@angular/core';
import { AccountDetails } from '../../../models/accounts.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'l-it-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.scss']
})
export class AccountDetailsComponent {
  accountDetails: AccountDetails;

  constructor(private route: ActivatedRoute) {
    this.accountDetails = this.route.snapshot.data[ 'accountDetails' ];
  }
}
