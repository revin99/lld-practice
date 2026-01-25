package auction_system;

import auction_system.models.Auction;
import auction_system.models.Item;
import auction_system.models.User;

public class AuctionSystem {

    public static void main(String[] args)
    {
        User user1 = new User(1,"alice");
        User user2 = new User(2,"bob");
        User user3 = new User(3,"Charlie");
        User user4 = new User(4,"Donald");

        Item item1 = new Item(1,"pen",100);
        Item item2 = new Item(2,"phone",500);
        Item item3 = new Item(3,"bike",1000);


        Auction auction = new Auction(1,user1,item1,105);
        auction.placeBid(110,user2);
        auction.placeBid(130,user3);
        auction.endAuction();
    }
}
