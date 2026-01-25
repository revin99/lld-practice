package auction_system.state;

import auction_system.models.Auction;
import auction_system.models.User;

public class InProgressAuctionState implements AuctionState{
    @Override
    public void placeBid(Auction auction, User user,int bidPrice) {

        auction.setCurrentPrice(bidPrice);
        auction.setLastBidBy(user);
    }

    @Override
    public void endAuction(Auction auction) {
        System.out.println("Ending the auction now");
        auction.setAuctionState(new EndAuctionState());
    }
}
