import { Injectable } from '@angular/core';
import { Icons, ToastNotification } from '../../../models/notification.model';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class ToastNotificationService {
  private notificationEmitter: Subject<ToastNotification> = new Subject<ToastNotification>();
  private closeAllEmitter: Subject<string> = new Subject<string>();
  private icons: Icons = defaultIcons;

  getNotificationEmitter() {
    return this.notificationEmitter;
  }

  getCloseAllEmitter() {
    return this.closeAllEmitter;
  }

  success(content: string[], closable = false, autoClosable = true, group: string = '') {
    return this.set({
      content: content,
      type: 'success',
      icon: this.icons.success,
      closable,
      autoClosable,
      group: group
    });
  }

  info(content: string[], closable = false, autoClosable = true, group: string = '') {
    return this.set({content: content, type: 'info', icon: this.icons.info, closable, autoClosable, group: group});
  }

  error(content: string[], closable = true, autoClosable = false, group: string = '') {
    return this.set({content: content, type: 'error', icon: this.icons.error, closable, autoClosable, group: group});
  }

  set(notification: ToastNotification) {
    this.notificationEmitter.next(notification);
    return notification;
  }

  close(group: string = '') {
    this.closeAllEmitter.next(group);
  }
}

export const defaultIcons: Icons = {
  error: 'warning',
  info: 'info',
  success: 'check_circle',
};
