import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailsComponent } from './account-details.component';
import { AccountDetailsResolver } from './account-details.resolver';

const accountDetailsRoutes: Routes = [
  {
    path: '',
    component: AccountDetailsComponent,
    resolve: {
      accountDetails: AccountDetailsResolver
    }
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(accountDetailsRoutes)
  ],
  exports: [ RouterModule ]
})
export class AccountDetailsRoutingModule {

}
