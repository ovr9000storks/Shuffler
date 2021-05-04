public class Card {
    public String suit = "";
    public int number = 0;
    private String numString = "";
    private String[] suits = {"Jack", "Queen", "King", "Ace"};

    public Card(String newSuit, int newNum){
        suit = newSuit;
        number = newNum;
        
        if(newNum > 10){
            numString = suits[newNum%10 - 1];
        }else{
            numString += newNum;
        }
    }

    public String toString(){
        return numString + " of " + suit;
    }
}
