import { TeamService } from './../../../service/team/team.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Team } from 'src/app/models/Team';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.scss'],
})
export class TeamDetailsComponent implements OnInit {
  id: number;
  team: Team;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private teamService: TeamService
  ) {}

  ngOnInit() {
    this.team = new Team();

    this.id = this.route.snapshot.params['id'];

    this.teamService.getTeam(this.id).subscribe(
      (data) => {
        console.log(data);
        this.team = data;
      },
      (error) => console.log(error)
    );
  }

  list() {
    this.router.navigate(['/teams']);
  }
}
