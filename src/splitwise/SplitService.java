package splitwise;

import splitwise.entity.Expense;
import splitwise.entity.Group;
import splitwise.entity.Split;
import splitwise.entity.User;
import splitwise.strategy.SplitStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitService {

    private static SplitService instance;
    private Map<Integer, User> userMap;
    private Map<Integer, Group> groupMap;

    private static int expenseId=1;

    private SplitService(){
        userMap = new HashMap<>();
        groupMap = new HashMap<>();
    }

    public static SplitService getInstance(){
        if(instance==null){
            instance = new SplitService();
        }
        return instance;
    }

    public void addUser(User user){
        userMap.put(user.getId(),user);
    }

    public void addGroup(Group group){
        groupMap.put(group.getId(),group);
    }

    public User getUser(int userId){
        return  userMap.get(userId);
    }

    public Group getGroup(int groupId){
        return groupMap.get(groupId);
    }

    public void createExpense(double amount , String title, User paidBy, List<User>participants, SplitStrategy splitStrategy)
    {
        Expense expense = new Expense(expenseId,amount,title,paidBy,participants,splitStrategy);
        expenseId++;
        List<Split> splits = expense.getUserList();
        for(Split split: splits)
        {
            User user = split.getUser();
            double value = split.getAmount();

            if(!user.equals(paidBy)){
                paidBy.getBalanceSheet().modifyBalance(user,-value);
                user.getBalanceSheet().modifyBalance(paidBy,value);
            }
        }
        System.out.println("Expense of amount created " + amount);
        System.out.println("Expense paid by " + paidBy.getName());
        System.out.print("Expense borne between : ");
        for(User user:participants) System.out.print(user.getName() + " ");
        System.out.println();System.out.println();System.out.println();
    }


    public void createExpense(double amount , String title, User paidBy, List<User>participants, List<Double> percentages, SplitStrategy splitStrategy)
    {
        Expense expense = new Expense(expenseId,amount,title,paidBy,participants,percentages,splitStrategy);
        expenseId++;
        List<Split> splits = expense.getUserList();

        for(Split split: splits)
        {
            User user = split.getUser();
            double value = split.getAmount();

            if(!user.equals(paidBy)){
                paidBy.getBalanceSheet().modifyBalance(user,-value);
                user.getBalanceSheet().modifyBalance(paidBy,value);
            }
        }

        System.out.println();
        System.out.println("Expense of amount created" + amount);
        System.out.println("Expense paid by " + paidBy.getName());
        System.out.print("Expense borne between : ");
        for(User user:participants) System.out.print(user.getName() + " ");
        System.out.println();System.out.println();System.out.println();

    }

    public void showBalance(User user){
        user.getBalanceSheet().printBalance();
    }

    public void settleUp(User from, User to, double amount)
    {
        from.getBalanceSheet().modifyBalance(to,-amount);
        to.getBalanceSheet().modifyBalance(from,+amount);
        System.out.println("User " + from.getName() + " is settling up with " + to.getName() + " with amount " + amount);
        //for user A .. if he has user b -> -10 in map, means A needs to take 10 from B.
        //now if B is from and A is to and amount is 5... for user A... map should be user b -> -5, since B given 5 to A
    }


}
