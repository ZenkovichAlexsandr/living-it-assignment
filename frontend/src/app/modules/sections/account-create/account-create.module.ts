import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountCreateComponent } from './account-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule, MatIconModule, MatInputModule, MatSelectModule } from '@angular/material';
import { AccountCreateRoutingModule } from './account-create-routing.module';
import { AccountCreateResolver } from './account-create.resolver';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatSelectModule,
    AccountCreateRoutingModule
  ],
  declarations: [ AccountCreateComponent ],
  exports: [ AccountCreateComponent ],
  providers: [ AccountCreateResolver ]
})
export class AccountCreateModule {
}
