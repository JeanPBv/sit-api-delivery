package com.delivery.apidelivery.controller;

import com.delivery.apidelivery.entity.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.delivery.apidelivery.services.OrderService;

import java.util.List;

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
}
