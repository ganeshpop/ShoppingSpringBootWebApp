

package com.shopping.bean;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private long id;
    private String productCode;
    private int quantity;
    private double productPrice;

    public OrderItem(String productCode, int quantity, double productPrice){
        this.productCode = productCode;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public OrderItem(String productCode, int quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "ID : " + this.id + " Product Code :  " + this.productCode + " Quantity : " + this.quantity + " Price : " + this.productPrice;
    }
}
