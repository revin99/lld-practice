package vending_machine_basic.entities;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    Map<Product,Integer> productList;
    Money money;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product, Integer> productList) {
        this.productList = productList;
    }

    public void printVendingMachine(){
        System.out.println("Product name  | Product price   | Product Quantity");
        for(Map.Entry<Product,Integer> entry: productList.entrySet())
        {
            Product product = entry.getKey();
            int qty = entry.getValue();
            System.out.println(product.getName() + "    " + product.getPrice() + "    " + qty);
        }
    }

    public int getPrice(String productName, int quantity)
    {
        int ans=0;
        for(Map.Entry<Product,Integer> entry: productList.entrySet())
        {
            Product product = entry.getKey();
            String name = product.getName(); int price = product.getPrice();
            if(productName.equals(name)) {ans = price*quantity; break;}
        }
        return ans;
    }

}
