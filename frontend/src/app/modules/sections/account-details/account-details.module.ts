import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountDetailsComponent } from './account-details.component';
import { AccountDetailsRoutingModule } from './account-details-routing.module';
import { AccountDetailsResolver } from './account-details.resolver';

@NgModule({
  imports: [
    CommonModule,
    AccountDetailsRoutingModule
  ],
  declarations: [ AccountDetailsComponent ],
  exports: [ AccountDetailsComponent ],
  providers: [ AccountDetailsResolver ]
})
export class AccountDetailsModule {
}
