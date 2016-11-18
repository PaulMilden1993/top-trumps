package Assignment;

import java.util.Random;

//An implementation of a deck of cards

public class Deck {

    private Card[] myCards;


    private int numCards;

    public Deck () {

        //Call the other constructor, defining one deck without shuffling
        this(1, false);
    }

    public Deck(int numDecks, boolean shuffle){

        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];

        // int card index
        int c = 0;

        //for each deck
        for(int d = 0; d <numDecks; d++) {

            //for each suit
            for(int s = 0; s < 4; s++) {

                //for each number
                for (int n = 1; n <= 13; n++) {

                    //add a new card to the deck
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }

        //Shuffle if necessary
        if(shuffle) {
            this.shuffle();

        }

    }


    public void shuffle() {

        //Random Number Generator
        Random rng = new Random();

        //Temporary Card
        Card temp;

        int j;
        for (int i = 0; i < this.numCards; i++) {

            //Get a random card j to swa[ to i's value with
            j = rng.nextInt(this.numCards);

            //do swap
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;


        }

    }


    public Card dealNextCard() {

        //get the top card
        Card top = this.myCards[0];

        // shift all the subsequent cards to the left by one index
        for (int c = 1; c < this.numCards; c++) {
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;

        // Decrement the number of cards in our deck
        this.numCards--;

        return top;
    }

    public void printDeck(int numToPrint) {

        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards,
            this.myCards[c].toString());
        }

        System.out.printf ("\t[%d other]\n", this.numCards-numToPrint);
    }

}