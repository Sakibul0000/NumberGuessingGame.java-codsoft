import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static void playRound(int round) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
        boolean correctGuess = false;

        System.out.println("Round " + round + ":");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");
        
        while (attempts < maxAttempts && !correctGuess) {
            attempts++;
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < targetNumber) {
                System.out.println("Your guess is too low.");
            } else if (userGuess > targetNumber) {
                System.out.println("Your guess is too high.");
            } else {
                correctGuess = true;
                System.out.println("Congratulations! You guessed the correct number!");
            }

            if (attempts == maxAttempts && !correctGuess) {
                System.out.println("Sorry! You've run out of attempts. The correct number was " + targetNumber);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int round = 1;

        while (true) {
            playRound(round);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("yes")) {
                score++;
                round++;
            } else {
                System.out.println("Thank you for playing! Your total score is: " + score);
                break;
            }
        }
    }
}
