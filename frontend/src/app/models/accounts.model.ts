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
