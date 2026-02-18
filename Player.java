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
        int snum = (int)(Math.random()*3)+1;
        if (snum == 1){
            strat = "radical";
        }
        else if (snum == 2){
            strat = "coward";
        }
        else {
            strat = "thinker";
        }
    }
    public void newhand(int card){
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
        newhand[newhand.length-1] = card;
        this.hand = newhand;
    }
    public void poplowcard(){
        if (hand.length<=1){
            resethand();
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
    public void resethand(){
        hand = new int[0];
        lowhand = Integer.MAX_VALUE;
    }
    public int getlowhand(){
        return lowhand;
    }
    public boolean getifloseround(){
        return ifloseround;
    }
    public int[] gethand(){
        return hand;
    }
    public int getscore(){
        return score;
    }
    public void addscore(int s){
        score += s;
    }
}
