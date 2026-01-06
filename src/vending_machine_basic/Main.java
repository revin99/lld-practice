package vending_machine_basic;


import vending_machine_basic.Services.InventoryServices;
import vending_machine_basic.Services.MoneyServices;
import vending_machine_basic.entities.Denomination;
import vending_machine_basic.entities.Money;
import vending_machine_basic.entities.Product;
import vending_machine_basic.entities.VendingMachine;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {
        VendingMachine vendingMachine = new VendingMachine();



        Product p1 = new Product("p1",5);
        Product p2 = new Product("p2",7);
        Product p3 = new Product("p3",10);
        Product p4 = new Product("p4",3);
        Product p5 = new Product("p5",9);

        Map<Product,Integer> inventory = new HashMap<>();
        inventory.put(p1,10);
        inventory.put(p2,10);
        inventory.put(p3,10);
        inventory.put(p4,10);
        inventory.put(p5,10);

        Map<Denomination,Integer> moneyMap = new HashMap<>();
        moneyMap.put(Denomination.TEN,10);
        moneyMap.put(Denomination.TWENTY,10);
        moneyMap.put(Denomination.FIFTY,20);

        Money money = new Money(moneyMap);
        vendingMachine.setProductList(inventory);
        vendingMachine.setMoney(money);

        MoneyServices moneyServices = new MoneyServices(vendingMachine.getMoney());
        InventoryServices inventoryServices = new InventoryServices(vendingMachine);


        int option=1;
        while (option!=3){
            System.out.println("1.Display Vending Machine\n2,Select Product\n3.Quite Program");
            option = sc.nextInt();
            if(option==1){
                vendingMachine.printVendingMachine();
            }else if(option==2){

                System.out.println("Enter product name and quantity");
                String pname = sc.next();
                int qty = sc.nextInt();

                int price = vendingMachine.getPrice(pname,qty);
                System.out.println("Total price is " + price);

                System.out.println("Enter 1 to pay or 2 to exit");
                int option2 = sc.nextInt();
                if(option2==1){
                    Money money1 = moneyServices.convertMoney(price);
                    moneyServices.addMoney(money1);
                    inventoryServices.removeProduct(pname,qty);
                }
            }else{
                break;
            }
        }



    }
}
