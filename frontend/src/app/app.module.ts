import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GuardsModule } from './guards/guards.module';
import { InterceptorsModule } from './services/interceptor/interceptors.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServicesModule } from './services/services.module';

import 'hammerjs';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/observable/empty';
import 'rxjs/add/observable/forkJoin';
import { HeaderModule } from './modules/components/header/header.module';
import { ToastNotificationsModule } from './modules/components/toast-notifications/toast-notifications.module';
import { SpinnerModule } from './modules/components/spinner/spinner.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    GuardsModule,
    ServicesModule,
    AppRoutingModule,
    InterceptorsModule,
    BrowserAnimationsModule,
    HeaderModule,
    ToastNotificationsModule,
    SpinnerModule
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule {
}
