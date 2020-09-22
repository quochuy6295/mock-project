import { StudentService } from './../../../service/student/student.service';
import { Student } from './../../../models/Student';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss'],
})
export class ListStudentComponent implements OnInit {
  students: Observable<Student[]>;

  constructor(private studentService: StudentService, private router: Router) {}
  searchTerm: string;
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

  importFileStudent() {
    this.studentService.getStudentList();
    this.reloadData();
  }
}
