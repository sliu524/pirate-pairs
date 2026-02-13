import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        int playernum = 4;
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        boolean gameover = false;
        for (int i = 0; i < playernum; i++){
            players [i] = new Player();
        }
        while (!gameover){
            for (int j = 0; j < playernum; j++){
                int hand = dealer.deal();
                players[j].newhand(hand);
                if (!(players[j].check(hand))){
                    return
                }
                if (hand == -1){
                    return;
                }
            }
        }
    }
}