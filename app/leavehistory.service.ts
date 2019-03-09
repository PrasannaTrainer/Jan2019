import { Injectable } from '@angular/core';
import {Http,Response} from '@angular/http';
import {Observable} from 'rxjs';
import { Leavehistory } from'./leavehistory';
import 'rxjs/add/operator/map';


@Injectable()
export class LeavehistoryService {

  constructor(private http : Http) {
  }
  searchLeaveHistory(EmpId:number): Observable<Leavehistory[]>{
    return this.http.get
 ("http://localhost:8080/FTP113/api/leaveDetails/leaveHistory/"+EmpId)
 .map((res:Response) => res.json())
    }
}
