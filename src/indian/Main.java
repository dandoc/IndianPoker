package indian;

public class Main {
	static public void main(String [] args)
	{
//		Deck playerDeck = new Deck();
//		Deck comDeck = new Deck();
//		
//		while(!playerDeck.isEmpty() || !comDeck.isEmpty())
//		{
//			System.out.println("Player Card\n"+playerDeck.drawRandomCard().getPattern());
//			System.out.println("Com Card\n"+comDeck.drawRandomCard().getPattern());
//			cls();
//		}
		
		GameBoard a = new GameBoard();
		a.play();
	}

}
