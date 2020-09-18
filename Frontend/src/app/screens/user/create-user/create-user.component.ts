import { Router } from '@angular/router';
import { UserService } from '../../../service/user/user.service';
import { User } from '../../../models/User';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import { CustomvalidationService } from '../../../service/customvalidation.service';
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss'],
})
export class CreateUserComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  user: User = new User();
  submitted = false;

  constructor(private userService: UserService, private router: Router,private fb: FormBuilder, private validator: CustomvalidationService) {}
  // emailRegEx = '^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$';
  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['',[Validators.required]],
      role: ['',[Validators.required]]
    })
    }
    get f(){
      return this.form.controls;
    }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService.createUser(this.user).subscribe(
      (data) => {
        console.log(data);
        this.user = new User();
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    if(this.form.valid){
      alert('Create success');
      console.table(this.form.value);
    }
    this.save();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/users']);
  }
}
