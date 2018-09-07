import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {BankAccountComponent} from './component-bank-account/bank-account.component';
import {BankAccountFormComponent} from "./bank-account-form/bank-account-form.component";

const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'accounts', component: BankAccountComponent},
  {path: 'accountCreate', component: BankAccountFormComponent},
  {path: 'accountEdit/:id', component: BankAccountFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
