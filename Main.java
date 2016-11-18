package Assignment;

import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // init
        Scanner sc = new Scanner(System.in);
        Deck theDeck = new Deck (4, true);

        //init the player objects
        Player me = new Player("Paul");
        Player dealer = new Player("Dealer");

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        //print initial hands

        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        // Flags for when each player is finished hitting
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while (!meDone || !dealerDone) {

            //Players Turn
             if (!meDone) {
                 System.out.print("Hit or Stay? (Enter H or S): ");
                 ans = sc.next();
                 System.out.println();

                 //If player Hits
                 if (ans.compareToIgnoreCase("H") == 0) {
                     //Add next card
                     meDone = !me.addCard(theDeck.dealNextCard());
                     me.printHand(true);
                 } else {
                     meDone = true;
                 }
             }

             //Dealers turn
            if (!dealerDone) {
                if (dealer.getHandSum() < 17){
                    System.out.println("The Dealer Hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                } else {
                    System.out.println ("The Dealer Stays\n");
                    dealerDone = true;
                }
            }

            System.out.println();

            //print final hands
            me.printHand(true);
            dealer.printHand(true);

            int mySum = me.getHandSum();
            int dealerSum = dealer.getHandSum();

            if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
                System.out.println("You Win!!");
            } else {
                System.out.println("Dealer Wins!!");
            }


        }






    }

}









