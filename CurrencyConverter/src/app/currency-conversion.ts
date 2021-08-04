export interface CurrencyConversion {
    id: number;
    from: string;
    to: string;
    quantity: bigint;
    conversionMultiple: bigint;
    totalCalculatedAmount: bigint;
    environment: string;

}