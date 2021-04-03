public class One {

    public static void main(String[] args) {
    }
}


class Changer {

    private int[] gift_cards;
    private int[] wants;

    public Changer(int[] _gift_cards, int[] _wants) {
        gift_cards = _gift_cards;
        wants = _wants;
    }

    int mainLogic() {
        for(int i=0; i<gift_cards.length; i++) {
            if(gift_cards[i] == wants[i]) continue;

            for(int j=0; j<wants.length; j++) {
                if(gift_cards[i] == wants[j]) {
                    Swap(gift_cards, i, j);
                }
            }
        }

        int result = 0;
        for(int i=0; i<gift_cards.length; i++) {
            if(gift_cards[i] != wants[i]) result++;
        }


        return result;
    }


    void Swap(int[] gift_cards, int i, int j) {
        int temp = 0;

        temp = gift_cards[i];
        gift_cards[i] = gift_cards[j];
        gift_cards[j] = temp;
    }
}
