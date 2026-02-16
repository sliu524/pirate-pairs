import java.util.Arrays;
public class Player {
        private int[] hand;
        private int score = 0;
        private boolean ifloseround = false;
        public Player(){
            hand = new int[0];

        }
        public void newhand(int card){
            int[]newhand = new int[hand.length+1];
            for (int i = 0; i < hand.length; i ++){
                newhand[i] = hand[i];
            }
            if (Arrays.asList(hand).contains(card)){
                score += card;
                ifloseround = true;
            }
            else{
                ifloseround = false;
            }
            newhand[newhand.length-1] = card;
            this.hand = newhand;
        }
        public void resethand(){
            hand = new int[0];
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
    }
