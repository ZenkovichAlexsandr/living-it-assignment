import { Component, OnInit, OnDestroy } from '@angular/core';
import { animate, style, transition, trigger } from '@angular/animations';
import { Subscription } from 'rxjs/Subscription';
import { ToastNotificationService } from './toast-notification.service';

@Component({
  selector: 'l-it-toast-notifications',
  templateUrl: './toast-notifications.component.html',
  styleUrls: ['./toast-notifications.component.scss'],
  animations: [
    trigger(
      'notificationAnimation',
      [
        transition(
          ':enter', [
            style({transform: 'scale(1.0)', opacity: 0}),
            animate('300ms', style({transform: 'scale(1.0)', 'opacity': 1}))
          ]
        ),
        transition(
          ':leave', [
            style({transform: 'scale(1.0)', 'opacity': 1}),
            animate('300ms', style({transform: 'scale(1.0)', 'opacity': 0}))
          ]
        )
      ]
    )
  ]
})
export class ToastNotificationsComponent implements OnInit, OnDestroy {
  isOpened = false;
  type = '';
  messages: string[] = [];
  icon = '';
  closable = true;
  autoClosable = false;
  group: string;

  private notificationEmitter: Subscription;
  private closeAllEmitter: Subscription;
  private hideTimeout;

  constructor(private notificationService: ToastNotificationService) { }

  ngOnInit() {
    this.notificationEmitter = this.notificationService.getNotificationEmitter().subscribe(message => {
      this.type = message.type;
      this.icon = message.icon;
      this.messages = message.content;
      this.closable = message.closable;
      this.autoClosable = message.autoClosable;
      this.group = message.group;

      this.isOpened = true;

      if (!!this.hideTimeout) {
        this.removeTimeout(this.hideTimeout);
      }
      if (message.autoClosable) {
        this.hideTimeout = setTimeout(() => this.onClose(), 5000);
      }
    });

    this.closeAllEmitter = this.notificationService.getCloseAllEmitter().subscribe(group => {
      if (!this.autoClosable && (group === '' || this.group === group)) {
        this.onClose();
      }
    });
  }

  ngOnDestroy(): void {
    if (this.notificationEmitter) {
      this.notificationEmitter.unsubscribe();
    }

    if (this.closeAllEmitter) {
      this.closeAllEmitter.unsubscribe();
    }
  }

  onClose() {
    this.isOpened = false;
    this.cleanUp();
  }

  private cleanUp() {
    this.type = '';
    this.messages.length = 0;
    this.icon = '';
    this.closable = true;

    this.removeTimeout(this.hideTimeout);
  }

  private removeTimeout(timeout: any) {
    if (timeout) {
      clearTimeout(timeout);
      timeout = null;
    }
  }

}
