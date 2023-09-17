
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  constructor(private http: HttpClient) { }

  getOrders(email:string|null){
    return this.http.get<Order[]>(`http://localhost:8065/order/allOrder/${email}`);
  }

  saveOrder(order:Order|null){
    return this.http.post<Order>('http://localhost:8065/order/saveOrder',order);
  }
}
