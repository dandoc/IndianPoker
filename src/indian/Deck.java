package indian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> cardDeck;
	private Random random;
	
	public List<Card> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(List<Card> cardDeck) {
		this.cardDeck = cardDeck;
	}
	
    public void addCard(Card card) {
        this.cardDeck.add(card);
    }
    
    public boolean isEmpty() {
    	return this.cardDeck.isEmpty();
    }
    
    public void removeCard(Card card) {
        if (card != null) {
            if (this.cardDeck.contains(card)) {
                this.cardDeck.remove(card);
            } else {
                throw new IllegalArgumentException("The card doesn't exist in the deck.");
            }
        } else {
            throw new IllegalArgumentException("The card is null.");
        }
    }

    public void removeItemAtIndex(int index) {
        if (index >= 0 && index < cardDeck.size()) {
            this.cardDeck.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

	
	Deck() {
		this.setCardDeck(new ArrayList<Card>());
		this.random = new Random();
			
		Card card1 = new Card();
		card1.setRank(1);
		card1.setPattern(
				"┌───────────┐\r\n" + 
				"│1          │\r\n" + 
				"│           │\r\n" + 
				"│           │\r\n" + 
				"│           │\r\n" + 
				"│　　　　♠　　  │\r\n" + 
				"│           │\r\n" + 
				"│           │\r\n" + 
				"│           │\r\n" + 
				"│           │\r\n" + 
				"└───────────┘"
				);
			
		this.addCard(card1);
		
		Card card2 = new Card();
		card2.setRank(2);
		card2.setPattern(
				"┌───────────┐\r\n" + 
				"│2          │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
				);
		this.addCard(card2);
		
		Card card3 = new Card();
		card3.setRank(3);
		card3.setPattern(
				"┌───────────┐\r\n" + 
				"│3          │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
				);
		this.addCard(card3);
		
		Card card4 = new Card();
		card4.setRank(4);
		card4.setPattern(
				"┌───────────┐\r\n" + 
				"│4          │\r\n" + 
				"│　　♠　　　♠ 　│\r\n" + 
				"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠ 　│\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"				
		 		);
		this.addCard(card4);
		
		Card card5 = new Card();
		card5.setRank(5);
		card5.setPattern(
				"┌───────────┐\r\n" + 
		 		"│5          │\r\n" + 
		 		"│　　♠　　　♠ 　│\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"			
		 		);
		this.addCard(card5);

		Card card6 = new Card();
		card6.setRank(6);
		card6.setPattern(
				"┌───────────┐\r\n" + 
		 		"│6          │\r\n" + 
		 		"│　　♠　　　♠ 　│\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
				"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
				"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"	
		 		);
		this.addCard(card6);
		
		Card card7 = new Card();
		card7.setRank(7);
		card7.setPattern(
				"┌───────────┐\r\n" + 
		 		"│7          │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
				"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card7);

		Card card8 = new Card();
		card8.setRank(8);
		card8.setPattern(
				"┌───────────┐\r\n" + 
		 		"│8          │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card8);
		
		Card card9 = new Card();
		card9.setRank(9);
		card9.setPattern(
				"┌───────────┐\r\n" + 
		 		"│9          │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card9);

		Card card10 = new Card();
		card10.setRank(10);
		card10.setPattern(
				"┌───────────┐\r\n" + 
		 		"│10         │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　　　♠　　  │\r\n" +  
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card10);
		
		Card card11 = new Card();
		card11.setRank(11);
		card11.setPattern(
				"┌───────────┐\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠♠♠♠♠　  │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│　　　　♠　　  │\r\n" + 
		 		"│　　♠　♠　　　 │\r\n" + 
		 		"│　　　♠　　　  │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card11);
		
		Card card12 = new Card();
		card12.setRank(12);
		card12.setPattern(
				"┌───────────┐\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　　♠♠♠　　　│\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　♠　　　♠　 │\r\n" + 
		 		"│　　♠　♠　♠　　│\r\n" + 
		 		"│　　　♠♠♠　　　│\r\n" + 
		 		"│　　　　　　♠  │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card12);
		
		Card card13 = new Card();
		card13.setRank(13);
		card13.setPattern(
				"┌───────────┐\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"│　　♠　　♠　　 │\r\n" + 
		 		"│　　♠　♠　　　 │\r\n" + 
		 		"│　　♠♠　　　　 │\r\n" + 
		 		"│　　♠　♠　　　 │\r\n" + 
		 		"│　　♠　　♠　　 │\r\n" + 
		 		"│           │\r\n" + 
		 		"│           │\r\n" + 
		 		"└───────────┘"
		 		);
		this.addCard(card13);

	}
	
	public void DeckShow() {
		for(Card c : cardDeck)
		{
			System.out.println(c.getPattern() + "\n");
		}
	}
	
    public Card drawRandomCard() {
        if (cardDeck.isEmpty()) {
            throw new IllegalStateException("덱이 비어 있습니다.");
        }
        int randomIndex = random.nextInt(cardDeck.size());
        return cardDeck.remove(randomIndex);
    }
	
	
}
