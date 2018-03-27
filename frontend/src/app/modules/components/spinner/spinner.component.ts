import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { SpinnerService } from './spinner.service';
import { SpinnerState } from '../../../models/spinner.model';

@Component({
  selector: 'l-it-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.scss']
})
export class SpinnerComponent implements OnInit, OnDestroy {

  show = false;
  private subscription: Subscription;

  constructor(private spinnerService: SpinnerService) {
  }

  ngOnInit() {
    this.subscription = this.spinnerService.getLoaderSubject()
      .subscribe((state: SpinnerState) => {
        this.show = state.show;
      });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
