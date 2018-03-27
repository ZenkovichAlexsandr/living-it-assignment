import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountsResolver } from '../accounts/accounts.resolver';
import { TransactionCreateComponent } from './transaction-create.component';

const transactionCreateRoutes: Routes = [
  {
    path: '',
    component: TransactionCreateComponent,
    resolve: {
      accounts: AccountsResolver
    }
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(transactionCreateRoutes)
  ],
  exports: [ RouterModule ]
})
export class TransactionCreateRoutingModule {

}
