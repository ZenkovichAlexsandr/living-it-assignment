import { User } from './user.model';
import { TransactionList } from './transactions.model';

export interface AccountList {
  id: number;
  name: string;
  money: number;
}

export interface Account {
  name: string;
  money: number;
  users: number[];
}

export interface AccountDetails {
  name: string;
  users: User[];
  transactions: TransactionList[];
}
