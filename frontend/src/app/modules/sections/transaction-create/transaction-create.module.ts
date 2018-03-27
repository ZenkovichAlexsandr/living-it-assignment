import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TransactionCreateComponent } from './transaction-create.component';
import { TransactionCreateRoutingModule } from './transaction-create-routing.module';
import { AccountsResolver } from '../accounts/accounts.resolver';
import { MatButtonModule, MatIconModule, MatInputModule, MatSelectModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatSelectModule,
    TransactionCreateRoutingModule
  ],
  declarations: [ TransactionCreateComponent ],
  exports: [ TransactionCreateComponent ],
  providers: [ AccountsResolver ]
})
export class TransactionCreateModule {
}
