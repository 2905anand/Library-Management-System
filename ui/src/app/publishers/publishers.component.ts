import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-publisher',
  templateUrl: './publishers.component.html',
  styleUrls: ['./publishers.component.css']
})
export class PublishersComponent implements OnInit {

  title = 'Publisher Management'
  publishers: any = [];
  //books = []

  isGreen = true
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllPublisher()
  }

  addPublishers(){
   
    console.log("addPublishers button clicked!!")
    // Take user to /add-books url
    this.router.navigateByUrl('/add-publisher')
  }

  getAllPublisher(){
    this.http.get("http://localhost:8080/publisher/getAllPublisher")
    .subscribe(resp =>{
      this.publishers = resp;
      console.log('Students retrieved successfully:', this.publishers)
    }, error => {
      console.error('Error retrieving books:', error);
    });
  }

  deletePublisher(publisherId:Number){
    
    const url = 'http://localhost:8080/publisher/delete/' +publisherId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Student deleted successfully');
      this.getAllPublisher()
    }, error => {
      console.error('Error deleting book:', error);
    });
  }

}