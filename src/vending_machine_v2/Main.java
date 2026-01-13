package vending_machine_v2;

import vending_machine_v2.entity.Inventory;
import vending_machine_v2.entity.Money;
import vending_machine_v2.entity.Product;
import vending_machine_v2.enums.Denomination;
import vending_machine_v2.enums.ProductType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args)
    {

        Map<Integer,Product> productMap = new HashMap<>();
        Product p1 = new Product(1,"LAYS", ProductType.CHIPS,20);
        productMap.put(1,p1);
        Product p2 = new Product(2,"KURKURE", ProductType.CHIPS,10);
        productMap.put(2,p2);
        Product p3 = new Product(3,"COKE", ProductType.BEVERAGES,30);
        productMap.put(3,p3);
        Product p4 = new Product(4,"Muffin", ProductType.CAKES,40);
        productMap.put(4,p4);
        Product p5 = new Product(5,"Soya", ProductType.SNACKS,25);
        productMap.put(5,p5);

        Map<Integer,Integer> productStock = new HashMap<>();
        productStock.put(1,10);
        productStock.put(2,15);
        productStock.put(3,10);
        productStock.put(4,10);
        productStock.put(5,15);

        Inventory inventory = new Inventory(productStock,productMap);

        Map<Denomination,Integer> moneyMap = new HashMap<>();
        moneyMap.put(Denomination.TWENTY,10);
        moneyMap.put(Denomination.FIFTY,10);
        moneyMap.put(Denomination.HUNDRED,10);

        Money money = new Money(moneyMap);

        VendingMachine vendingMachine = VendingMachine.getInstance(inventory,money);

        int option =0;
        while (option!=-1) {

            System.out.println("Select from following options");
            System.out.println("1.Print Vending Machine inventory");
            System.out.println("2.Insert Money\n3.Select Product\n4.Exit");

            option = scanner.nextInt();

            if(option==1){
                vendingMachine.getInventory().printInventory();
                System.out.println("Total VM Money is " + vendingMachine.getTotalMoney().getMoney());
                System.out.println("Total inserted Amount " + vendingMachine.getInsertedMoney().getMoney());
            } else if (option==2) {
                System.out.println("Enter how many 20, 50 and 100 notes");
                int twenty = scanner.nextInt();
                int fifty = scanner.nextInt();
                int hundred = scanner.nextInt();

                Map<Denomination,Integer> insertedMoney = new HashMap<>();
                insertedMoney.put(Denomination.TWENTY,twenty);
                insertedMoney.put(Denomination.FIFTY,fifty);
                insertedMoney.put(Denomination.HUNDRED,hundred);
                Money inserted = new Money(insertedMoney);

                vendingMachine.insertMoney(inserted);
            }else if(option==3){
                System.out.println("Select product id and quantity");

                int productId = scanner.nextInt();
                int quantity = scanner.nextInt();

                boolean value = vendingMachine.selectProduct(productId,quantity);

                if(value) vendingMachine.dispenseProduct();
                else  vendingMachine.processRefund();
            }else{
                break;
            }
        }

    }
}
