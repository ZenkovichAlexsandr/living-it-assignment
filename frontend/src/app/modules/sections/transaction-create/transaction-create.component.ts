import { Component } from '@angular/core';
import { BaseCreatePage } from '../base-create-page';
import { Transaction } from '../../../models/transactions.model';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { SpinnerService } from '../../components/spinner/spinner.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastNotificationService } from '../../components/toast-notifications/toast-notification.service';
import { AccountList } from '../../../models/accounts.model';
import { TransactionsService } from '../../../services/transactions.service';
import { DecimalValidator } from '../../../validators/decimal.validator';

@Component({
  selector: 'l-it-transaction-create',
  templateUrl: './transaction-create.component.html',
  styleUrls: ['./transaction-create.component.scss']
})
export class TransactionCreateComponent extends BaseCreatePage<Transaction> {
  accounts: AccountList[] = [];
  money: FormControl;
  from: FormControl;
  to: FormControl;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              toastNotificationService: ToastNotificationService,
              spinnerService: SpinnerService,
              service: TransactionsService,
              router: Router) {
    super(toastNotificationService, spinnerService, service, router);
    this.accounts = this.route.snapshot.data[ 'accounts' ]
  }

  buildForm() {
    this.from = new FormControl(null, [ Validators.required ]);
    this.money = new FormControl(null, [ Validators.required, DecimalValidator.validate ]);
    this.to = new FormControl(null, [ Validators.required ]);

    this.form = this.formBuilder.group({
      to: this.to,
      money: this.money,
      from: this.from
    });
  }
}
