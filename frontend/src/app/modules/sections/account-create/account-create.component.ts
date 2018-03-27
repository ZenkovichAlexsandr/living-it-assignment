import { Component } from '@angular/core';
import { UserList } from '../../../models/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { DecimalValidator } from '../../../validators/decimal.validator';
import { ToastNotificationService } from '../../components/toast-notifications/toast-notification.service';
import { AccountsService } from '../../../services/accounts.service';
import { SpinnerService } from '../../components/spinner/spinner.service';
import { BaseCreatePage } from '../base-create-page';
import { Account } from '../../../models/accounts.model';

@Component({
  selector: 'l-it-account-create',
  templateUrl: './account-create.component.html',
  styleUrls: [ './account-create.component.scss' ]
})
export class AccountCreateComponent extends BaseCreatePage<Account> {
  userList: UserList[] = [];

  name: FormControl;
  money: FormControl;
  users: FormControl;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              toastNotificationService: ToastNotificationService,
              spinnerService: SpinnerService,
              service: AccountsService,
              router: Router) {
    super(toastNotificationService, spinnerService, service, router);
    this.userList = this.route.snapshot.data[ 'userList' ]
  }

  buildForm() {
    this.name = new FormControl(null, [ Validators.required ]);
    this.money = new FormControl(null, [ Validators.required, DecimalValidator.validate ]);
    this.users = new FormControl(null, [ Validators.required ]);

    this.form = this.formBuilder.group({
      name: this.name,
      money: this.money,
      users: this.users
    });
  }
}
