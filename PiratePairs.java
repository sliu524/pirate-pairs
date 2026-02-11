import java.util.Arrays;
public class PiratePairs {

    public static void main(String[] args){
        int playernum = 4;
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        for (int i = 0; i < playernum; i++){
            players [i] = new Player();
            dealer.deal();
        }
        
    }
    
}