import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http : HttpClient) { }

  rootURL = "/api/v1/";

  public get(url: string, options?: any) { 
  return this.http.get(url, options); 
  }

  public post(url: string, data: any, options?: any) { 
  return this.http.post(url, data, options); 
  }

  public put(url: string, data: any, options?: any) { 
  return this.http.put(url, data, options); 
  }
   
  public delete(url: string, options?: any) { 
  return this.http.delete(url, options); 
  } 
}
