import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chooseMode();
    }

    // choosing either two player mode or computer mode
    public static void chooseMode() {
        boolean modeChosen = false;
        Scanner scanner = new Scanner(System.in);
        // asking for which mode
        System.out.println("\n1. Type 'vs. computer' to play against the computer.");
        System.out.println("2. Type '2 players' to play against another player.\n");
        String mode = scanner.nextLine();
        // after mode is selected, it will display a message based on the mode chosen
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
        // go to main menu
        mainMenu(scanner, mode);
    }

    // main menu of rock paper scissors
    public static void mainMenu(Scanner scanner, String modeInput) {
//        System.out.println(modeInput);
        boolean optionChosen = false;
        System.out.println("\nWelcome to Rock, Paper, Scissors!");
        System.out.println("\nMAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("3. Type 'quit' to stop playing.\n");
        String option = scanner.next();
        menuOptionChoice(scanner, modeInput, option);
    }

    // runs when an option from the main menu has been chosen by the user
    public static void menuOptionChoice(Scanner scanner, String modeInput, String optionInput) {
        Users playerOne = new Users();
        boolean twoPlayers = false;
        boolean optionInputChosen = false;
        String playMenuOption = "";
        if (modeInput.equals("vs. computer")) {
            twoPlayers = false;
            do {
                switch (optionInput) {
                    case "play":
                        System.out.println("\nType 'rock', 'paper', or 'scissors' to play.");
                        System.out.println("Type 'quit' to go back to the main menu.\n");
                        playMenuOption = scanner.next();
                        playerOne.setChoice(playMenuOption);
                        if (playMenuOption.equals("quit")) {
                            System.out.println("\nReturning to main menu...");
                            mainMenu(scanner, modeInput);
                        } else {
                            startGame(scanner, playerOne.getChoice(), twoPlayers);
                        }
                        optionInputChosen = true;
                        break;
                    case "quit":
                        System.out.println("\nquitting...");
                        optionInputChosen = true;
                        break;
                    default:
                        System.out.println("Invalid option, try again.\n");
                        System.out.println("1. Type 'play' to play.");
                        System.out.println("3. Type 'quit' to stop playing.\n");
                        optionInput = scanner.next();
                }
            } while (!optionInputChosen);
        } else if (modeInput.equals("2 players")) {
            twoPlayers = true;
            do {
                switch (optionInput) {
                    case "play":
                        System.out.println("\nType 'rock', 'paper', or 'scissors' to play.");
                        System.out.println("Type 'quit' to go back to the main menu.\n");
                        playMenuOption = scanner.next();
                        playerOne.setChoice(playMenuOption);
                        if (playMenuOption.equals("quit")) {
                            System.out.println("\nReturning to main menu...");
                            mainMenu(scanner, modeInput);
                        } else {
                            startGame(scanner, playerOne.getChoice(), twoPlayers);
                        }
                        optionInputChosen = true;
                        break;
                    case "quit":
                        System.out.println("\nquitting...");
                        optionInputChosen = true;
                        break;
                    default:
                        System.out.println("Invalid option, try again.\n");
                        System.out.println("1. Type 'play' to play.");
                        System.out.println("2. Type 'history' to view your game history.");
                        System.out.println("3. Type 'quit' to stop playing.\n");
                        optionInput = scanner.next();
                }
            } while (!optionInputChosen);
        }
    }

    // return the rock paper scissors choice of the computer
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

    // starts the game after 'play' has been typed
    public static void startGame(Scanner scanner, String choice, boolean twoPlayerMode) {
        boolean choiceMade = false;
        if (!twoPlayerMode) {
            do {
                switch (choice) {
                    case "rock":
                    case "scissors":
                    case "paper":
                        computeWin(scanner, choice, twoPlayerMode);
                        choiceMade = true;
                        break;
                    default:
                        System.out.println("\nInvalid choice, try again.");
                        System.out.println("\nType 'rock', 'paper', or 'scissors' to play.");
                        System.out.println("Type 'quit' to go back to the main menu.\n");
                        choice = scanner.next();
                }
            } while (!choiceMade);
        } else {
            System.out.println("\nPlayer Two's turn");
            do {
                switch (choice) {
                    case "rock":
                    case "scissors":
                    case "paper":
                        computeWin(scanner, choice, twoPlayerMode);
                        choiceMade = true;
                        break;
                    default:
                        System.out.println("\nInvalid choice, try again.");
                        System.out.println("\nType 'rock', 'paper', or 'scissors' to play.");
                        System.out.println("Type 'quit' to go back to the main menu.\n");
                        choice = scanner.next();
                }
            } while (!choiceMade);
        }
    }

    // computes the win based on the choices of player one, player two, and the computer
    public static void computeWin(Scanner scanner, String playerOneChoice, boolean twoPlayerMode) {
        Computer computer = new Computer(getComputerChoice());
//        String computerChoice = "";
        String playerTwoChoice = "";
        String userName = "";
        if (!twoPlayerMode) {
//            computerChoice = getComputerChoice();
            userName = "User";
            System.out.println("\nComputer picks: " + computer.getComputerChoice());
            System.out.println("User picks: " + playerOneChoice);
        } else {
            userName = "Player One";
            boolean playerTwoChosen = false;
            System.out.println("\nType 'rock', 'paper', or 'scissors' to play.\n");
            playerTwoChoice = scanner.next();
            while (!playerTwoChosen) {
                if (playerTwoChoice.equals("rock") || playerTwoChoice.equals("paper") || playerTwoChoice.equals("scissors")) {
                    System.out.println("\nPlayer One picks: " + playerOneChoice);
                    System.out.println("Player Two picks: " + playerTwoChoice);
                    playerTwoChosen = true;
                } else {
                    System.out.println("Invalid choice Player Two, try again.");
                }
            }
        }
        switch (playerOneChoice) {
            case "rock":
                if (computer.getComputerChoice().equals("paper") || playerTwoChoice.equals("paper")) {
                    System.out.println(userName + " loses!");
                    chooseMode();
                } else if (computer.getComputerChoice().equals("scissors") || playerTwoChoice.equals("scissors")) {
                    System.out.println(userName + " wins!");
                    chooseMode();
                } else {
                    System.out.println("Draw!");
                    chooseMode();
                }
                break;
            case "paper":
                if (computer.getComputerChoice().equals("scissors") || playerTwoChoice.equals("scissors")) {
                    System.out.println(userName + " loses!");
                    chooseMode();
                } else if (computer.getComputerChoice().equals("rock") || playerTwoChoice.equals("rock")) {
                    System.out.println(userName + " wins!");
                    chooseMode();
                } else {
                    System.out.println("Draw!");
                    chooseMode();
                }
                break;
            case "scissors":
                if (computer.getComputerChoice().equals("rock") || playerTwoChoice.equals("rock")) {
                    System.out.println(userName + " loses!");
                    chooseMode();
                } else if (computer.getComputerChoice().equals("paper") || playerTwoChoice.equals("paper")) {
                    System.out.println(userName + " wins!");
                    chooseMode();
                } else {
                    System.out.println("Draw!");
                    chooseMode();
                }
                break;
            default:
                break;
        }
    }
}
