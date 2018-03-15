import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { SecurityService } from './security.service';
import { AuthenticationService } from './authentication.service';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [
    SecurityService,
    AuthenticationService
  ]
})
export class ServicesModule {
}
