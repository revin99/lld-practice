package auction_system.models;

import auction_system.state.AuctionState;
import auction_system.state.IdleAuctionState;

import java.util.ArrayList;
import java.util.List;

public class Auction {

    private int auctionId;
    private User startedBy;
    private int currentPrice;
    private Item item;
    private User lastBidBy;
    private AuctionState auctionState;
    List<User> observers;

    public Auction(int auctionId, User startedBy, Item item, int currentPrice) {
        this.auctionId = auctionId;
        this.startedBy = startedBy;
        this.item = item;
        this.lastBidBy = startedBy;
        this.currentPrice=currentPrice;
        this.auctionState = new IdleAuctionState();
        this.observers = new ArrayList<>();
        this.observers.add(startedBy);


    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void addSubscriber(User user){
        observers.add(user);
    }

    public void notifySubscribers()
    {
        for(User user:observers){
            user.update(this);
        }
    }

    public void placeBid(int bidPrice, User user)
    {
        System.out.println("New bid placed by " + user.getName());
        auctionState.placeBid(this,user,bidPrice);
        addSubscriber(user);
        notifySubscribers();
    }

    public void endAuction(){
        auctionState.endAuction(this);
        System.out.println("Auction ended at " + this.currentPrice);
        System.out.println("Auction winner is " + this.lastBidBy.getName());
    }

    public User getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(User startedBy) {
        this.startedBy = startedBy;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public User getLastBidBy() {
        return lastBidBy;
    }

    public void setLastBidBy(User lastBidBy) {
        this.lastBidBy = lastBidBy;
    }

    public AuctionState getAuctionState() {
        return auctionState;
    }

    public void setAuctionState(AuctionState auctionState) {
        this.auctionState = auctionState;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

}
