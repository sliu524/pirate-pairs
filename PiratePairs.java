import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        int playernum = 4;
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        int losescore = (int)60/playernum + 1;
        int[] mincardarray = new int[playernum];
        int round = 1;
        for (int i = 0; i < playernum; i++){
            players [i] = new Player(i+1);
            System.out.println("Player" + players[i].playername + " has strategy " + players[i].strat);
        }
        
        while ((dealer.deck.length >= playernum)&&(players.length > 1)){
            System.out.println("Round"+round);
            System.out.println("deck:"+dealer.showdeck());
            for (int j = 0; j < playernum; j++){
                int mincard = Integer.MAX_VALUE;
                int mincardindex = 0;
                for (int i = 0; i < mincardarray.length; i ++){
                    if ((mincardarray[i]<mincard)&&(i != j)){
                        mincard = mincardarray[i];
                        mincardindex = i;
                    }
                }
                System.out.println("Dealer pulls out a new card. Player choosese whether to accept. The lowest hand currently is: " + mincard);
                if ((ifdraw(players[j].strat, players[j].gethand(), dealer))||(players[j].gethand().length==0)){
                    System.out.println("Player" + players[j].playername + " says yes to a new card.");
                    int hand = dealer.deal();
                    players[j].newhand(hand);
                    if (players[j].getifloseround()){
                        players[j].resethand(); 
                    }
                }
                else{
                    System.out.println("Player" + players[j].playername + " says no to a new card.");
                    players[j].addscore(mincard);
                    players[mincardindex].poplowcard();
                }
                System.out.println("Player"+players[j].playername+Arrays.toString(players[j].gethand())+" Score:" + players[j].getscore());
                mincardarray[j] = players[j].getlowhand();
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
            System.out.println("\n");
        }
        if (players.length==1){
            System.out.println("Player"+players[0].playername+" is the winner!");
        }else {
            System.out.println("Game over. No one wins.");
        }
    }
    public static boolean ifdraw(String strat, int[] h, Dealer d){
        if (strat == "radical"){
            return true;
        }else if (strat == "coward"){
            return false;
        }else{
            int[]c = d.check;
            for (int i = 0; i < h.length; i ++){
                if (c[h[i]-1] > (int)h[i]/2){
                    return false;
                }
            }
            return true;
        }
    }
}