public class Dealer {
        private int [] deck = new int[55];
        public Dealer(){
            createdeck();
        }
        private void createdeck(){
            int count = 0;
            for (int i = 1; i <= 10; i++){
                for (int j = 1; j <= i; j++){
                    deck[count] = i;
                    count += 1;
                }
            }
            //Shuffle
            for (int i = 0; i < (int)(Math.random()*45+10); i++){
                int index1 = (int)(Math.random()*deck.length);
                int index2 = (int)(Math.random()*deck.length);
                while (index2 == index1){
                    index2 = (int)(Math.random()*deck.length);
                }
                int temp = deck[index1];
                deck[index1] = deck[index2];
                deck[index2] = temp;
            }
        }
        public int dealcard(){
            return deck[0];
        }
        public void deal(){
            int [] newdeck = new int[deck.length-1];
            for (int i = 1; i < deck.length; i ++){
                newdeck[i-1] = deck[i];
            }
            deck = newdeck;
        }
        public int[] showdeck(){
            return deck;
        }
    }
    