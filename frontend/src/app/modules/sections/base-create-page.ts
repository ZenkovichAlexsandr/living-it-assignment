import { FormGroup } from '@angular/forms';
import { OnInit } from '@angular/core';
import { States } from '../../constant/states.constant';
import { SpinnerService } from '../components/spinner/spinner.service';
import { Router } from '@angular/router';
import { ToastNotificationService } from '../components/toast-notifications/toast-notification.service';
import { CreateService } from '../../services/create.service';

export abstract class BaseCreatePage<T> implements OnInit {
  protected form: FormGroup;

  constructor(protected toastNotificationService: ToastNotificationService,
              protected spinnerService: SpinnerService,
              protected service: CreateService<T>,
              protected router: Router) {

  }

  ngOnInit() {
    this.buildForm();
  }

  abstract buildForm();

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
