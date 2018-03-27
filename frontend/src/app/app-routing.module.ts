import { NgModule } from '@angular/core';
import {
  Routes, RouterModule
} from '@angular/router';
import { States } from './constant/states.constant';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: States.LOGIN,
    loadChildren: './modules/sections/login/login.module#LoginModule'
  },
  {
    path: States.ACCOUNTS,
    loadChildren: './modules/sections/accounts/accounts.module#AccountsModule',
    canLoad: [ AuthGuard ]
  },
  {
    path: States.ACCOUNT_CREATE,
    loadChildren: './modules/sections/account-create/account-create.module#AccountCreateModule',
    canLoad: [ AuthGuard ]
  },
  {
    path: '',
    redirectTo: States.ACCOUNTS,
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: States.LOGIN
  }
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
