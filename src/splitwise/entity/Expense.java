package splitwise.entity;

import splitwise.strategy.SplitStrategy;

import java.util.List;

public class Expense {

    private int id; //id of this expense
    private double amount;
    private String title;
    private User paidBy;
    private List<Split> userList;
    private List<User> participants;

    public Expense(int id, double amount, String title, User paidBy, List<User> participants, List<Split> userList, SplitStrategy splitStrategy) {

        this.id = id;
        this.amount = amount;
        this.title = title;
        this.paidBy = paidBy;
        userList = splitStrategy.calculateSplit(amount,paidBy,participants);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getUserList() {
        return userList;
    }

    public void setUserList(List<Split> userList) {
        this.userList = userList;
    }
}
