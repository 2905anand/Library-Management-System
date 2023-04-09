import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  title = 'Student Management'
  students: any = [];
  //books = []

  isGreen = false
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllStudent()
  }

  addStudents(){
   
    console.log("addStudents button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-student')
  }

  getAllStudent(){
    this.http.get("http://localhost:8080/student/getAllStudent")
    .subscribe(resp =>{
      this.students = resp;
      console.log('Students retrieved successfully:', this.students)
    }, error => {
      console.error('Error retrieving books:', error);
    });
  }

  deleteStudent(studentId:Number){
    
    const url = 'http://localhost:8080/student/delete/' +studentId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Student deleted successfully');
      this.getAllStudent()
    }, error => {
      console.error('Error deleting book:', error);
    });
  }

}