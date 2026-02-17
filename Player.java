public class Player {
        private int[] hand;
        private int score = 0;
        private boolean ifloseround = false;
        private int lowhand = Integer.MAX_VALUE;
        public int playername = 0;
        public Player(int i){
            hand = new int[0];
            playername = i;

        }
        public void newhand(int card){
            ifloseround = false;
            int[]newhand = new int[hand.length+1];
            if (card<lowhand){
                lowhand = card;
            }
            for (int i = 0; i < hand.length; i ++){
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
    }
