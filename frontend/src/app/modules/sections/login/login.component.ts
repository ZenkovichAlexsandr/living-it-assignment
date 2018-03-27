import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../../services/authentication.service';
import { ToastNotificationService } from '../../components/toast-notifications/toast-notification.service';
import { SpinnerService } from '../../components/spinner/spinner.service';
import { Router } from '@angular/router';
import { States } from '../../../constant/states.constant';
import { AuthConstants } from '../../../constant/auth.constant';

@Component({
  selector: 'l-it-login',
  templateUrl: './login.component.html',
  styleUrls: [ './login.component.scss' ]
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  username: FormControl;
  password: FormControl;

  constructor(private formBuilder: FormBuilder,
              private authenticationService: AuthenticationService,
              private toastNotificationService: ToastNotificationService,
              private spinnerService: SpinnerService,
              private router: Router) {

  }

  ngOnInit() {
    this.username = new FormControl('', [ Validators.required ]);
    this.password = new FormControl('', [ Validators.required ]);

    this.loginForm = this.formBuilder.group({
      username: this.username,
      password: this.password
    });
  }

  onLogin() {
    if (!this.loginForm.valid) {
      this.toastNotificationService.error([ 'There are some validation errors.' ]);
      return;
    }

    this.spinnerService.show();
    this.authenticationService.login(this.loginForm.value)
      .mergeMap(() => {
        return this.authenticationService.getMe();
      })
      .subscribe(
        data => {
          this.toastNotificationService.close();
          this.spinnerService.hide();
          localStorage.setItem(AuthConstants.USER, JSON.stringify(data));
          this.router.navigateByUrl(States.ACCOUNTS);
        },
        error => {
          this.toastNotificationService.error([ error.error.message ]);
          this.spinnerService.hide();
        }
      );
  }
}
