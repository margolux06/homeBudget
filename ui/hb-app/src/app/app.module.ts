import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {BankAccountComponent} from './component-bank-account/bank-account.component';
import {AppRoutingModule} from './app-routing.module';
import {DashboardComponent} from './dashboard/dashboard.component';
import {BankAccountService} from './component-bank-account/services/bank-account-service.service';
import {BankAccountFormComponent} from './bank-account-form/bank-account-form.component';
import {AccountBalanceService} from "./account-balance/services/account-balance.service";
import {AccountBalanceComponent} from './account-balance/account-balance.component';
import {Transactions} from './transactions/transactions.component';
import {OneTimeTransactionService} from "./transactions/services/one-time-transaction.service";
import {OnetimeTransactionModifyComponent} from './onetime-transaction-modify/onetime-transaction-modify.component';
import {CyclicTransactionService} from "./transactions/services/cyclic-transaction.service";
import {CyclicTransactionModifyComponent} from './cyclic-transaction-modify/cyclic-transaction-modify.component';
import {DateValueAccessorModule} from "angular-date-value-accessor";
import {NKDatetimeModule} from 'ng2-datetime/ng2-datetime';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MAT_DATE_FORMATS,
  MatCheckboxModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  NativeDateModule
} from '@angular/material';
import {CyclicTransactionPeriodService} from "./transactions/services/cyclic-transaction-period.service";

export const MY_NATIVE_DATE_FORMATS= {
  parse: {
    dateInput: 'DD MMM YYYY',
  },
  display: {
    dateInput: 'DD MMM YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@NgModule({
  declarations: [
    AppComponent,
    BankAccountComponent,
    DashboardComponent,
    BankAccountFormComponent,
    AccountBalanceComponent,
    Transactions,
    OnetimeTransactionModifyComponent,
    CyclicTransactionModifyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NKDatetimeModule,
    DateValueAccessorModule,
    NativeDateModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatSelectModule,
    MatDatepickerModule
  ],

  providers: [
    BankAccountService, AccountBalanceService, OneTimeTransactionService, CyclicTransactionService, CyclicTransactionPeriodService,
    {provide: MAT_DATE_FORMATS, useValue: MY_NATIVE_DATE_FORMATS}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
