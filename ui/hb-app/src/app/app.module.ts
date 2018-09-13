import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {BankAccountComponent} from './component-bank-account/bank-account.component';
import {AppRoutingModule} from './/app-routing.module';
import {DashboardComponent} from './dashboard/dashboard.component';
import {BankAccountService} from './component-bank-account/services/bank-account-service.service';
import {BankAccountFormComponent} from './bank-account-form/bank-account-form.component';
import {AccountBalanceService} from "./account-balance/services/account-balance.service";
import {AccountBalanceComponent} from './account-balance/account-balance.component';


@NgModule({
  declarations: [
    AppComponent,
    BankAccountComponent,
    DashboardComponent,
    BankAccountFormComponent,
    AccountBalanceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],

  providers: [BankAccountService, AccountBalanceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
