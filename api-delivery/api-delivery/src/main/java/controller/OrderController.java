package controller;

import entity.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Food>> getAllFoods(){
        return ResponseEntity.ok(this.orderService.getAllFoods());
    }

    @PostMapping("/mostMenu")
    public ResponseEntity<Food> addCars(@RequestBody Food food){
        this.orderService.addFood(food);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
