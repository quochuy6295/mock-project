import { Injectable } from '@angular/core';
import { ValidatorFn, AbstractControl, Validator, ValidationErrors } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import {FormControl } from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class CustomvalidationService implements Validator{
  validator: ValidatorFn;
constructor() {
   this.validator = this.EmailValidatior();
  }
validate(c: FormControl) {
   return this.validator(c);
  }
EmailValidatior(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {
    if (!control.value) {
      return null;
    }
    const regex = new RegExp('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}');
    const valid = regex.test(control.value);
    return valid ? null : { invalidUrl: true };
  };
}
}
