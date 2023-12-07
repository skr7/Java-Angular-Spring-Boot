import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8080/employee";

  constructor(private httpClient:HttpClient) { }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/add`, employee);
  }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}/all`);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }



  updateEmployee(id:number,employee:Employee):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${id}`,employee)
  }

  deleteEmployee(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }


}
