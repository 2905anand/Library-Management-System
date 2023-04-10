import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-publisher',
  templateUrl: './add-publisher.component.html',
  styleUrls: ['./add-publisher.component.css']
})
export class AddPublisherComponent implements OnInit {
  publishersForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router ) { 
    this.publishersForm = this.formbuilder.group({
      ID: [],
      name: ['', Validators.required],
      address: [],
      phone: [],
      email: [],
      
    })
  }

  ngOnInit(): void {
  }

  savePublisher(){
    // Make Post call to request url http://localhost:8080/publisher/savePublisher
    
    let publisherData = this.publishersForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/publisher/savePublisher',publisherData)
    .subscribe(response => {
      console.log('Publisher saved to DB', response)
      this.router.navigateByUrl('/publishers')
    }, error =>{
      console.error("Error in publisher save", error)
    }
    );

  }

  



}