import { Directive } from '@angular/core';
import {
  ReactiveFormsModule,
  NG_VALIDATORS,
  FormsModule,
  FormGroup,
  FormControl,
  ValidatorFn,
  Validator
 } from '@angular/forms';
@Directive({
  selector: '[appEmailValidator][ngModel]',
  providers: [
    {
     provide: NG_VALIDATORS,
     useExisting: EmailValidatorDirective,
     multi: true
    }
   ]
})
export class EmailValidatorDirective implements Validator{
  validator: ValidatorFn;
  constructor() { this.validator = this.EmailValidatorDirective()}

  validate(c: FormControl) {
  return this.validator(c);
 }
 EmailValidatorDirective(): ValidatorFn {
    return (c: FormControl) => {
    let isValid = /^[_a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/.test(c.value);
    if (isValid) {
    return null;
   } else {
    return {
     emailvalidator: {
      valid: false
     }
    };
   }
  }
 }
}
