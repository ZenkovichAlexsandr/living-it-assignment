import { FormControl } from '@angular/forms';

export class DecimalValidator {
  static validate(control: FormControl) {
    if (control.value && !('' + control.value).match(/^\d+\.\d\d$/)) {
      return {'format': true};
    }

    return null;
  }
}
