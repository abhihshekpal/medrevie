import { Component } from '@angular/core';

declare var Object: any;

@Component({
  selector: 'app-ordersum',
  templateUrl: './ordersum.component.html',
  styleUrls: ['./ordersum.component.css'],
})
export class OrdersumComponent {

  getObjectKeys(obj: any): string[] {
    return Object.keys(obj);
  }

  quantity: number = 1; // Initial quantity
  pricePerUnit: number = 1043.10; // Replace with your actual price per unit
  promoCodeDiscounts: { [key: string]: number } = {
    option1: 10, // Discount for Option 1
    option2: 15, // Discount for Option 2
    option3: 20, // Discount for Option 3
  };
  selectedPromoCode: string = 'option1'; // Initial promo code option

  // Function to calculate the total price with discount based on the selected promo code
  calculateTotalPrice(quantity: number, pricePerUnit: number, discount: number): number {
    const subTotal = quantity * pricePerUnit;
    const discountedAmount = (subTotal * discount) / 100;
    const totalPrice = subTotal - discountedAmount;
    return totalPrice;
  }
  

  // Calculate the total amount without a discount
  totalAmountWithoutDiscount: number = this.calculateTotalPrice(this.quantity, this.pricePerUnit, 0);

  // Calculate the discounted amount based on the selected promo code
  discountedAmount: number = this.calculateDiscountedAmount();

  // Calculate total savings as the difference between total amount and discounted amount
  totalSavings: number = this.totalAmountWithoutDiscount - this.discountedAmount;

  constructor() {}

  updatePrice() {
    // Update both total, discounted amounts, and total savings when the quantity or promo code changes
    this.totalAmountWithoutDiscount = this.calculateTotalPrice(this.quantity, this.pricePerUnit, 0);
    this.discountedAmount = this.calculateDiscountedAmount();

    // Update total savings
    this.totalSavings = this.totalAmountWithoutDiscount - this.discountedAmount;
  }

  // Function to format currency as rupees
  formatAsRupees(value: number): string {
    return '₹' + value.toFixed(2);
  }

  // Function to calculate the discounted amount based on the selected promo code
  calculateDiscountedAmount(): number {
    const promoCode = this.selectedPromoCode;
    const discountPercentage = this.promoCodeDiscounts[promoCode] || 0; // Default to 0% if promo code not found
    return this.calculateTotalPrice(this.quantity, this.pricePerUnit, discountPercentage);
  }
}