package org.example;
import java.util.*;
public class Ordre {
    private final int orderId;
    private String cutomerName;
    List<OrderItem>orderItems;
    private double total;
    private OrderStatus orderStatus;
    public Ordre(int orderId, String cutomerName) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than 0");
        }
        this.orderId = orderId;
        this.cutomerName = cutomerName;
        orderItems = new ArrayList<>();
        this.total = 0;
        this.orderStatus=OrderStatus.PENDING;
    }

    public void addItem(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order Item cannot be null");
        }

        orderItems.add(orderItem);
        total+=orderItem.calculateSubtotal();
    }
    public void removeItem(OrderItem orderItem) {
        if(orderItem==null){
            throw new IllegalArgumentException("Order Item cannot be null");
        }
       if(orderItems.contains(orderItem)) {
           orderItems.remove(orderItem);
           total-=orderItem.calculateSubtotal();
       }

    }
    public double calculateTotal() {
        return total;
    }
    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotal() {
        return total;
    }

    public void displayOrder(){
        System.out.println("Order Id: "+orderId);
        System.out.println("Order Name: "+cutomerName);
        System.out.println("Order Status: "+orderStatus);

        System.out.println("Total Price: "+total);
    }

}
