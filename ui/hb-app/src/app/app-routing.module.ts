import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {BankAccountComponent} from './component-bank-account/bank-account.component';
import {BankAccountFormComponent} from "./bank-account-form/bank-account-form.component";
import {Transactions} from "./transactions/transactions.component";
import {OnetimeTransactionModifyComponent} from "./onetime-transaction-modify/onetime-transaction-modify.component";
import {CyclicTransactionModifyComponent} from "./cyclic-transaction-modify/cyclic-transaction-modify.component";

const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'accounts', component: BankAccountComponent},
  {path: 'accountCreate', component: BankAccountFormComponent},
  {path: 'accountEdit/:id', component: BankAccountFormComponent},
  {path: 'transactions', component: Transactions},
  {path: 'onetimeModify/:id', component: OnetimeTransactionModifyComponent},
  {path: 'cyclicModify/:id', component: CyclicTransactionModifyComponent},
  {path: 'costCreate', component: CyclicTransactionModifyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
