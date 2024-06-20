package indian;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PvE {

    private Player player;
    private Player computer;
    private Random random;
    private Scanner scanner;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public void initializeGame(int initialChips) {
        player = new Player(initialChips, "Player");
        computer = new Player(initialChips, "Computer");
    }

    public void playerWins(int playerChips, int computerChips) {
        player.addChips(playerChips + computerChips); // Player wins both their own and Computer's chips
    }

    public void computerWins(int playerChips, int computerChips) {
        computer.addChips(playerChips + computerChips); // Computer wins both their own and Player's chips
    }

    public boolean isGameOver() {
        return player.getChips() <= 0 || computer.getChips() <= 0;
    }

    public void play() {
        scanner = new Scanner(System.in);
        random = new Random();
        int roundCount = 0;
        int playerBetting = 0, computerBetting = 0;
        boolean playerChoice = false, computerChoice = false;

        initializeGame(30);

        while (roundCount < 13 && !isGameOver()) {
            roundCount++;
            playerBetting = 0;
            computerBetting = 0;
            Card playerCard = player.getDeck().drawRandomCard();
            Card computerCard = computer.getDeck().drawRandomCard();

            int whoFirstBet = random.nextInt(2);
            SC.cls();
            if (whoFirstBet == 0) {
                System.out.println("The coin comes up heads, it's Player's turn to bet first.");
                System.out.println("Player's turn. Press any key to continue...");
                scanner.nextLine();
                showNumOfChips(roundCount);
                System.out.println("Computer's card:");
                System.out.println(computerCard.getPattern());

                playerChoice = getBettingChoice(scanner, player);
                if (playerChoice) {
                    playerBetting = getBettingAmount(scanner, player);
                    System.out.println("================================================");
                    System.out.println("Player bet " + playerBetting + " chips.");
                    System.out.println("================================================");

                    System.out.println("Computer's turn. Press any key to continue...");
                    scanner.nextLine();

                    computerChoice = getComputerBettingChoice(playerCard.getRank(), playerBetting);
                    if (computerChoice) {
                        computerBetting = getComputerBettingAmount(playerCard.getRank(), playerBetting);
                        System.out.println("================================================");
                        System.out.println("Computer bet " + computerBetting + " chips.");
                    } else {
                        System.out.println("Computer folds. Losing 2 chips. Player wins.");
                        computer.removeChips(2);
                        player.addChips(playerBetting); // Player wins the bet
                        
                        System.out.println("================================================");
                        System.out.println("Player 's card:");
                        System.out.println(playerCard.getPattern());
                        System.out.println("Computer's card:");
                        System.out.println(computerCard.getPattern());
                        System.out.println("================================================");
                        
                        System.out.println("Press any key to continue to the next round...");
                        scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("Player folds. Losing 2 chips.");
                    player.removeChips(2);
                    
                    System.out.println("================================================");
                    System.out.println("Player 's card:");
                    System.out.println(playerCard.getPattern());
                    System.out.println("Computer's card:");
                    System.out.println(computerCard.getPattern());
                    System.out.println("================================================");
                    
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();
                    continue;
                }
            } else {
                System.out.println("The coin comes up tails, it's Computer's turn to bet first.");
                System.out.println("Computer's turn. Press any key to continue...");
                scanner.nextLine();

                computerChoice = getComputerBettingChoice(playerCard.getRank(), 0);
                if (computerChoice) {
                    computerBetting = getComputerBettingAmount(playerCard.getRank(), 0);

                    System.out.println("Player's turn. Press any key to continue...");
                    scanner.nextLine();
                    showNumOfChips(roundCount);
                    
                    System.out.println("================================================");
                    System.out.println("Computer bet " + computerBetting + " chips.");
                    System.out.println("Computer's card:");
                    System.out.println(computerCard.getPattern());
                    System.out.println("================================================");


                    playerChoice = getBettingChoice(scanner, player);
                    if (playerChoice) {
                        playerBetting = getBettingAmount(scanner, player);
                        System.out.println("================================================");
                        System.out.println("Player bet " + playerBetting + " chips.");
                    } else {
                        System.out.println("Player folds. Losing 2 chips. Computer wins.");
                        player.removeChips(2);
                        
                        System.out.println("================================================");
                        System.out.println("Player 's card:");
                        System.out.println(playerCard.getPattern());
                        System.out.println("Computer's card:");
                        System.out.println(computerCard.getPattern());
                        System.out.println("================================================");
                        
                        computer.addChips(computerBetting); // Computer wins the bet
                        System.out.println("Press any key to continue to the next round...");
                        scanner.nextLine();
                        scanner.nextLine();
                        continue;
                    }
                } else {
                    System.out.println("Computer folds. Losing 2 chips.");
                    
                    System.out.println("================================================");
                    System.out.println("Player 's card:");
                    System.out.println(playerCard.getPattern());
                    System.out.println("Computer's card:");
                    System.out.println(computerCard.getPattern());
                    System.out.println("================================================");
                    
                    computer.removeChips(2);
                    System.out.println("Press any key to continue to the next round...");
                    scanner.nextLine();
                    
                    continue;
                }
            }

            System.out.println("================================================");
            System.out.println("Player's card:");
            System.out.println(playerCard.getPattern());
            System.out.println("Computer's card:");
            System.out.println(computerCard.getPattern());
            System.out.println("================================================");

            if (playerCard.getRank() > computerCard.getRank()) {
                System.out.println("Player wins the round.");
                playerWins(playerBetting, computerBetting); // Player wins both their own and Computer's chips
            } else if (playerCard.getRank() < computerCard.getRank()) {
                System.out.println("Computer wins the round.");
                computerWins(playerBetting, computerBetting); // Computer wins both their own and Player's chips
            } else {
                System.out.println("Round is a tie.");
                player.addChips(playerBetting);
                computer.addChips(computerBetting);
            }

            System.out.println("================================================");
            System.out.println("Chips after round " + roundCount + ":");
            System.out.println("Player: " + player.getChips());
            System.out.println("Computer: " + computer.getChips());
            System.out.println("================================================");

            System.out.println("Press any key to continue to the next round...");
            scanner.nextLine();
        }

        determineWinner();
    }

    private boolean getBettingChoice(Scanner scanner, Player player) {
        while (true) {
            System.out.println("Player, do you want to Bet (Y) or Fold (N)? ");
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

    private int getBettingAmount(Scanner scanner, Player player) {
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

    private boolean getComputerBettingChoice(int playerCardRank, int playerBettingAmount) {
        Random random = new Random();
        int computerBettingPercentage = 0;

        if (playerCardRank == 1) { computerBettingPercentage = 85; }
        else if (playerCardRank == 2) { computerBettingPercentage = 80; }
        else if (playerCardRank == 3) { computerBettingPercentage = 75; }
        else if (playerCardRank == 4) { computerBettingPercentage = 70; }
        else if (playerCardRank == 5) { computerBettingPercentage = 65; }
        else if (playerCardRank == 6) { computerBettingPercentage = 60; }
        else if (playerCardRank == 7) { computerBettingPercentage = 55; }
        else if (playerCardRank == 8) { computerBettingPercentage = 50; }
        else if (playerCardRank == 9) { computerBettingPercentage = 45; }
        else if (playerCardRank == 10) { computerBettingPercentage = 40; }
        else if (playerCardRank == 11) { computerBettingPercentage = 35; }
        else if (playerCardRank == 12) { computerBettingPercentage = 30; }
        else if (playerCardRank == 13) { computerBettingPercentage = 20; }

        int com_want_betting = random.nextInt(100) + 1;
        return com_want_betting <= computerBettingPercentage;
    }

    private int getComputerBettingAmount(int playerCardRank, int playerBettingAmount) {
        Random random = new Random();
        int computerBetting = 0;
        int B = 0;

        for (int i = 0; i < 1; i++) {
            if (playerCardRank == 13) { computerBetting = random.nextInt(2) + 1; }
            else if (playerCardRank == 12) { computerBetting = random.nextInt(2) + 1; }
            else if (playerCardRank == 11) { computerBetting = random.nextInt(2) + 1; }
            else if (playerCardRank == 10) {
                int computerBettingChoice = random.nextInt(3) + 1;
                if (computerBettingChoice == 1) { computerBetting = 3; }
                else if (computerBettingChoice == 2) { computerBetting = 4; }
                else if (computerBettingChoice == 3) { computerBetting = 5; }
            }
            else if (playerCardRank == 9) {
                int computerBettingChoice = random.nextInt(4) + 1;
                if (computerBettingChoice == 1) { computerBetting = 4; }
                else if (computerBettingChoice == 2) { computerBetting = 5; }
                else if (computerBettingChoice == 3) { computerBetting = 6; }
                else if (computerBettingChoice == 4) { computerBetting = 7; }
            }
            else if (playerCardRank == 8) {
                int computerBettingChoice = random.nextInt(3) + 1;
                if (computerBettingChoice == 1) { computerBetting = 6; }
                else if (computerBettingChoice == 2) { computerBetting = 7; }
                else if (computerBettingChoice == 3) { computerBetting = 8; }
            }
            else if (playerCardRank == 7) {
                int computerBettingChoice = random.nextInt(4) + 1;
                if (computerBettingChoice == 1) { computerBetting = 7; }
                else if (computerBettingChoice == 2) { computerBetting = 8; }
                else if (computerBettingChoice == 3) { computerBetting = 9; }
                else if (computerBettingChoice == 4) { computerBetting = 10; }
            }
            else if (playerCardRank == 6) {
                int computerBettingChoice = random.nextInt(3) + 1;
                if (computerBettingChoice == 1) { computerBetting = 9; }
                else if (computerBettingChoice == 2) { computerBetting = 10; }
                else if (computerBettingChoice == 3) { computerBetting = 11; }
            }
            else if (playerCardRank == 5) {
                int computerBettingChoice = random.nextInt(4) + 1;
                if (computerBettingChoice == 1) { computerBetting = 10; }
                else if (computerBettingChoice == 2) { computerBetting = 11; }
                else if (computerBettingChoice == 3) { computerBetting = 12; }
                else if (computerBettingChoice == 4) { computerBetting = 13; }
            }
            else if (playerCardRank == 4) {
                int computerBettingChoice = random.nextInt(3) + 1;
                if (computerBettingChoice == 1) { computerBetting = 11; }
                else if (computerBettingChoice == 2) { computerBetting = 12; }
                else if (computerBettingChoice == 3) { computerBetting = 13; }
            }
            else if (playerCardRank == 3) {
                int computerBettingChoice = random.nextInt(4) + 1;
                if (computerBettingChoice == 1) { computerBetting = 13; }
                else if (computerBettingChoice == 2) { computerBetting = 14; }
                else if (computerBettingChoice == 3) { computerBetting = 15; }
                else if (computerBettingChoice == 4) { computerBetting = 16; }
            }
            else if (playerCardRank == 2) {
                int computerBettingChoice = random.nextInt(3) + 1;
                if (computerBettingChoice == 1) { computerBetting = 14; }
                else if (computerBettingChoice == 2) { computerBetting = 15; }
                else if (computerBettingChoice == 3) { computerBetting = 16; }
            }
            else if (playerCardRank == 1) {
                int computerBettingChoice = random.nextInt(5) + 1;
                if (computerBettingChoice == 1) { computerBetting = 16; }
                else if (computerBettingChoice == 2) { computerBetting = 17; }
                else if (computerBettingChoice == 3) { computerBetting = 18; }
                else if (computerBettingChoice == 4) { computerBetting = 19; }
                else if (computerBettingChoice == 5) { computerBetting = 20; }
            }

            if (computerBetting > computer.getChips()) {
                if (B < 5) {
                    i--;
                    B++;
                } else if (B == 5) {
                    if (computer.getChips() <= 5) {
                        computerBetting = random.nextInt(5) + 1;
                    } else if (computer.getChips() > 5 && computer.getChips() <= 10) {
                        computerBetting = random.nextInt(5) + 6;
                    } else if (computer.getChips() > 10 && computer.getChips() <= 15) {
                        computerBetting = random.nextInt(5) + 11;
                    } else if (computer.getChips() > 15 && computer.getChips() <= 20) {
                        computerBetting = random.nextInt(5) + 16;
                    }
                }
            }
        }

        computer.removeChips(computerBetting);
        SC.cls();
        return computerBetting;
    }

//    private boolean nextRoundPrompt(Scanner scanner) {
//        while (true) {
//            System.out.println("Do you want to continue to the next round? (Y/N)");
//            String response = scanner.nextLine().trim().toLowerCase();
//            if (response.equals("y")) {
//                return true;
//            } else if (response.equals("n")) {
//                return false;
//            } else {
//                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
//            }
//        }
//    }

    private void determineWinner() {
        System.out.println("\n================================================");
        System.out.println("Game Over");
        System.out.println("Player's chips: " + player.getChips());
        System.out.println("Computer's chips: " + computer.getChips());
        if (player.getChips() > computer.getChips()) {
            System.out.println("Player wins!");
        } else if (player.getChips() < computer.getChips()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println("================================================");
    }

    private void showNumOfChips(int roundCount) {
        System.out.println("================================================");
        System.out.println("Round " + roundCount);
        System.out.println("Player's chips: " + player.getChips());
        System.out.println("Computer's chips: " + computer.getChips());
        System.out.println("================================================\n\n\n");
    }

    public PvE(int initialChips) {
        this.initializeGame(initialChips);
    }
}
