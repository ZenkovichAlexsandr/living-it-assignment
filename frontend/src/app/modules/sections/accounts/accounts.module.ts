import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountsComponent } from './accounts.component';
import { AccountsRoutingModule } from './accounts-routing.module';
import { AccountsResolver } from './accounts.resolver';
import { MatButtonModule } from '@angular/material';
import { AccountCreateModule } from '../account-create/account-create.module';

@NgModule({
  imports: [
    CommonModule,
    AccountsRoutingModule,
    MatButtonModule,
    AccountCreateModule
  ],
  declarations: [ AccountsComponent ],
  exports: [ AccountsComponent ],
  providers: [ AccountsResolver ]
})
export class AccountsModule {
}
