import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth-guard/auth-guard';
import { AuthComponent } from './auth/auth.component';
import { CurrencyConvertComponent } from './currency-convert/currency-convert.component';

const routes: Routes = [
  { path: '', redirectTo: '/auth', pathMatch: 'full'},
  { path: 'currency', component: CurrencyConvertComponent, canActivate: [AuthGuard]},
  { path: 'auth', component: AuthComponent},
  { path: '**', redirectTo: '/auth'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
