import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { SecurityService } from './security.service';
import { AuthenticationService } from './authentication.service';
import { AccountsService } from './accounts.service';
import { UserService } from './user.service';
import { TransactionsService } from './transactions.service';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [
    SecurityService,
    AccountsService,
    AuthenticationService,
    UserService,
    TransactionsService
  ]
})
export class ServicesModule {
}
