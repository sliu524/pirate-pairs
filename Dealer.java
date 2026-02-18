import java.util.Arrays;

public class Dealer {
    public int [] deck = new int[55];
    public int [] check = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public Dealer(){
        createdeck();
    }
    private void createdeck(){
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
    public int deal(){
        int [] newdeck = new int [deck.length-1];
        int card = deck[deck.length-1];
        for (int i = 0; i < deck.length-1; i ++){
            newdeck [i] = deck [i];
        }
        deck = newdeck;
        if (check[card-1] > 0){
            check[card-1] -= 1;
            return card;
        }
        return -1;
    }
    public String showdeck(){
        String d = Arrays.toString(deck);
        return d;
    }
}
