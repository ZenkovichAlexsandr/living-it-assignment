import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastNotificationsComponent } from './toast-notifications.component';
import { ToastNotificationService } from './toast-notification.service';
import { MatIconModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatIconModule
  ],
  declarations: [ ToastNotificationsComponent ],
  exports: [ ToastNotificationsComponent ],
  providers: [ ToastNotificationService ]
})
export class ToastNotificationsModule {
}
