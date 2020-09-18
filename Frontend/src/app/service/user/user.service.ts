import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private baseUserUrl = 'http://localhost:8080/admin/users';

  constructor(private http: HttpClient) {}

  createUser(User: Object): Observable<Object> {
    return this.http.post(`${this.baseUserUrl}`, User);
  }

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUserUrl}/${id}`);
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUserUrl}`);
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUserUrl}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUserUrl}/${id}`, {
      responseType: 'text',
    });
  }

  addUserTeam(userId: number, teamId: number): Observable<Object> {
    return this.http.post(`${this.baseUserUrl}/${userId}/join-team/${teamId}`, {
      responseType: 'json',
    });
  }

  removeUserTeam(userId: number, teamId: number): Observable<any> {
    return this.http.post(`${this.baseUserUrl}${userId}/leave-team/${teamId}`, {
      responseType: 'json',
    });
  }
}
