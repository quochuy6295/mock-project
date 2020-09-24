import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private baseUrl = 'http://localhost:8080/admin/students';

  constructor(private http: HttpClient) {}

  createStudent(Student: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, Student);
  }

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  importCSVFile(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/upload`, data);
  }
}
