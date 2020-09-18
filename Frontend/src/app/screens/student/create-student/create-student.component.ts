import { Component, OnInit } from '@angular/core';
import { NgxCsvParser } from 'ngx-csv-parser';
import { NgxCSVParserError } from 'ngx-csv-parser';
import { CustomvalidationService } from '../../../service/customvalidation.service';
import { StudentService } from '../../../service/student/student.service';
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.scss']
})
export class CreateStudentComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  submitted = false;
  public studentFile: any = File;
  respon : Response;
  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';

  fileInfos: Observable<any>;

  constructor(private fb: FormBuilder, private validator: CustomvalidationService, private studentservices: StudentService) {}
  ngOnInit(): void {
    this.form = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(2)]],
    email: ['', [Validators.required, Validators.email]],
    url: ['',[Validators.required, this.validator.EmailValidatior()]]
  })
  }
  get f(){
    return this.form.controls;
  }
  onSubmit(){
    this.submitted = true;
    if(this.form.valid){
      alert('Form Submitted succesfully!!!\n Check the values in browser console');
      console.table(this.form.value);
    }
  }

  selectFile(event): void {
    this.selectedFiles = event.target.files;
  }
  saveForm(submitForm: FormGroup){
    if(submitForm.valid){
      const student = submitForm.value;
      const formData = new FormData();
      formData.append('student', JSON.stringify(student));
      formData.append('file', this.studentFile)
      this.studentservices.saveStudentProfile(formData).subscribe((res) =>
        console.log(res));
    }
  }

  upload(): void {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.studentservices.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
  }
}
