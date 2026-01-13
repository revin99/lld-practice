package vending_machine_v2.entity;

import java.util.Map;

public class Inventory {

    private Map<Integer,Integer> productMap; //map product id -> with stock
    private Map<Integer,Product> getProductMap;


    public Product getProduct(int productId){
        return getProductMap.get(productId);
    }

    public Inventory(Map<Integer, Integer> productMap, Map<Integer, Product> getProductMap) {
        this.productMap = productMap;
        this.getProductMap = getProductMap;
    }

    public void printInventory(){
        System.out.println("Product ID \t Product Name \t Product price \t Product Qty");
        for (Map.Entry<Integer,Integer> entry: productMap.entrySet())
        {
            int productId = entry.getKey();
            Product product = getProductMap.get(productId);
            System.out.println(productId+ "\t\t"+ product.getName() + "\t\t" +product.getPrice() + "\t\t" + entry.getValue());
        }
    }

    public Map<Integer, Product> getGetProductMap() {
        return getProductMap;
    }

    public void setGetProductMap(Map<Integer, Product> getProductMap) {
        this.getProductMap = getProductMap;
    }

    public Map<Integer, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Integer> productMap) {
        this.productMap = productMap;
    }

    public boolean addProduct(Product product,int quantity)
    {
        productMap.put(product.getId(),quantity);
        return true;
    }

    public boolean isProductAvailable(int productId)
    {
        if(!productMap.containsKey(productId)) return false;
        if(productMap.get(productId)==0) return false;

        return true;
    }

    public boolean removeProduct(int productId, int quantity)
    {
        if(!isProductAvailable(productId)) return false; //if product not available return false
        int currentQuantity = productMap.get(productId);

        if(currentQuantity>=quantity){
            productMap.put(productId,currentQuantity-quantity);
            return true;
        }else{
            return false;
        }

    }
}
