package com.delivery.apidelivery.services;

import com.delivery.apidelivery.entity.Food;
import com.delivery.apidelivery.entity.Order;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService {

    private final List<Food> listFoodMenu;
    private final List<Order> listOrder;

    public OrderService(){
        this.listFoodMenu= new ArrayList<>();
        this.listOrder = new ArrayList<>();
    }

    //Mostrar y Agregar comidas a la lista de Menu
    public void addFood(Food food){
        this.listFoodMenu.add(food);
    }

    public List<Food> getAllFoods(){
        return this.listFoodMenu;
    }

    public List<Food> ordenar(int cantidad) throws IOException {
        String name;
        List<Food> listFood = new ArrayList<>();
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
        return listFood;
    }
    //OrdernarPedido y Calcular el precio total
    public void newOrder(int cantidad, String id, String customerName, String customerEmail) throws IOException {
        List<Food> listfood= ordenar(cantidad);
        Order order = new Order(id, customerName,customerEmail,listfood);
        LocalTime estimated = order.getCreationTime();
        estimated = estimated.plusMinutes(listfood.size() * 10L);
        order.setEstimatedDeliveryTime(estimated);
        listOrder.add(order);
        System.out.println("Orden realizada");
        System.out.println("El total del pedido es: " + order.priceTotal());
    }

    //Cambiar Estado de Pedido
    public void cambiarStatus(String id, String status){
        for (Order oOrd: listOrder) {
            if(oOrd.getId().equals(id)){
                oOrd.setStatus(status);
            }
        }
    }

    //Mostrar estado de Pedido, la hora de creación y la hora de estimación
    public String mostrarStatus(String id){
        for (Order oOrd: listOrder) {
            if(oOrd.getId().equals(id)){
                System.out.println("El pedido con id: " + oOrd.getId() + " , perteneciente al cliente: " + oOrd.getCustomerName() + "es: " );
               return "Estado: "+ oOrd.getStatus()+ "Fecha de Creación: " +oOrd.getCreationTime()+ "Hora estimada:" + oOrd.getEstimatedDeliveryTime();
            }
        }
        return "Pedido no encontrado";
    }

}
