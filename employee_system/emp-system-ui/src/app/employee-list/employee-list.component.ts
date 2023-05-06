import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { AppService } from '../app.service';
import { Employee } from '../employee-detail/model/Employee';

export interface PeriodicElement {
  firstName: string;
  id: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {id: 1, firstName: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {id: 2, firstName: 'Helium', weight: 4.0026, symbol: 'He'},
  {id: 3, firstName: 'Lithium', weight: 6.941, symbol: 'Li'},
  {id: 4, firstName: 'Beryllium', weight: 9.0122, symbol: 'Be'}
];

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  // private destroy$ = new Subject();
  employees : Employee[] = [];
  dataSource:Employee[] = [];
  app: any;
  constructor(appService:AppService,  private route: ActivatedRoute,
    private router: Router) {
    this.app = appService;
 }

  ngOnInit(): void {
    this.getEmployee();
    
  }

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email','actions'];

  getEmployee(){
    this.app.get("http://localhost:8080/api/v1/employee", {responseType: 'json'}).subscribe((data:any) => {
      data.forEach((e:Employee) => {
        this.employees.push(e);
      });
      this.dataSource = this.employees;
    }),console.error();
  }

  addEmployee(){
    console.log("Add Employee");
    this.router.navigate(['/add-emp'], {relativeTo :this.route});
  }

  deleteEmp(element:Number) {
    console.log(element);
    this.app.post("http://localhost:8080/api/v1/empDelete", element).subscribe((data:any)=>{
      console.log(data);
    }),console.error();
  }

  editEmp(){
    console.log('edit')
  }

  // ngOnDestroy() : void {
  //   this.destroy$.unsubscribe();
  //   this.destroy$.complete();
  // }

    //  let headers = new HttpHeaders();
  //  headers.append('Content-Type', 'application/json; charset=utf-8');
  //  headers.append('Data-Type','json');
  //  headers.append('Accept','application/json');

}
