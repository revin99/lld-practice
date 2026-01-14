package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplit implements SplitStrategy{
    @Override
    public List<Split> calculateSplit(double amount, User paidBy, List<User> participants) {
        return List.of();
    }

    @Override
    public List<Split> calculateSplit(double amount, User paidBy, List<User> participants, List<Double> percentages) {
        List<Split> splits = new ArrayList<>();



        double pctsum=0.0;
        for (Double pct: percentages) pctsum+=pct;

        if(pctsum!=100.0) throw new IllegalArgumentException("Percentages not summing up to 100");

        for(int i=0;i<participants.size();i++)
        {
            User user = participants.get(i);
            double pct = percentages.get(i);

            double val = (pct/100.0)*amount;
            splits.add(new Split(user,val));
        }

        return splits;
    }
}
