package indian;

public class Player {
    private Deck deck;
    private int chips;
    private String name;

    public Player(int initialChips, String name) {
        this.deck = new Deck();
        this.chips = initialChips;
        this.name = name;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getChips() {
        return chips;
    }

    public void addChips(int amount) {
        this.chips += amount;
    }

    public void removeChips(int amount) {
        this.chips -= amount;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
