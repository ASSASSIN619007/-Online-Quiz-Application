import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Your answer: ");
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer < 1 || userAnswer > options.length) {
                        System.out.println("Please enter a number between 1 and " + options.length);
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (question.isCorrectAnswer(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        String[] options1 = {"Paris", "London", "Berlin", "Madrid"};
        Question q1 = new Question("What is the capital of France?", options1, 0);

        String[] options2 = {"Earth", "Mars", "Jupiter", "Saturn"};
        Question q2 = new Question("Which planet is known as the Red Planet?", options2, 1);

        String[] options3 = {"Mercury", "Venus", "Earth", "Mars"};
        Question q3 = new Question("Which planet is closest to the Sun?", options3, 0);

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);

        quiz.start();
    }
}
