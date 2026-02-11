public class Player {
        public Player(){

        }
        public void newhand(int[]hand, int card){
            int[]newhand = new int[hand.length+1];
            for (int i = 0; i < hand.length; i ++){
                newhand[i] = hand[i];
            }
            newhand[newhand.length-1] = card;
        }
    }
