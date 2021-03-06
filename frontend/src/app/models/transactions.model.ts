export interface Transaction {
  money: number;
  from: number;
  to: number;
}

export interface TransactionList {
  id: number;
  creationDate: number[];
  from: number;
  to: number;
  status: TransactionStatus;
}

export enum TransactionStatus {
  NEW = 'NEW',
  APPROVED = 'APPROVED',
  DECLINED = 'DECLINED'
}
