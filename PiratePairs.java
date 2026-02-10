import java.util.Arrays;
public class PiratePairs {

    public static void main(String[] args){
        int playernum = 4;
        int [] players = new int [playernum];
        int [] deck = createdeck();
        System.out.println(Arrays.toString(deck));
    }
    private static int[] createdeck (){
        int [] deck = new int [55];
        int count = 0;
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= i; j++){
                deck[count] = i;
                count += 1;
            }
        }
        //Shuffle
        for (int i = 0; i < (int)(Math.random()*45+10); i++){
            int index1 = (int)(Math.random()*deck.length);
            int index2 = (int)(Math.random()*deck.length);
            while (index2 == index1){
                index2 = (int)(Math.random()*deck.length);
            }
            int temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
        return deck;
    }
}