package com.shopping.service;

import com.shopping.bean.UserOrder;
import com.shopping.bean.UserOrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserOrderList getAllOrdersByUserName(String name) {
        return restTemplate.getForObject("http://localhost:8086/orders/name/" + name, UserOrderList.class);
    }


    public URL saveOder(UserOrder userOrder) {
        URI uri = restTemplate.postForLocation("http://localhost:8086/orders/", userOrder);
        try {
            return uri.toURL();
        } catch (MalformedURLException | NullPointerException exception) {
            return null;
        }
    }

    public UserOrder getLastOrder(String name) {
        return restTemplate.getForObject("http://localhost:8086/orders/name/last/" + name, UserOrder.class);
    }

    public UserOrder getOrderById(int id) {
        return restTemplate.getForObject("http://localhost:8086/orders/" + id, UserOrder.class);
    }

}
