package vending_machine_basic.Services;

import vending_machine_basic.entities.Product;
import vending_machine_basic.entities.VendingMachine;

import java.util.Map;

public class InventoryServices {

    private VendingMachine vendingMachine;

    public InventoryServices(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean hasProduct(Product product)
    {
        Map<Product,Integer> productList = vendingMachine.getProductList();
        if(productList.containsKey(product)) return true;
        return false;
    }

    public void addProduct(Product product, int quantity)
    {
        Map<Product,Integer> productList = vendingMachine.getProductList();
        productList.put(product,productList.getOrDefault(product,0)+quantity);
        vendingMachine.setProductList(productList);
        System.out.println("Product added succesfully to VM " + product.getName() + " with quantity: " + quantity);
    }

    public void removeProduct(String pname,int quantity)
    {

        Map<Product,Integer> productList = vendingMachine.getProductList();
        for(Map.Entry<Product,Integer> entry: productList.entrySet())
        {
            Product product = entry.getKey();
            int qty = entry.getValue();
            if(product.getName().equals(pname))
            {
                int remaining = qty-quantity;
                if(remaining>0)
                    productList.put(product,remaining);
                else
                    productList.remove(product);
                break;
            }
        }
        vendingMachine.setProductList(productList);
        System.out.println("Product has been removed from VM");
    }
}
