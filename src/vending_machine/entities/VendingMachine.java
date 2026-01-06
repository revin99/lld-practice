package vending_machine.entities;

import java.util.List;

public class VendingMachine {
    private List<Product> productList;
    private Money vmMoney;

    public VendingMachine(List<Product> productList, Money vmMoney) {
        this.productList = productList;
        this.vmMoney = vmMoney;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Money getVmMoney() {
        return vmMoney;
    }

    public void setVmMoney(Money vmMoney) {
        this.vmMoney = vmMoney;
    }
}
