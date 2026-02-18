import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        int playernum = 4; //minimum of 4 players
        Player [] players = new Player[playernum];
        Dealer dealer = new Dealer();
        int losescore = (int)60/playernum + 1;
        int[] minCardArray = new int[playernum];
        int round = 1;
        //find lowest hand in all hands
        for (int i = 0; i < playernum; i++){
            players [i] = new Player(i+1);
            System.out.println("Player" + players[i].playername + " has strategy " + players[i].strat);
        }
        
        while ((dealer.deck.length >= playernum)&&(players.length > 1)){
            System.out.println("Round"+round);
            System.out.println("deck:"+dealer.showdeck());
            for (int j = 0; j < playernum; j++){
                int mincard = Integer.MAX_VALUE;
                int minCardIndex = 0;
                for (int i = 0; i < minCardArray.length; i ++){
                    if ((minCardArray[i]<mincard)&&(i != j)){
                        mincard = minCardArray[i];
                        minCardIndex = i;
                    }
                }
                System.out.println("Dealer pulls out a new card. Player choosese whether to accept. The lowest hand currently is: " + mincard);
                //player draws card
                if ((ifDraw(dealer, players[j],mincard, losescore))||(players[j].getHand().length==0)){
                    //success
                    System.out.println("Player" + players[j].playername + " says yes to a new card.");
                    int hand = dealer.deal();
                    players[j].newHand(hand);
                    minCardArray[j] = players[j].getLowHand();
                    //player fails
                    if (players[j].getIfLoseRound()){
                        dealer.addToDiscard(players[j].getHand());
                        players[j].resetHand();
                        minCardArray[j] = players[j].getLowHand();
                    }
                }
                //player take lowest hand as score
                else{
                    System.out.println("Player" + players[j].playername + " says no to a new card.");
                    players[j].addscore(mincard);
                    dealer.addToDiscard(players[j].getHand());
                    players[j].resetHand();
                    minCardArray[j] = players[j].getLowHand();
                    dealer.addToDiscard(players[minCardIndex].getLowHand());
                    players[minCardIndex].popLowCard();
                    players[minCardIndex].resetminvalue();
                    minCardArray[minCardIndex] = players[minCardIndex].getLowHand();
                }
                System.out.println("Player"+players[j].playername + Arrays.toString(players[j].getHand())+" Score:" + players[j].getscore());
                minCardArray[j] = players[j].getLowHand();
            }
            //remove player
            for (int j = playernum-1; j >= 0; j--){
                if (players[j].getscore()>losescore){
                    playernum --;
                    Player[] tempplayers = new Player[playernum];
                    int [] tempMin = new int[playernum];
                    int index = 0;
                    for (int i = 0; i < players.length; i ++){
                        if (i != j){
                            tempplayers[index] = players[i];
                            tempMin[index] = minCardArray[i];
                            index++;
                        }
                    }
                    players = tempplayers;  
                    minCardArray = tempMin;
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
    //Determine action of player based on assigned strategies
    public static boolean ifDraw(Dealer d, Player p, int mincard, int l){
        String strat = p.strat;
        int[] h = p.getHand();
        if (strat.equals("radical")){
            return true;
        }else if (strat.equals("coward")){
            return false;
        }else if (strat.equals("chancetimer")){
            if (p.getHand().length < 5){
                return true;
            }
            return false;
        }
        /*Activate new strategies
        else if (strat.equals("hopper")){
            if ((p.getHand().length % 2)==0){
                return true;
            }
            return false;
        }
        else if (strat.equals("randomer")){
            int n = (int)(Math.random()*2)
            if (n==0){
                return true;
            }
            return false;
        }*/
        else{
            for (int i = 0; i < h.length; i ++){
                if ((d.checkdiscard[h[i]-1]+d.checkHand[h[i]-1] > h[i]/2)||((p.getscore()+mincard)>l)){
                    return false;
                }
            }
            return true;
        }
    }
}