import { TeamService } from './../../../service/team/team.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Team } from 'src/app/models/Team';

@Component({
  selector: 'app-list-team',
  templateUrl: './list-team.component.html',
  styleUrls: ['./list-team.component.scss'],
})
export class ListTeamComponent implements OnInit {
  teams: Observable<Team[]>;

  constructor(private teamService: TeamService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.teams = this.teamService.getTeamList();
  }

  // deleteTeam(id: number) {
  //   this.teamService.deleteTeam(id).subscribe(
  //     (data) => {
  //       console.log(data);
  //       this.reloadData();
  //     },
  //     (error) => console.log(error)
  //   );
  // }

  teamDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  newTeam(): void {
    this.router.navigate(['teams/create']);
  }
  addMember(teamId: number): void {
    this.router.navigate([`teams/add-member/${teamId}`]);
  }

  removeMember(teamId: number): void {
    this.router.navigate(['teams/remove-member']);
  }
}
