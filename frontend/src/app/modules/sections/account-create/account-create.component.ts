import { Component, OnInit } from '@angular/core';
import { UserList } from '../../../models/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DecimalValidator } from '../../../validators/decimal.validator';
import { ToastNotificationService } from '../../components/toast-notifications/toast-notification.service';
import { AccountsService } from '../../../services/accounts.service';
import { SpinnerService } from '../../components/spinner/spinner.service';
import { States } from '../../../constant/states.constant';

@Component({
  selector: 'l-it-account-create',
  templateUrl: './account-create.component.html',
  styleUrls: [ './account-create.component.scss' ]
})
export class AccountCreateComponent implements OnInit {
  userList: UserList[] = [];

  form: FormGroup;
  name: FormControl;
  money: FormControl;
  users: FormControl;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private toastNotificationService: ToastNotificationService,
              private spinnerService: SpinnerService,
              private service: AccountsService,
              private router: Router) {
    this.userList = this.route.snapshot.data[ 'userList' ]
  }

  ngOnInit() {
    this.name = new FormControl('', [ Validators.required ]);
    this.money = new FormControl('', [ Validators.required, DecimalValidator.validate ]);
    this.users = new FormControl('', [ Validators.required ]);

    this.form = this.formBuilder.group({
      name: this.name,
      money: this.money,
      users: this.users
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.create();
    } else {
      this.toastNotificationService.error([ "There are some validation errors." ]);
    }
  }

  private create() {
    this.spinnerService.show();
    this.service.create(this.form.value)
      .subscribe(
        () => {
          this.toastNotificationService.close();
          this.toastNotificationService.success([ 'The changes have been saved successfully.' ])
          this.spinnerService.hide();
          this.router.navigateByUrl(States.ACCOUNTS);
        },
        error => {
          this.toastNotificationService.error([ error.error.message ]);
          this.spinnerService.hide();
        }
      )
  }
}
