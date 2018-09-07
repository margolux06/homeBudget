import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { BankAccountComponent } from './component-bank-account/bank-account.component';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BankAccountService } from './component-bank-account/services/bank-account-service.service';
import { BankAccountFormComponent } from './bank-account-form/bank-account-form.component';


@NgModule({
  declarations: [
    AppComponent,
    BankAccountComponent,
    DashboardComponent,
    BankAccountFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],

  providers: [BankAccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
