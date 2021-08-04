export interface CurrencyExchange {
    id: number;
    from: string;
    to: string;
    conversionMultiple: bigint;
    environment: string;
}