import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { CurrencyExchange } from '../currency-exchange';

@Component({
  selector: 'app-currency-exchange-rate',
  templateUrl: './currency-exchange-rate.component.html',
  styleUrls: ['./currency-exchange-rate.component.css']
})
export class CurrencyExchangeRateComponent implements OnInit {

  constructor(private apiService: ApiServiceService) { }

  currencyExchangeRate: CurrencyExchange[] = []
  ngOnInit(): void {
    this.apiService.getConversionRate().subscribe(c => {
      this.currencyExchangeRate = c;
      //console.log(c)
      console.log(this.currencyExchangeRate);
    });
  }

  displayedColumns: string[] = ['id', 'from', 'to', 'conversionMultiple'];
  clickedRows = new Set<CurrencyExchange>();

}
