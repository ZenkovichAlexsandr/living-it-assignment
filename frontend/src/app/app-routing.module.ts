import { Injectable, NgModule } from '@angular/core';
import {
  Routes, RouterModule, NavigationStart, Router, CanActivate, ActivatedRouteSnapshot,
  RouterStateSnapshot
} from '@angular/router';
import { States } from './constant/states.constant';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: States.LOGIN,
    loadChildren: './modules/sections/login/login.module#LoginModule'
  },
  {
    path: '',
    loadChildren: './modules/sections/page/page.module#PageModule',
    canLoad: [ AuthGuard ]
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
