package org.example;

public class OrderItem {
   private MenuItem menuItem;
   private int quantity;
   public OrderItem(MenuItem menuItem, int quantity) {
       this.menuItem = menuItem;
       if (quantity <= 0) {
           throw new IllegalArgumentException("Quantity must be greater than 0");
       }
       this.quantity = quantity;
   }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
    public double calculateSubtotal(){
       double subtotal=0;
       subtotal=menuItem.getPrice()*quantity;
       return subtotal;
    }
}
