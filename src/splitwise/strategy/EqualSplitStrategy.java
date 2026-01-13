package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplit(double amount, User paidBy, List<User> participants) {

        int size = participants.toArray().length;

        double eachUserAmount = amount/(size);

        List<Split> splits = new ArrayList<>();

        for(User user:participants)
        {
            splits.add(new Split(user,eachUserAmount));
        }

        return splits;
    }

    @Override
    public List<Split> calculateSplit(double amount, User paidBy, List<User> participants, List<Double> percentages) {
        return List.of();
    }
}
