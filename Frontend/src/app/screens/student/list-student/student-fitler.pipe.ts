import { Pipe, PipeTransform } from '@angular/core';
import { Student } from '../../../models/Student'

@Pipe({
  name: 'studentsFilter'
})
export class StudentFilterPipe implements PipeTransform{
  transform(students: Student[], searchTerm: string): Student[] {
    if(!students || !searchTerm){
      return students;
    }
    return students.filter(student =>
      student.source.toLowerCase().indexOf(searchTerm.toLowerCase()) !== -1);
  }
}

