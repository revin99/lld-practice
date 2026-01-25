package auction_system.state;

import auction_system.models.Auction;
import auction_system.models.User;

public class IdleAuctionState implements AuctionState{
    @Override
    public void placeBid(Auction auction, User user,int bidPrice) {
        System.out.println("Changing Auction state to Inprogress");
        auction.setLastBidBy(user);
        auction.setCurrentPrice(bidPrice);
        auction.setAuctionState(new InProgressAuctionState());
    }

    @Override
    public void endAuction(Auction auction) {
        System.out.println("Auction not started yet!!");
    }
}
