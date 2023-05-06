import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { AppService } from '../app.service';
import { Employee } from './model/Employee';
import {MatDialog} from '@angular/material/dialog';
import { Popup } from './model/popup';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  firstName:string ='';
  lastName:string = '';
  email:string = '';
  app: any;
  constructor(appService:AppService, 
    private route : ActivatedRoute, 
    private router :Router,
    private dialog : MatDialog) {
      this.app = appService;
   }

  ngOnInit(): void {  }

  status:String ="";
  addEmployee(){
  let emp = new Employee("101", this.firstName, this.lastName, this.email);
  this.app.post("http://localhost:8080/api/v1/employee", emp).subscribe((data: any) => {
       console.log('@@@@@@ message: ',data);
       
       const dialogRef = this.dialog.open(Popup);
       dialogRef.updateSize('410px');
       dialogRef.afterClosed().subscribe(result => {
        console.log('popup result: '+result);
        if(result){
          this.clear();
        }else{
          this.router.navigate(['/emp-list']);
        }     
       })
     }),console.error();
      
  }

  clear(){
    this.firstName = '';
    this.lastName ='';
    this.email = '';
  }

  cancel(){
    this.router.navigate(['/emp-list']);
  }

}
