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
        menuOptions(scanner);
    }

    public static void menuOptions(Scanner scanner) {
        boolean optionChosen = false;
        System.out.println("\nMAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.\n");
        String option = scanner.next();
//        while (!optionChosen) {
//            if (option.equals("play")) {
//                System.out.println("\nplay option chosen.");
//                optionChosen = true;
//            } else if (option.equals("history")) {
//                System.out.println("\nPlaying against another player.");
//                optionChosen = true;
//            } else {
//                System.out.println("\nInvalid input, try again.");
//                System.out.println("\n1. Type 'vs. computer' to play against the computer.");
//                System.out.println("2. Type '2 players' to play against another player.\n");
//                option = scanner.next();
//            }
//        }
        switch (option) {
            case "play":
                System.out.println("\nplay option chosen.");
                break;
            case "history":
                System.out.println("\nhistory option chosen.");
                break;
            case "quit":
                System.out.println("quitting...");
                break;
            default:
                System.out.println("Invalid option, try again.");
                System.out.println("1. Type 'play' to play.");
                System.out.println("2. Type 'history' to view your game history.");
                System.out.println("3. Type 'quit' to stop playing.\n");
                option = scanner.next();
        }
    }
}
