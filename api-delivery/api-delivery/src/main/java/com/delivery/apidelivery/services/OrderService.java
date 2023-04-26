package com.delivery.apidelivery.services;

import com.delivery.apidelivery.entity.Food;
import com.delivery.apidelivery.entity.Order;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final List<Food> listFoodMenu;
    private final List<Order> listOrder;
    private List<Food> listFood;
    private Order order;

    public OrderService(){
        this.listFoodMenu= new ArrayList<>();
        this.listOrder = new ArrayList<>();
        this.listFood = new ArrayList<>();
    }

    //Mostrar y Agregar comidas a la lista de Menu
    public void addFood(Food food){
        this.listFoodMenu.add(food);
    }

    public List<Food> getAllFoods(){
        return this.listFoodMenu;
    }

    public List<Order> getAllOrders(){
        return  this.listOrder;
    }

    public void addItems(Food food){
        this.listFood.add(food);
    }
    public List<Food> getAllItems(){
        return this.listFood;
    }


    //OrdernarPedido y Calcular el precio total
    public void newOrder(Order order){
        LocalTime estimated = order.getCreationTime();
        estimated = estimated.plusMinutes(listFood.size() * 10L);
        order.setEstimatedDeliveryTime(estimated);
        order.setItems(listFood);
        listOrder.add(order);
    }

    public Optional<Order> mostrarPorID(String id){
        return this.listOrder.stream().filter( order -> order.getId().equals(id)).findFirst();
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
            return "Estado: " + order.getStatus()+", Creación: " + order.getCreationTime()+", Estimación: " + order.getEstimatedDeliveryTime();
        }
        return "null";
    }

    public List<Food> getListFoodMenu() {
        return listFoodMenu;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public List<Food> getListFood() {
        return listFood;
    }
}
    /*public void addPlatos(int cantidad) throws IOException {
            String name;
            for (int i=0; i<cantidad; i++){
                System.out.print("Ingresa el nombre del plato: ");
                BufferedReader br = null;
                name = br.readLine();
                for (Food oFood: listFoodMenu) {
                    if(oFood.getName().equals(name)){
                        listFood.add(oFood);
                    }
                }
            }
        }*/