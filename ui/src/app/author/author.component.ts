import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  title = 'Author Management'
  authors: any = [];
  //books = []

  isGreen = false
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllAuthor()
  }

  addAuthors(){
   
    console.log("addAuthors button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-author')
  }

  getAllAuthor(){
    this.http.get("http://localhost:8080/authors/getAllAuthor")
    .subscribe(resp =>{
      this.authors = resp;
      console.log('Authors retrieved successfully:', this.authors)
    }, error => {
      console.error('Error retrieving authors:', error);
    });
  }

  deleteAuthor(authorId:Number){
    
    const url = 'http://localhost:8080/authors/delete/' +authorId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Author deleted successfully');
      this.getAllAuthor()
    }, error => {
      console.error('Error deleting author:', error);
    });
  }

}