import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AccountCreateResolver } from './account-create.resolver';
import { AccountCreateComponent } from './account-create.component';

const accountCreateRoutes: Routes = [
  {
    path: '',
    component: AccountCreateComponent,
    resolve: {
      userList: AccountCreateResolver
    }
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(accountCreateRoutes)
  ],
  exports: [ RouterModule ]
})
export class AccountCreateRoutingModule {

}
