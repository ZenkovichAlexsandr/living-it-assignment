import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule, MatIconModule, MatInputModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule
  ],
  declarations: [
    LoginComponent
  ],
  exports: [
    LoginComponent
  ]
})
export class LoginModule {
}
