import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CurrencyConvertComponent } from './currency-convert/currency-convert.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CurrencyExchangeRateComponent } from './currency-exchange-rate/currency-exchange-rate.component';
import { AuthComponent } from './auth/auth.component';
import { RouterModule } from '@angular/router';
import { LoadingSpinnerComponent } from './shared/loading-spinner/loading-spinner.component';



@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CurrencyConvertComponent,
    CurrencyExchangeRateComponent,
    AuthComponent,
    LoadingSpinnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    RouterModule,
    BrowserAnimationsModule,
    FormsModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
