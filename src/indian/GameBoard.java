package indian;

import java.util.Scanner;
import java.util.InputMismatchException;


public class GameBoard {
	
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = getModeChoice(scanner);

            switch (choice) {
                case 1:
                    this.explainPvE();
                    System.out.println("You've selected Single Player (PVE) mode. Do you want to play? (y/n)");
                    if (confirm(scanner)) {
//                        int chipCount = getChipCount(scanner);
//                        if (chipCount != -1) {
                        	PvE pveGame = new PvE(0);
                        	pveGame.play();
//                        }
                    }
                    break;
                case 2:
                    this.explainPvP();
                    System.out.println("You have selected multiplayer (2 player) mode. Do you want to play? (y/n)");
                    if (confirm(scanner)) {
                        int chipCount = getChipCount(scanner);
                        if (chipCount != -1) {
                        	PvP pvpGame = new PvP(chipCount);
                        	pvpGame.play();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please select again.");
            }

            System.out.println("Do you want to quit the game? (y/n)");
            if (confirm(scanner)) {
                break;
            }
        }

        scanner.close();
    }
    
    public int getModeChoice(Scanner scanner) {
        while (true) {
            System.out.println("Which mode do you want to play in? Select a number:");
            System.out.println("1. Single-play(PvE)");
            System.out.println("2. Multi-play(PvP)");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    
		
    public boolean confirm(Scanner scanner) {
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter a valid value. (y/n)");
            }
        }
    }
    
    public int getChipCount(Scanner scanner) {
        while (true) {
            System.out.println("Enter the number of chips you want to play:");
            try {
                int chipCount = scanner.nextInt();
                scanner.nextLine();  // 개행 문자 제거
                return chipCount;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();  // 잘못된 입력 제거
            }
        }
    }
	
	private void explainPvE()
	{
		System.out.println("****** Indian Poker(PvE) ******\n\n");
		System.out.println("<<<Rule>>>\n");
		System.out.print("<<<Rules>>>\r\n"
				+ "\r\n"
				+ "1. there are 2 sets of cards with the numbers 1 through 13 on them (cards are played only once and then discarded).\r\n"
				+ "2. 1 card per round is dealt randomly to the computer and the player (13 rounds in total).\r\n"
				+ "3. The order of bets in each round is randomized (1/2 chance).\r\n"
				+ "4. players look at each other's cards and choose whether to bet or not (if they choose to give up, they lose 2 chips).\r\n"
				+ "5. Bets are placed once by both players and the computer.\r\n"
				+ "6. The maximum number of chips that can be bet is 20 (the computer can also bet 20).\r\n"
				+ "7. After betting, check the cards.\r\n"
				+ "8. Give the chips you bet to the winner.(in case of a tie, they get their bet back).\r\n"
				+ "9. The player with more chips at the end of all 13 rounds wins. (If you lose all your chips before the end of the 13th round, you lose)\n\n\n");
	}
	
	private void explainPvP()
	{
		System.out.println("****** Indian Poker(PvP) ******\n\n");
		System.out.println("<<<Rule>>>\n");
		System.out.print("1. there are 2 sets of cards with the numbers 1 through 13 on them (cards are played once and discarded).\r\n"
				+ "2. 1 card per round is dealt randomly to both players (13 rounds in total).\r\n"
				+ "3. The order of bets in each round is randomized (1/2 chance).\r\n"
				+ "4. players look at each other's cards and choose whether to bet or not (if they choose to give up, they lose 2 chips).\r\n"
				+ "5. Bets can be placed once per player.\r\n"
				+ "6. After betting, check the cards.\r\n"
				+ "7. Give the chips you bet to the winner.\r\n"
				+ "8. The player with more chips at the end of all 13 rounds wins. (if you lose all your chips before the 13th round, you lose)\n\n\n");
	}
}
