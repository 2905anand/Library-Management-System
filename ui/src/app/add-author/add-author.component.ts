import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {
  authorsForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router ) { 
    this.authorsForm = this.formbuilder.group({
      ID: [],
      name: ['', Validators.required],
      birthDate: [],
      nationality: [],
      
    })
  }

  ngOnInit(): void {
  }

  saveAuthor(){
    // Make Post call to request url http://localhost:8080/authors/saveAuthor
    
    let studentData = this.authorsForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/authors/saveAuthor',studentData)
    .subscribe(response => {
      console.log('Auhtor saved to DB', response)
      this.router.navigateByUrl('/author')
    }, error =>{
      console.error("Error in author save", error)
    }
    );

  }

  



}