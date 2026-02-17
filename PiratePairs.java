import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        int playernum = 4;
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        int losescore = (int)60/playernum + 1;
        int[] mincard = new int[playernum];
        int round = 1;
        for (int i = 0; i < playernum; i++){
            players [i] = new Player(i+1);
        }
        
        while ((dealer.deck.length >= playernum)&&(players.length > 1)){
            System.out.println("Round"+round);
            System.out.println("deck:"+dealer.showdeck());
            for (int j = 0; j < playernum; j++){
                int hand = dealer.deal();
                players[j].newhand(hand);
                if (players[j].getifloseround()){
                   players[j].resethand(); 
                }
                System.out.println("Player"+players[j].playername+Arrays.toString(players[j].gethand())+" Score:" + players[j].getscore());
                mincard[j] = players[j].getlowhand();
            }
            //remove player
            for (int j = playernum-1; j >= 0; j--){
                if (players[j].getscore()>losescore){
                    playernum --;
                    Player[] tempplayers = new Player[playernum];
                    for (int i = 0; i < j; i ++){
                        tempplayers[i] = players[i];
                    }
                    for (int i = j+1; i < players.length; i ++){
                        tempplayers[i-1] = players[i];
                    }
                    players = tempplayers;  
                }
            }
            round ++;
        }
        if (players.length==1){
            System.out.println("Player"+players[0].playername+" is the winner!");
        }else {
            System.out.println("Game over. No one wins.");
        }
    }
}