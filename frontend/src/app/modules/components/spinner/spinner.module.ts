import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpinnerComponent } from './spinner.component';
import { SpinnerService } from './spinner.service';
import { MatProgressSpinnerModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatProgressSpinnerModule
  ],
  declarations: [ SpinnerComponent ],
  exports: [ SpinnerComponent ],
  providers: [ SpinnerService ]
})
export class SpinnerModule {
}
