package auction_system.state;

import auction_system.models.Auction;
import auction_system.models.User;

public interface AuctionState {

    void placeBid(Auction auction, User user,int bidPrice);
    void endAuction(Auction auction);
}
