package com.shopping.service;

import com.shopping.bean.UserOrder;
import com.shopping.bean.UserOrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserOrder> getAllOrdersByUserName(String name) {
        return Objects.requireNonNull(Objects.requireNonNull(restTemplate.getForObject("http://localhost:8086/orders/name/" + name, UserOrderList.class)).getOrders());
    }

    public UserOrder saveOder(UserOrder userOrder) {
        UserOrder savedOrder = restTemplate.postForObject("http://localhost:8086/orders/", userOrder, UserOrder.class);
        return savedOrder;
    }

    public UserOrder getLastOrder(String name) {
        return restTemplate.getForObject("http://localhost:8086/orders/name/last/" + name, UserOrder.class);
    }

}
