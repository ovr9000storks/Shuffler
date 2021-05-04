
public class Shuffler{
    

    public static void main(String[] args){
        int totalCycles = 0;
        boolean isSame = false;

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        Card[] cardDeck = new Card[52];

        Card[][] divis = new Card[3][18];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                cardDeck[13*i + j] = new Card(suits[i], j+2);
                //System.out.println(cardDeck[13*i + j]);
            }
        }
        
        while(!isSame){
            for(int i = 0; i < 18; i++){
                divis[0][i] = cardDeck[i];
            }
            for(int i = 0; i < 17; i++){
                divis[1][i] = cardDeck[i+18];
            }
            for(int i = 0; i < 17; i++){
                divis[2][i] = cardDeck[i+35];
            }

            int currentCard = 0;
            for(int i = 0; i < 18; i++){
                for(int j = 0; j < 3; j++){
                    if(currentCard >= 52){
                        j = 4;
                        i = 19;
                    }else{
                        cardDeck[currentCard] = divis[j][i];
                        currentCard++;
                    }
                    
                }
            }

            totalCycles++;
            System.out.println(totalCycles);

            isSame = true;
            currentCard = 0;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 13; j++){
                    if((cardDeck[currentCard].number != (j+2)) || !(cardDeck[currentCard].suit.equals(suits[i]))){
                        isSame = false;
                        j = 13;
                        i = 4;
                        System.out.println("different at card " + currentCard);
                    }
                    currentCard++;
                }
            }
        }

        System.out.println("It took " + totalCycles + " to return to the original state");
        
    }
}