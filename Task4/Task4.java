import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;
    private int timeLimit;

    public Quiz(String question, String[] options, int correctAnswer, int timeLimit) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}

public class Task4 {
    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[] {
            new Quiz("Which animal is known as the 'Ship of the Desert'?", new String[] {"Camel", "Dog", "Cat", "Horse"}, 0, 10),
            new Quiz("How many days are there in a year?", new String[] {"300", "350", "365", "366"}, 2, 10),
            new Quiz("Which animal is known as the king of the jungle?", new String[] {"Camel", "Tiger", "Lion", "Horse"}, 2, 10),
        };

        int score = 0;
        for (Quiz quiz : quizzes) {
            System.out.println(quiz.getQuestion());
            for (int i = 0; i < quiz.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + quiz.getOptions()[i]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                }
            }, quiz.getTimeLimit() * 1000);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer (1-" + quiz.getOptions().length + "): ");
            int answer = scanner.nextInt() - 1;

            if (answer == quiz.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + quiz.getOptions()[quiz.getCorrectAnswer()]);
            }

            timer.cancel();
        }

        System.out.println("Quiz complete! Your final score is " + score + " out of " + quizzes.length);
    }
}