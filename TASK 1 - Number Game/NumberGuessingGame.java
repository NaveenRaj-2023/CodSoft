import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int rounds = 3;
        int totalRounds = 3;
        int correctGuess = 0;
        int guessesPerRound = 5;
        boolean toPlay = true;       
        System.out.println("Welcome to the Number Guessing Game!");
        int round =1;
        for ( ; round <= totalRounds && toPlay ; round++) {
            int targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            System.out.println("\nRound " + round + ": Guess a number between 1 and 100.");
            
            for (int guessCount = 1; guessCount <= guessesPerRound; guessCount++) {
                System.out.print("Guess #" + guessCount + ": ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + guessCount + " guesses.");
                    correctGuess++;
                    break;
                }
                
                if (guessCount == guessesPerRound) {
                    System.out.println("Out of guesses. The correct number was: " + targetNumber);
                }
            }
            System.out.println("would you like to play next round (true/false) : ");
         toPlay = scanner.nextBoolean();
        }

        scanner.close();
        System.out.println("Out of "+rounds+" rounds you guessed "+correctGuess+" time's "+"successfully");
        System.out.println("\nGame over. Thank you for playing!");
    }
}
