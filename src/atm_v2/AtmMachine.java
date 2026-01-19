package atm_v2;

import atm_v2.entity.Card;
import atm_v2.state.*;

public class AtmMachine {

    private int money;
    private static AtmMachine instance;
    private AtmState currState;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private AtmMachine(){
        currState = new IdleState();
        this.money = 5000;
    }

    public static AtmMachine getInstance(){
        if(instance==null){
            instance = new AtmMachine();
        }
        return instance;
    }

    public AtmState getCurrState() {
        return currState;
    }

    public void setCurrState(AtmState currState) {
        this.currState = currState;
    }

    public void insertCard(Card card){
        currState.insertCard(this,card);
    }

    public void withdrawCash(Card card, int amount){
        this.setCurrState(new WithdrawCashState());
        currState.withdrawCash(this,card,amount);
    }

    public void depositCash(Card card,int amount){
        this.setCurrState(new DepositCashState());
        currState.depositCash(this,card,amount);
    }

    public void showBalance(Card card){
        this.setCurrState(new ShowBalanceState());
        currState.displayBalance(this,card);
    }
}
