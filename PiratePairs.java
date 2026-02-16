import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        int playernum = 4;
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        boolean gameover = false;
        int losescore = (int)60/playernum + 1;
        for (int i = 0; i < playernum; i++){
            players [i] = new Player();
        }
        while (!gameover){
            for (int j = 0; j < playernum; j++){
                int hand = dealer.deal();
                players[j].newhand(hand);
                System.out.println("Player"+j+Arrays.toString(players[j].gethand()));
                if (players[j].getifloseround()){
                   players[j].resethand(); 
                }

                }
            }
        }
    }
}