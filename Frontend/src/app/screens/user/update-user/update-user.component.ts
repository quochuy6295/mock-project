import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from 'src/app/models/Team';
import { User } from 'src/app/models/User';
import { TeamService } from 'src/app/service/team/team.service';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss'],
})
export class UpdateUserComponent implements OnInit {
  id: number;
  user: User;
  submitted = false;
  teams: Team[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private teamService: TeamService
  ) {}

  ngOnInit() {
    this.user = new User();

    this.id = this.route.snapshot.params['id'];

    this.userService.getUser(this.id).subscribe(
      (data) => {
        console.log(data);
        this.user = data;
        this.teamService.getTeamList().subscribe((teams) => {
          this.teams = teams;
        });
      },
      (error) => console.log(error)
    );
  }

  updateUser() {
    this.userService.updateUser(this.id, this.user).subscribe(
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
    this.updateUser();
  }

  gotoList() {
    this.router.navigate(['users']);
  }
}
