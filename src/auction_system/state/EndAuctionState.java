package auction_system.state;

import auction_system.models.Auction;
import auction_system.models.User;

public class EndAuctionState implements AuctionState{
    @Override
    public void placeBid(Auction auction, User user, int bidPrice) {
        System.out.println("Auction has ended");
    }

    @Override
    public void endAuction(Auction auction) {
        System.out.println("Auction has ended!");
    }
}
