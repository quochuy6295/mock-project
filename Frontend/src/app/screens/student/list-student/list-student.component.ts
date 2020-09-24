import { StudentService } from './../../../service/student/student.service';
import { Student } from './../../../models/Student';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpEvent, HttpRequest } from '@angular/common/http';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss'],
})
export class ListStudentComponent implements OnInit {
  students: Observable<Student[]>;

  uploadFile: File;

  constructor(private studentService: StudentService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.students = this.studentService.getStudentList();
  }

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  studentDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  selectFile(event) {
    this.uploadFile = event.target.files[0];
  }

  upload(): void {
    const formData: FormData = new FormData();

    formData.append('file', this.uploadFile);

    this.studentService
      .importCSVFile(formData)
      .subscribe(() => this.reloadData());
  }
}
