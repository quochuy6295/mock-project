import { Router } from '@angular/router';
import { UserService } from '../../../service/user/user.service';
import { User } from '../../../models/User';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss'],
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  submitted = false;
  selectedRole: string = '';

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {}

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
    this.userService.createUser(this.user).subscribe(
      (data) => {
        console.log(data);
        // this.user = new User();
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/users']);
  }

  selectChangeHandler(event: any) {
    this.selectedRole = event.target.value;
  }
}
