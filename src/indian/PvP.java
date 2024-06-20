package indian;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PvP {

    private Player player1;
    private Player player2;
    private Random random;
    private Scanner scanner;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void initializeGame(int initialChips) {
    	scanner = new Scanner(System.in);
    	String player1Name, player2Name;
        System.out.println("Enter a name for player1 : ");
        player1Name = scanner.nextLine().trim();
        System.out.println("Enter a name for player2 : ");
        player2Name = scanner.nextLine().trim();
        player1 = new Player(initialChips, player1Name);
        player2 = new Player(initialChips, player2Name);
    }

    public void player1Wins(int player1Chips, int player2Chips) {
        player1.addChips(player1Chips + player2Chips);
    }

    public void player2Wins(int player1Chips, int player2Chips) {
        player2.addChips(player1Chips + player2Chips);
    }

    public boolean isGameOver() {
        return player1.getChips() <= 0 || player2.getChips() <= 0;
    }

    public void play() {
    	scanner = new Scanner(System.in);
        random = new Random();
        int roundCount = 0;
        int player1Betting = 0, player2Betting = 0;
        boolean player1Choice = false, player2Choice = false;

//        initializeGame(30);

        while (roundCount < 13 && !isGameOver()) {
            roundCount++;
            player1Betting = 0;
            player2Betting = 0;
            Card player1Card = player1.getDeck().drawRandomCard();
            Card player2Card = player2.getDeck().drawRandomCard();

            int whoFirstBet = random.nextInt(2);
            SC.cls();

            if (whoFirstBet == 0) {
                System.out.println("The coin comes up heads, it's "+player1.getName()+"'s turn to bet first.");
                System.out.println(player1.getName()+"'s turn. Press any key to continue...");
                scanner.nextLine();
                showChipCounts(roundCount);
                System.out.println(player2.getName()+"'s card:");
                System.out.println(player2Card.getPattern());

                player1Choice = getPlayerBettingChoice(scanner, player1);

                if (player1Choice) {
                    player1Betting = getPlayerBettingAmount(scanner, player1);
                    
                    System.out.println(player2.getName()+"'s turn. Press any key to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    
                    showChipCounts(roundCount);
                    
                    System.out.println(player1.getName()+" bet " + player1Betting + " chips.");
                    System.out.println(player1.getName()+"'s card:");
                    System.out.println(player1Card.getPattern());

                } else {
                    System.out.println(player1.getName()+" folds. Losing 2 chips.");
                    player1.removeChips(2);
                    
                    System.out.println("================================================");
                    System.out.println(player1.getName()+"'s card:");
                    System.out.println(player1Card.getPattern());
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());
                    System.out.println("================================================");
                    
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();

                    continue;
                }


                
                player2Choice = getPlayerBettingChoice(scanner, player2);
                if (player2Choice) {
                    player2Betting = getPlayerBettingAmount(scanner, player2);
                    System.out.println(player2.getName()+" bet " + player2Betting + " chips.");
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());
                } else {
                    System.out.println(player2.getName()+" folds. Losing 2 chips. "+player1.getName()+" wins.");
                    player2.removeChips(2);
                    player1.addChips(player1Betting);
                    
                    System.out.println("================================================");
                    System.out.println(player1.getName()+"'s card:");
                    System.out.println(player1Card.getPattern());
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());
                    System.out.println("================================================");
                    
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();

                    continue;
                }
            } else {
                System.out.println("The coin comes up tails, it's "+player2.getName()+"'s turn to bet first.");
                System.out.println(player2.getName()+"'s turn. Press any key to continue...");
                scanner.nextLine();
                showChipCounts(roundCount);
                System.out.println(player1.getName()+"'s card:");
                System.out.println(player1Card.getPattern());
                
                player2Choice = getPlayerBettingChoice(scanner, player2);
                
                
                if (player2Choice) {
                    player2Betting = getPlayerBettingAmount(scanner, player2);
                    System.out.println(player1.getName()+"'s turn. Press any key to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    
                    showChipCounts(roundCount);
                    
                    System.out.println(player2.getName()+" bet " + player2Betting + " chips.");
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());

                } else {
                    System.out.println(player2.getName()+" folds. Losing 2 chips.");
                    player2.removeChips(2);
                    System.out.println("================================================");
                    System.out.println(player1.getName()+"'s card:");
                    System.out.println(player1Card.getPattern());
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());
                    System.out.println("================================================");
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();

                    continue;
                }


                
                player1Choice = getPlayerBettingChoice(scanner, player1);
                if (player1Choice) {
                    player1Betting = getPlayerBettingAmount(scanner, player1);
//                    System.out.println("================================================");
//                    System.out.println(player1.getName()+" bet " + player1Betting + " chips.");
//                    System.out.println(player1.getName()+"'s card:");
//                    System.out.println(player1Card.getPattern());
//                    System.out.println("================================================");
                } else {
                    System.out.println(player1.getName()+" folds. Losing 2 chips. "+player2.getName()+" wins.");
                    player1.removeChips(2);
                    player2.addChips(player2Betting);
                    
                    System.out.println("================================================");
                    System.out.println(player1.getName()+"'s card:");
                    System.out.println(player1Card.getPattern());
                    System.out.println(player2.getName()+"'s card:");
                    System.out.println(player2Card.getPattern());
                    System.out.println("================================================");
                    
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();

                    continue;
                }
            }

            System.out.println("================================================");
            System.out.println(player1.getName()+"'s card:");
            System.out.println(player1Card.getPattern());
            System.out.println(player2.getName()+"'s card:");
            System.out.println(player2Card.getPattern());
            System.out.println("================================================");

            if (player1Card.getRank() > player2Card.getRank()) {
                System.out.println(player1.getName()+" wins the round.");
                player1Wins(player1Betting, player2Betting);
            } else if (player1Card.getRank() < player2Card.getRank()) {
                System.out.println(player2.getName()+" wins the round.");
                player2Wins(player1Betting, player2Betting);
            } else {
                System.out.println("Round is a tie.");
                player1.addChips(player1Betting);
                player2.addChips(player2Betting);
            }

            showChipCounts(roundCount);

            System.out.println("Press any key to continue to the next round...");
            scanner.nextLine();
            scanner.nextLine();
        }

        determineWinner();
    }
    
    
    private boolean getPlayerBettingChoice(Scanner scanner, Player player) {
        while (true) {
            System.out.println(player2.getName()+", do you want to Bet (Y) or Fold (N)? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    private int getPlayerBettingAmount(Scanner scanner, Player player) {
        while (true) {
            System.out.print("Enter the number of chips to bet (1-20): ");
            try {
                int amount = scanner.nextInt();
                if (amount > 0 && amount <= 20 && amount <= player.getChips()) {
                    player.removeChips(amount);
                    SC.cls();
                    return amount;
                } else {
                    System.out.println("Invalid amount. Please enter a number between 1 and 20, and no more than your current chips.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

    }

    private void determineWinner() {
        System.out.println("\n================================================");
        System.out.println("Game Over");
        System.out.println(player1.getName()+"'s chips: " + player1.getChips());
        System.out.println(player2.getName()+"'s chips: " + player2.getChips());
        if (player1.getChips() > player2.getChips()) {
            System.out.println(player1.getName()+"  wins!");
        } else if (player1.getChips() < player2.getChips()) {
            System.out.println(player2.getName()+"  wins!");
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println("================================================");
    }

    private void showChipCounts(int roundCount) {
        System.out.println("================================================");
        System.out.println("Round " + roundCount);
        System.out.println(player1.getName()+"'s chips: " + player1.getChips());
        System.out.println(player2.getName()+"'s chips: " + player2.getChips());
        System.out.println("================================================\n\n\n");
    }

    public PvP(int initialChips) {
        this.initializeGame(initialChips);
    }
}
