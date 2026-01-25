package auction_system.models;

import auction_system.observer.AuctionObserver;

public class User implements AuctionObserver {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Auction auction) {

        System.out.println("\nReceiving notification for auction ID" + auction.getAuctionId());
        System.out.println("Notification being received for user " + this.getName());
        System.out.println("New price is now " + auction.getCurrentPrice() + " Bid by " + auction.getLastBidBy().getName());
    }
}
