package com.shopping.controller;

import com.shopping.service.CatalogService;
import com.shopping.service.InventoryService;
import com.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShoppingController {
    CatalogService catalogService;
    InventoryService inventoryService;
    OrderService orderService;

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Autowired
    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("viewOrders")
    public ModelAndView viewOrders(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("getAllOrders");
        modelAndView.addObject("orders", orderService.getAllOrdersByUserName("ben"));
        return modelAndView;
    }

    @RequestMapping("viewProducts")
    public ModelAndView viewProducts(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("getAllProducts");
        modelAndView.addObject("orders", catalogService.getAllProducts());
        return modelAndView;
    }
}
