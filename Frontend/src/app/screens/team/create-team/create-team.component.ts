import { TeamService } from './../../../service/team/team.service';
import { Team } from './../../../models/Team';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.scss'],
})
export class CreateTeamComponent implements OnInit {
  team: Team = new Team();
  submitted = false;
  teamLeads: User[];

  constructor(
    private teamService: TeamService,
    private router: Router,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userService
      .getUsersList()
      .subscribe((users) => (this.teamLeads = users));
  }

  newTeam(): void {
    this.submitted = false;
    this.team = new Team();
  }

  save() {
    this.teamService.createTeam(this.team).subscribe(
      (data) => {
        console.log(data);
        // this.team = new Team();
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
    this.router.navigate(['/teams']);
  }
}
