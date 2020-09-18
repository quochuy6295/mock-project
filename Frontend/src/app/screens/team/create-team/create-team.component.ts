import { TeamService } from './../../../service/team/team.service';
import { Team } from './../../../models/Team';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.scss'],
})
export class CreateTeamComponent implements OnInit {
  team: Team = new Team();
  submitted = false;

  constructor(private teamService: TeamService, private router: Router) {}

  ngOnInit(): void {}

  newTeam(): void {
    this.submitted = false;
    this.team = new Team();
  }

  save() {
    this.teamService.createTeam(this.team).subscribe(
      (data) => {
        console.log(data);
        this.team = new Team();
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.save();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/teams']);
  }
}
