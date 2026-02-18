import java.util.Arrays;

public class Dealer {
    public int [] deck = new int[55];
    public int [] checkHand = new int[10];
    public int [] discard = new int[0];
    public int [] checkdiscard = new int[10];
    public Dealer(){
        createdDeck();
    }
    private void createdDeck(){
        int count = 0;
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= i; j++){
                deck[count] = i;
                count += 1;
            }
        }
        //Shuffle
        for (int i = deck.length-1; i > 0; i--){
            int index = (int)(Math.random()*deck.length);
            while (i == index){
                index = (int)(Math.random()*deck.length);
            }
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }
    public void addToDiscard(int card){
        int[]newdiscard = new int[discard.length+1];
        for (int i = 0; i < discard.length; i++){
            newdiscard[i] = discard[i];
        }
        newdiscard[newdiscard.length-1] = card;
        discard = newdiscard;
        if (card <= 10){
            checkdiscard[card-1] += 1;
        }
    }
    public void addToDiscard(int[] hand){
        int[]newdiscard = new int[discard.length+hand.length];
        for (int i = 0; i < discard.length; i++){
            newdiscard[i] = discard[i];
        }
        for (int j = 0; j < hand.length; j++){
            newdiscard[discard.length + j] = hand[j];
            checkdiscard[hand[j]-1] += 1;
            j++;
        }
        discard = newdiscard;
    }
    public int deal(){
        int [] newdeck = new int [deck.length-1];
        int card = deck[deck.length-1];
        for (int i = 0; i < deck.length-1; i ++){
            newdeck [i] = deck [i];
        }
        deck = newdeck;
        checkHand[card-1] += 1;
        return card;
    }
    public String showdeck(){
        String d = Arrays.toString(deck);
        return d;
    }
}
