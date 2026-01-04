## Requirements
1. VM to have multiple products with different prices and different quantities
2. VM Should accept payment - coins and cash in different denom
3. VM Should dispense the selected product and dispense any change
4. Provide interface for restocking any product


##Entities

1. Product class -> having id,name,price
2. Money class -> total money, 10deno, 20 and 50 deno
3. VM Class -> list of products, money object


## Services
1. Add product to vending machine -> given quantity,price
2. Collect payment(in deno) - return change if required
2. Select product and collect payment and dispense -> Check availibility and reduce quantity