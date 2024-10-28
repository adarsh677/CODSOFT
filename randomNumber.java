
import java.util.Scanner;
import java.util.Random;

public class randomNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playGame(scanner); 
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
        
        scanner.close();

    }

    public static void playGame(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        int maxAttempts = 3;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("please choose a number between 0 to 100");
        System.out.println("we have " + maxAttempts + " attempts");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess;

            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
                scanner.next(); 
                continue;
            }

            attempts++;

           
            if (guess < randomNumber) {
                System.out.println("Too low");
            } else if (guess > randomNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Congratulations -- it's a correct guess  " + randomNumber +
                                   " in " + attempts + " attempts");
                score += (maxAttempts - attempts); 
                break;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts The correct number was " + randomNumber + ".");
        }

        System.out.println("Your score is _ " + score);
    }
}
