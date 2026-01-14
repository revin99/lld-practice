package splitwise;

import splitwise.entity.Expense;
import splitwise.entity.Group;
import splitwise.entity.User;
import splitwise.strategy.EqualSplitStrategy;
import splitwise.strategy.PercentageSplit;

import java.util.List;

public class Main {

    public static void main(String [] args)
    {

        /*

        splitservice = new splitservice()

        //user registration
        splitservice.add_user(user1); splitservice.add_user(user2);.....

        //group creation with registered users
        splitservice.add_group(grp1);

        //expense1 = new expense(amount,title,paidby,paidfor->list,splittype)
        //show balance of user1,user2,user3...etc

        //more types of expense with different split_type...

        //finally simplifygroupdebt on a group -> internally solve and show final dues.

         */

        SplitService splitService = SplitService.getInstance();

        User user1 = new User(1,"name1");
        User user2 = new User(2,"name2");
        User user3 = new User(3,"name3");
        User user4 = new User(4,"name4");

        Group group = new Group(1,"group1",List.of(user1,user2,user3,user4));


        splitService.addUser(user1); splitService.addUser(user2);splitService.addUser(user3);splitService.addUser(user4);
        splitService.addGroup(group);


        // create equal split expense //
        splitService.createExpense(600,"dinner",user1,List.of(user1,user2,user3),new EqualSplitStrategy());

        splitService.showBalance(user1);
        splitService.showBalance(user2);
        splitService.showBalance(user3);
        splitService.showBalance(user4);

        //create percentage split expense //

        splitService.createExpense(1000,"lunch",user4,List.of(user1,user2,user3,user4),List.of(25.0,25.0,25.0,25.0),new PercentageSplit());
        splitService.showBalance(user1);
        splitService.showBalance(user2);
        splitService.showBalance(user3);
        splitService.showBalance(user4);


    }
}
