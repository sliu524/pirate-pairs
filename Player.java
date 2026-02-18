public class Player {
    private int[] hand;
    private int score = 0;
    private boolean ifloseround = false;
    private int lowhand = Integer.MAX_VALUE;
    public String strat = "";
    public int playername = 0;
    public Player(int i){
        hand = new int[0];
        playername = i;
        int stratnum = 4;
        int snum = (int)(Math.random()*stratnum)+1;
        if (snum == 1){
            strat = "radical";
        }
        else if (snum == 2){
            strat = "coward";
        }
        else if (snum == 3){
            strat = "chancetimer";
        }
        /**activate new strategies by changing stratnum and uncomment these;
        else if (snum == 4){
            strat = "hopper";
        }
        else if (snum == 5){
            strat = "randomer"
        }
        **/
        else{
            strat = "thinker"; 
        }
    }
    public void newHand(int card){
        ifloseround = false;
        int[]newhand = new int[hand.length+1];
        if (card<lowhand){
            lowhand = card;
        }
        for (int i = 0; i < hand.length; i++){
            newhand[i] = hand[i];
            if (hand[i]==card){
                score += card;
                ifloseround = true;
                break;
            }
        }
        if (!ifloseround){
            newhand[newhand.length-1] = card;
            this.hand = newhand;
        }
    }
    public void popLowCard(){
        if (hand.length<=1){
            resetHand();
        }
        else{
            int[] newhand = new int[hand.length-1];
            int j = 0;
            for (int i = 0; i < hand.length; i++){
                if (hand[i] != lowhand){
                    newhand[j] = hand[i];
                    j++;
                }
            }
            hand = newhand;
        }
    }
    public void resetminvalue(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < hand.length; i++){
            if (hand[i]<min){
                min = hand[i];
            }
        }
        lowhand = min;
    }
    public void resetHand(){
        hand = new int[0];
        lowhand = Integer.MAX_VALUE;
    }
    public int getLowHand(){
        return lowhand;
    }
    public boolean getIfLoseRound(){
        return ifloseround;
    }
    public int[] getHand(){
        return hand;
    }
    public int getscore(){
        return score;
    }
    public void addscore(int s){
        score += s;
    }
}
