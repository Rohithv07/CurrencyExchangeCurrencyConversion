import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry} from 'rxjs/operators';
import { CurrencyConversion } from './currency-conversion';
import { CurrencyExchange } from './currency-exchange';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http: HttpClient) { }

  getConversionRate(): Observable<CurrencyExchange[]> {
    const url = `http://localhost:8765/currency-exchange/all`;
    return this.http.get<CurrencyExchange[]>(url).pipe(
      retry(5),
      catchError(this.handleError)
    );

  }

  getCalculateAmount(from: string, to: string, amount: number): Observable<CurrencyConversion> {
    const url = `http://localhost:8765/currency-conversion/from/${from}/to/${to}/quantity/${amount}`;
    return this.http.get<CurrencyConversion>(url).pipe(
      retry(5),
      catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occured', error.error);
    }
    else {
      console.error(
        `Backend returned error code ${error.status}` +
        `body was : ${error.error}`
      );
    }
    return throwError(
      'Something happened; Please try again later.'
    );
  }

  }
  

