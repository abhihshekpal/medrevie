export class Order{
  orderId:string='';
  email:string='';
  purchaseDate:string='';
  totalPrice:number=0;
  deliveryStatus:string='';
  expectedDelivery:string='';
  orderItems:Products[]=[];
}

export class Products{
  productId:string='';
  name:string='';
  quantity:number=0;
  price:number=0;
  image:string='';
}