import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccountsComponent } from './accounts.component';
import { AccountsResolver } from './accounts.resolver';

const accountRoutes: Routes = [
  {
    path: '',
    component: AccountsComponent,
    resolve: {
      accounts: AccountsResolver
    }
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(accountRoutes)
  ],
  exports: [ RouterModule ]
})
export class AccountsRoutingModule {

}
