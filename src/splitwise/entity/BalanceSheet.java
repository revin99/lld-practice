package splitwise.entity;

import java.util.Map;

public class BalanceSheet {

    private User owner;
    private Map<User,Double> balances;

    /* owner will have his own map of balances
        alice -> +10 (needs to give 10 to alice)
        bob -> -50 (needs to take 50 from bob)
     */
    public void printBalance()
    {
        System.out.println("Printing balance for user " + owner.getName());
        System.out.println("UserName \t Balance amount");
        double totalowe=0;

        for (Map.Entry<User,Double> entry:balances.entrySet())
        {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
            totalowe+=entry.getValue();
        }

        System.out.println(owner.getName() + " Final situation");
        if(totalowe==0){
            System.out.println("All settled up");
        }else if(totalowe<0){
            System.out.println("Will get from others: " + totalowe);
        }else {
            System.out.println("Will need to give others: " +totalowe);
        }
    }

    public void modifyBalance(User user, double amount)
    {
        if(owner.equals(user)) return;
        balances.merge(user,amount,Double::sum);
    }

    public void pairBalance(User user)
    {
        if(!balances.containsKey(user)){
            System.out.println("No equation between " + owner.getName() + " and " + user.getName());
        }

        System.out.println("Balance between " + owner.getName() + " and " + user.getName());
        System.out.println(balances.get(user));
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }
}
