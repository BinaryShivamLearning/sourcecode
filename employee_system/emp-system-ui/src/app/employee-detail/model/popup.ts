import { Component, Inject } from '@angular/core';  
import {MatDialog} from '@angular/material/dialog';

@Component({  
    selector: 'app-popup',  
    template: `  
        <h1 mat-dialog-title>Successfully Added</h1>  
        <mat-dialog-actions style="margin-top: 45px;">  
            <button style="width: 100px; height: 40px; margin-left: 96px; background-color: darksalmon;"
            mat-raised-button [mat-dialog-close]="true">Add More</button>  
            <button style="width: 140px; height: 40px; margin-left: 15px; background-color: darkseagreen;"
            mat-raised-button [mat-dialog-close]="false">Show Employees</button>  
        </mat-dialog-actions>  
    `  
})  
export class Popup{  
    constructor(private dialog:MatDialog){  
    }  
}  