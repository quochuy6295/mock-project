import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TeamService {
  [x: string]: any;
  private baseTeamsUrl = 'http://localhost:8080/admin/teams';

  constructor(private http: HttpClient) {}

  createTeam(Team: Object): Observable<Object> {
    return this.http.post(`${this.baseTeamsUrl}`, Team);
  }

  getTeam(id: number): Observable<any> {
    return this.http.get(`${this.baseTeamsUrl}, ${id}`);
  }

  getTeamList(): Observable<any> {
    return this.http.get(`${this.baseTeamsUrl}`);
  }
}
