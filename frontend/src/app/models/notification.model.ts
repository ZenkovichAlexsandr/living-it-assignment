export interface ToastNotification {
  type: string;
  icon: string;
  content: string[];
  closable: boolean;
  autoClosable: boolean;
  group: string;
}

export interface Icons {
  error: string;
  info: string;
  success: string;
}
