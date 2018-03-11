import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login.component';

import { LoginGuard } from '../../../guards/login.guard';

const loginRoutes: Routes = [
  {
    path: '',
    component: LoginComponent,
    canActivate: [ LoginGuard ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(loginRoutes)
  ],
  exports: [ RouterModule ]
})
export class LoginRoutingModule {

}
