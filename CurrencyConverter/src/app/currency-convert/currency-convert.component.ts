import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiServiceService } from '../api-service.service';
import { CurrencyConversion } from '../currency-conversion';
@Component({
  selector: 'app-currency-convert',
  templateUrl: './currency-convert.component.html',
  styleUrls: ['./currency-convert.component.css']
})
export class CurrencyConvertComponent implements OnInit {

  currencyFrom:string[] = ['USD', 'EUR', 'AUD'];

  currencyTo: string [] = ['INR']

  isButtonClicked = false;

  inputForm = new FormGroup({
    amount: new FormControl(0, [Validators.required]),
    currencyConvertedFrom: new FormControl(this.currencyFrom[0]),
    currencyConvertedTo: new FormControl('INR')
  });

  constructor(private apiService: ApiServiceService) { }

  ngOnInit(): void {
  }

  currencyConversionResult!: CurrencyConversion;

  getFrom = this.inputForm.get('currencyConvertedFrom');
  getTo = this.inputForm.get('currencyConvertedTo');
  getAmount = this.inputForm.get('amount');

  onSubmit() {
    // console.log(this.inputForm.value);
    this.isButtonClicked = true;
    this.apiService.getCalculateAmount(this.getFrom?.value, this.getTo?.value, this.getAmount?.value).subscribe(
      conversion => {
        this.currencyConversionResult = conversion;
      }
    )
  }

  get amount() {
    return this.inputForm.get('amount');
  }

  get currencyConvertedFrom() {
    return this.inputForm.get('currencyConvertedFrom');
  }

  get currencyConvertedTo() {
    return this.inputForm.get('currencyConvertedTo');
  }
}
