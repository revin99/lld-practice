package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.List;

public interface SplitStrategy {

    List<Split> calculateSplit(double amount, User paidBy, List<User> participants);
    List<Split> calculateSplit(double amount, User paidBy, List<User> participants, List<Double> percentages);
}
