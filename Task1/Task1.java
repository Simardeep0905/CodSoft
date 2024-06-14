import java.util.*;

public class Task1 {
   
    public static void main(String[] args) {
        guessTheNumber();
    }

	public static void guessTheNumber() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            int number = 1 + random.nextInt(100);
            int K = 7; 
            int i, guess;

            System.out.println("Welcome to the number game. You have to guess the number within " + K + " trials to win.");

            for (i = 0; i < K; i++) {
                System.out.println("Guess the number:");
                guess = sc.nextInt();

                if (number == guess) {
                    System.out.println("Congratulations! You have guessed the number.");
                    break;
                } else if (number > guess) {
                    System.out.println("The number is greater than " + guess);
                } else if (number < guess) {
                    System.out.println("The number is less than " + guess);
                }
            }

            if (i == K) {
                System.out.println("You have exhausted all the " + K + " trials.");
                System.out.println("The number was " + number);
            }

            System.out.println("Do you want to play again? (Y/N):");
            playAgain = sc.next().toUpperCase();
        } while (playAgain.equals("Y"));

        sc.close();
    }
}