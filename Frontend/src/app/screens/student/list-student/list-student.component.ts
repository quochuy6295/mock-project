import { StudentService } from './../../../service/student/student.service';
import { Student } from './../../../models/Student';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ViewChild } from '@angular/core';
import { NgxCsvParser } from 'ngx-csv-parser';
import { NgxCSVParserError } from 'ngx-csv-parser';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.scss'],
})
export class ListStudentComponent implements OnInit {
  students: Observable<Student[]>;
  csvRecords: any[] = [];
  header = false;
  constructor(private studentService: StudentService, private router: Router, private ngxCsvParser: NgxCsvParser) {}

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

  @ViewChild('fileImportInput', { static: false }) fileImportInput: any;

  // input change listener for the CSV File
  fileChangeListener($event: any): void{
    // select file from the event
    const files = $event.srcElement.files;
    // Parse the file you want to select for the operation along with the configuration
    this.ngxCsvParser.parse(files[0], { header: this.header, delimiter: ','})
    .pipe().subscribe((result: Array<any>) => {
      console.log('Result', result);
      this.csvRecords = result;
    }, (error: NgxCSVParserError) => {
      console.log('Error', error);
    });
  }

  newStudent(): void {
    this.router.navigate(['students/create']);
  }
}



// ngOnInit() {
//   this.service.getAll()
//     .subscribe(posts => this.posts = posts);
// }

// createPost(input: HTMLInputElement) {
//   let post = { title: input.value };

//   // Optimistic Approach
//   this.posts.splice(0, 0, post);

//   input.value = '';

//   this.service.create(post)
//     .subscribe(
//         newPost => {
//           post['id'] = newPost.id;
//           // this.posts.splice(0, 0, post);
//           console.log(newPost);
//         },
//         (error: AppError) => {
//           // Optimistic Rollback
//           this.posts.splice(0, 1);

//           if(error instanceof BadRequest) {
//             // this.form.setErrors(error.originalError);
//           }
//           else throw error;
//         });
// }

// updatePost(post) {
//   this.service.update(post)
//     .subscribe(
//       updatedPost => console.log(updatedPost)
//     );
// }

// deletePost(post) {
//   this.service.delete(post.id)
//     .subscribe();
