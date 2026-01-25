package auction_system.observer;

import auction_system.models.Auction;

public interface AuctionObserver {

    void update(Auction auction);
}
