package services;

import entity.Food;
import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Food> listFood;
    private List<Order> listOrder;

    public OrderService(){
        this.listFood= new ArrayList<>();
        this.listOrder = new ArrayList<>();
    }

    public List<Food> getAllFoods(){
        return this.listFood;
    }

    public void addFood(Food food){
        this.listFood.add(food);
    }

    public void addOrder(Order order){
        this.listOrder.add(order);
    }

}
