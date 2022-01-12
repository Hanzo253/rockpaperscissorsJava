import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Rock, Paper, Scissors!");
        chooseMode();
    }

    public static void chooseMode() {
        boolean modeChosen = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Type 'vs. computer' to play against the computer.");
        System.out.println("2. Type '2 players' to play against another player.\n");
        String mode = scanner.nextLine();
        while (!modeChosen) {
            if (mode.equals("vs. computer")) {
                System.out.println("\nPlaying against computer.");
                modeChosen = true;
            } else if (mode.equals("2 players")) {
                System.out.println("\nPlaying against another player.");
                modeChosen = true;
            } else {
                System.out.println("\nInvalid mode, try again.");
                System.out.println("\n1. Type 'vs. computer' to play against the computer.");
                System.out.println("2. Type '2 players' to play against another player.\n");
                mode = scanner.nextLine();
            }
        }
        mainMenu(scanner, mode);
    }

    public static void mainMenu(Scanner scanner, String modeInput) {
//        System.out.println(modeInput);
        boolean optionChosen = false;
        System.out.println("\nMAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.\n");
        String option = scanner.next();
        menuOptionChoice(scanner, modeInput, option);
    }

    public static void menuOptionChoice(Scanner scanner, String modeInput, String optionInput) {
        if (modeInput.equals("vs. computer")) {
            switch (optionInput) {
                case "play":
                    System.out.println("\nType 'rock', 'paper', or 'scissors' to play.");
                    System.out.println("Type 'quit' to go back to the main menu.\n");
                    String playMenuOption = scanner.next();
                    if (playMenuOption.equals("quit")) {
                        System.out.println("\nReturning to main menu...");
                        mainMenu(scanner, modeInput);
                    }
                    break;
                case "history":
                    System.out.println("\nhistory option chosen.");
                    break;
                case "quit":
                    System.out.println("\nquitting...");
                    break;
                default:
                    System.out.println("Invalid option, try again.\n");
                    System.out.println("1. Type 'play' to play.");
                    System.out.println("2. Type 'history' to view your game history.");
                    System.out.println("3. Type 'quit' to stop playing.\n");
                    optionInput = scanner.next();
            }
        } else if (modeInput.equals("2 players")) {
            switch (optionInput) {
                case "play":
                    System.out.println("\nplay option chosen.");
                    break;
                case "history":
                    System.out.println("\nhistory option chosen.");
                    break;
                case "quit":
                    System.out.println("\nquitting...");
                    break;
                default:
                    System.out.println("Invalid option, try again.\n");
                    System.out.println("1. Type 'play' to play.");
                    System.out.println("2. Type 'history' to view your game history.");
                    System.out.println("3. Type 'quit' to stop playing.\n");
                    optionInput = scanner.next();
            }
        }
    }

    public static String getComputerChoice() {
        ArrayList<String> choices = new ArrayList<String>(3);
        choices.add("rock");
        choices.add("paper");
        choices.add("scissors");
//        System.out.println(choices);
        Random random = new Random();
        int randomNum = random.nextInt(3);
        String computerChoice = choices.get(randomNum);
        return computerChoice;
    }
}
