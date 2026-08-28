package org.example;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public  static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Resturent resturent = new Resturent();
int choice;
do{
    System.out.println("1. Add Menu Item");
    System.out.println("2. Remove Menu Item");
    System.out.println("3. Display Menu");
    System.out.println("4. Search Menu Item");
    System.out.println("5. Create Order");
    System.out.println("6. Add Item to Order");
    System.out.println("7. Remove Item from Order");
    System.out.println("8. Display Order");
    System.out.println("9. Add Order to Kitchen Queue");
    System.out.println("10. Process Next Order");
    System.out.println("11. Search Order");
    System.out.println("12. Check Order Status");
    System.out.println("13. Display Completed Orders");
    System.out.println("14. Exit");
    choice=in.nextInt();
    in.nextLine();
    switch(choice){
        case 1:
            resturent.addMenuItem();
            break;
        case 2:
            resturent.removeMenuItem();
            break;
        case 3:
            resturent.displayMenu();
            break;
        case 4:
            resturent.searchMenuItem();
            break;
        case 5:
            resturent.createOrder();
            break;
        case 6:
            resturent.addItemToOrder();
            break;
        case 7:
            resturent.removeItemFromOrder();
            break;
        case 8:
            resturent.displayOrder();
            break;
        case 9:
            resturent.addOrderKitchen();
            break;
        case 10:
            resturent.processNextOrder();
            break;
        case 11:
            resturent.searchOrder();
            break;
        case 12:
            resturent.checkOrderStatus();
            break;
        case 13:
            resturent.displayCompletedOrder();
            break;
        case 14:
            System.out.println("exite");
            break;
            default:
                System.out.println("invalid choice");
                break;
    }
}while(choice!=14);
    }
}