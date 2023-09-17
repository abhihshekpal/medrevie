import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { OrderService } from '../order.service';
import { Order, Products } from '../order.model';;
import { MatPaginator} from '@angular/material/paginator';



@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit{
  displayedColumns: string[] = ['orderId', 'purchaseDate', 'totalPrice', 'deliveryStatus'];
  order:Order[]=[];
  dataSource: MatTableDataSource<Order>;
  @ViewChild('paginator')paginator!:MatPaginator;
  
  products:Products[]=[];
  page:number=1;
  count:number=0;
  tableSize:number=6;
  tableSizees:any=[3,6];




  ngOnInit(): void {
      this.getOrder();
  }

  constructor(private orderService:OrderService){
    this.dataSource = new MatTableDataSource<Order>([]);
   
  }

  
  

  getOrder(){
    localStorage.setItem("email","abhipal23@gmail.com")
    let email=localStorage.getItem('email');
    this.orderService.getOrders(email).subscribe(
      data=>{
        this.order=data.reverse();
        console.log(data);
        this.dataSource = new MatTableDataSource<Order>(this.order); 
        this.ngAfterViewInit();

      },
      error=>{
        console.log(error);
      }
    )
  }


  ngAfterViewInit(){
    this.dataSource=new MatTableDataSource(this.order);
    this.dataSource.paginator=this.paginator;
  }

  



  selectedOrder: any = null;

  expandOrder(order: Order) {
    if (this.selectedOrder === order) {
      this.selectedOrder = null;
      this.products=this.selectedOrder.orderItems;
    } else {
      this.selectedOrder = order;
      this.products=this.selectedOrder.orderItems;
    }
  }

  onTableDataChange(event:any){
    this.page=event;
    this.products;
  }
}
  