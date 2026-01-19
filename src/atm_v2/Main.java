package atm_v2;

import atm_v2.entity.Account;
import atm_v2.entity.Card;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        Account account1 = new Account(1,1000,"Revin");
        Account account2 = new Account(2,500,"Shalini");

        Card card1 = new Card("12345",account1);
        account1.addCard("12345",123);

        Card card2 = new Card("56789",account2);
        account2.addCard("56789",567);


        AtmMachine atmMachine = AtmMachine.getInstance();

        int option = 1;
        while (option!=6){
            System.out.println("Enter option\n1.Show ATM Balance\n2.Insert Card\n3.Withdraw Cash\n4.Deposit Cash\n5.Show balance\n6.Exit");
            option = sc.nextInt();
            String cardNumber="";

            if(option==1){
                System.out.println("ATM Balance: " + atmMachine.getMoney());
            }else if (option==2){
                sc.nextLine();
                System.out.println("Enter card number");
                cardNumber = sc.nextLine();
                if(cardNumber.equals("12345")) {
                    atmMachine.insertCard(card1);
                }else{
                    atmMachine.insertCard(card2);
                }
            }else if(option==3){
                System.out.println("Enter amount");
                int amount = sc.nextInt();
                if(cardNumber.equals("12345")) {
                    atmMachine.withdrawCash(card1,amount);
                }else{
                    atmMachine.withdrawCash(card2,amount);
                }
            }else if(option==4){
                System.out.println("Enter amount");
                int amount = sc.nextInt();
                if(cardNumber.equals("12345")) {
                    atmMachine.depositCash(card1,amount);
                }else{
                    atmMachine.depositCash(card2,amount);
                }
            }else if(option==5){
                if(cardNumber.equals("12345")) {
                    atmMachine.showBalance(card1);
                }else{
                    atmMachine.showBalance(card2);
                }
            }
        }

    }
}
