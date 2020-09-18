
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class StudentService {
  [x: string]: any;
  private baseUrl = 'http://localhost:8080/admin/student';
  // private bastUrl1 = 'http://localhost:8080/admin/upload';
  constructor(private http: HttpClient) {}

  // createStudent(Student: Object): Observable<Object> {
  //   return this.http.post(`${this.baseUrl}`, Student);
  // }

  // getUser(id: number): Observable<any> {
  //   return this.http.get(`${this.baseUrl}`);
  // }

  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  // private baseUrl = 'http://localhost:8080';

  // upload(file: File): Observable<HttpEvent<any>> {
  //   const formData: FormData = new FormData();

  //   formData.append('file', file);

  //   const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
  //     reportProgress: true,
  //     responseType: 'json'
  //   });

  //   return this.http.request(req);
  // }
}
