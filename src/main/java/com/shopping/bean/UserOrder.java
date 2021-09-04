package com.shopping.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {
    private long id;
    private String name;
    private String customerAddress;

    private List<OrderItem> items;


    public UserOrder(String name, String customerAddress, List<OrderItem> items){
        this.name = name;
        this.customerAddress = customerAddress;
        this.items = items;
    }
}
