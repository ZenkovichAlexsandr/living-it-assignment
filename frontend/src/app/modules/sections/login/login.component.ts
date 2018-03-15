import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../../services/authentication.service';

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
              private authenticationService: AuthenticationService) {

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
    // TODO: fix
    if (!this.loginForm.valid) {
      return;
    }

    this.authenticationService.login(this.loginForm.value)
      .subscribe();
  }
}
