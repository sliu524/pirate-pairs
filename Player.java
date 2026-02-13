import java.util.Arrays;
public class Player {
        private int[] hand;
        private int score = 0;
        public Player(){
            hand = new int[0];

        }
        public void newhand(int card){
            int[]newhand = new int[hand.length+1];
            for (int i = 0; i < hand.length; i ++){
                newhand[i] = hand[i];
            }
            newhand[newhand.length-1] = card;
            this.hand = newhand;
        }
        public boolean check(int card){
            boolean iflose = !(Arrays.asList(hand).contains(card));
            return iflose;
        }
        public int[] gethand(){
            return hand;
        }
        public int getscore(){
            return score;
        }
    }
