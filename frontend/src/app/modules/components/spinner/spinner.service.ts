import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { SpinnerState } from '../../../models/spinner.model';

@Injectable()
export class SpinnerService {

  private loaderSubject = new Subject<SpinnerState>();

  getLoaderSubject() {
    return this.loaderSubject;
  }

  show() {
    this.loaderSubject.next(<SpinnerState>{ show: true });
  }

  hide() {
    this.loaderSubject.next(<SpinnerState>{ show: false });
  }

}
