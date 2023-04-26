package com.delivery.apidelivery.controller;

import com.delivery.apidelivery.entity.Food;
import com.delivery.apidelivery.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.delivery.apidelivery.services.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Food>> getAllFoods(){
        return ResponseEntity.ok(this.orderService.getAllFoods());
    }

    @PostMapping("/amenu")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        this.orderService.addFood(food);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @GetMapping("/menu/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return  ResponseEntity.ok(this.orderService.getAllOrders());
    }

    @PostMapping("/menu/platos")
    public ResponseEntity<Food> addItems(@RequestBody Food food){
        this.orderService.addItems(food);
        return new ResponseEntity<>(food,HttpStatus.CREATED);
    }

    @PostMapping("/menu/aorders")
    public ResponseEntity<Order> newOrder(@RequestBody Order order){
        this.orderService.newOrder(order.getId(),order.getCustomerName(), order.getCustomerEmail());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> mostrarPorID(@PathVariable String id){
        Optional<Order> optinalOrder = this.orderService.mostrarPorID(id);
        if(optinalOrder.isPresent()){
            return ResponseEntity
        }
    }

    public double calcularPrecio(String id){
        Optional<Order> optionalOrder = mostrarPorID(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            return order.priceTotal();
        }
        return 0;
    }

    //Cambiar Estado de Pedido
    public Order cambiarStatus(String id, String status){
        Optional<Order> optionalOrder = mostrarPorID(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setStatus(status);
            return order;
        }
        return null;
    }

    //Mostrar estado de Pedido, la hora de creación y la hora de estimación
    public String mostrarStatus(String id){
        Optional<Order> optionalOrder = mostrarPorID(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            return order.getStatus() + order.getCreationTime() + order.getEstimatedDeliveryTime();
        }
        return null;
    }

}
