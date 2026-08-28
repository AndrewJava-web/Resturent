package org.example;
import java.util.*;
public class Resturent {
private List<MenuItem> menuItems=new ArrayList<>();
private List<Ordre>kitchenQueue=new LinkedList<>();
private Map<Integer,Ordre> order=new HashMap<>();
private Map<Integer,Ordre> completedOrder=new LinkedHashMap<>();
private Scanner in=new Scanner(System.in);
public void addMenuItem(){
    System.out.println("enter the id of item");
    int id=in.nextInt();
    in.nextLine();
    for(int i=0;i<menuItems.size();i++){
        if(menuItems.get(i).getId()==id){
            System.out.println("the item already exists");
            return;
        }
    }
    System.out.println("enter the name of item");
    String name=in.nextLine();
    System.out.println("enter the price of item");
    double price=in.nextDouble();
    in.nextLine();
    if(price<=0){
        throw new IllegalArgumentException("price must be greater than 0");
    }
    System.out.println("enter the category of item");
    String category=in.nextLine();
    menuItems.add(new MenuItem(id,name,price,category));
    System.out.println("the added item has been successfully");
}
public void removeMenuItem(){
    System.out.println("enter the id of item");
    int id=in.nextInt();
    in.nextLine();
    for(int i=0;i<menuItems.size();i++){
        if(menuItems.get(i).getId()==id){
            menuItems.remove(i);
            System.out.println("the removed item has been successfully");
            return;
        }
    }
    System.out.println("the item not found in the menu");
}
public void displayMenu(){
    if(menuItems.isEmpty()){
        System.out.println("the menu is empty");
        return;
    }
    for(MenuItem item:menuItems){
        System.out.println(item.toString());
    }
}
public void searchMenuItem(){

    System.out.println("Enter the ID of item:");
    int id = in.nextInt();
    in.nextLine();

    for (MenuItem item : menuItems) {

        if (item.getId() == id) {
            System.out.println("The item was found:");
            System.out.println(item);
            return;
        }
    }

    System.out.println("The item was not found in the menu.");
}
public void createOrder(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
 if(order.containsKey(id)){
     System.out.println("the order already exists");
     return;
 }
    System.out.println("enter your name");
    String name=in.nextLine();
    if(name.isEmpty()){
        System.out.println("the order name is empty");
        return;
    }

    Ordre ordre=new Ordre(id,name);
    order.put(id,ordre);
    System.out.println("the order has been successfully");

}
public void addItemToOrder(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    if(ordre.getOrderStatus()==OrderStatus.COMPLETED || ordre.getOrderStatus()==OrderStatus.CANCELLED){
        System.out.println("can't modifay this order");
        return;
    }
    System.out.println("enter the id of item");
    int itemId=in.nextInt();
    in.nextLine();
    MenuItem menuItem=null;
    for(int i=0;i<menuItems.size();i++){
        if(menuItems.get(i).getId()==itemId){
            menuItem=menuItems.get(i);
            break;
        }
    }
    if(menuItem==null){
        System.out.println("the order no exists");
        return;
    }
    System.out.println("entr the quantity of the item");
    int quantity=in.nextInt();
    in.nextLine();
    if(quantity<=0){
        System.out.println("the quantity less than 0");
        return;
    }
    OrderItem newOrder=new OrderItem(menuItem,quantity);
   ordre.addItem(newOrder);
    System.out.printf("the order has been successfully");
}
public void removeItemFromOrder(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    if(ordre.getOrderStatus()==OrderStatus.COMPLETED|| ordre.getOrderStatus()==OrderStatus.CANCELLED){
        System.out.println("can't modifay this order");
        return;
    }
    System.out.println("enter the id of item");
    int itemId=in.nextInt();
    in.nextLine();
    OrderItem menuItem=null;
    for (OrderItem orderItem : ordre.getOrderItems()) {

        if (orderItem.getMenuItem().getId() == itemId) {
          menuItem = orderItem;
            break;
        }
    }
    if(menuItem==null){
        System.out.println("the order no exists");
            return;
    }
    ordre.removeItem(menuItem);
    System.out.println("the order has been successfully");
}
public void displayOrder(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    ordre.displayOrder();
}
public void addOrderKitchen(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    if(ordre.getOrderStatus()!=OrderStatus.PENDING){
        System.out.println("Only pending orders can be added to the kitchen queue");
        return;
    }
   if(kitchenQueue.contains(ordre)){
       System.out.println("the order already exists");
       return;
   }
    kitchenQueue.add(ordre);
   ordre.updateOrderStatus(OrderStatus.IN_KITCHEN);
    System.out.println("the order has been successfully");
}
public void processNextOrder(){
    if(kitchenQueue.isEmpty()){
        System.out.println("the kitchen queue is empty");
            return;
    }
    Ordre order=kitchenQueue.removeFirst();
    order.updateOrderStatus(OrderStatus.COMPLETED);
    completedOrder.put(order.getOrderId(),order);
    System.out.println("the order has been successfully");
}
public void searchOrder(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
            return;
    }
    ordre.displayOrder();
}
public void searchOrderStatus(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    System.out.println(ordre.getOrderStatus());

}
public void checkOrderStatus(){
    System.out.println("enter the id of order");
    int id=in.nextInt();
    in.nextLine();
    Ordre ordre=order.get(id);
    if(ordre==null){
        System.out.println("the order no exists");
        return;
    }
    System.out.println(ordre.getOrderStatus());
}
public void displayCompletedOrder(){
    for(Map.Entry<Integer,Ordre> entry:completedOrder.entrySet()){
        System.out.println(entry.getKey());
        entry.getValue().displayOrder();
    }
}
}
