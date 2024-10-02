import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class QuizeGenerator {
    private static HashMap<String, Quize> quizzes = new HashMap<String, Quize>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAvailable Commands: create_quiz, add_question, take_quiz, quit");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "create_quiz":
                    createQuiz(scanner);
                    break;
                case "add_question":
                    addQuestion(scanner);
                    break;
                case "take_quiz":
                    takeQuiz(scanner);
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }

    // Create a new quiz
    public static void createQuiz(Scanner scanner) {
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();

        if (quizzes.containsKey(quizName)) {
            System.out.println("Quiz already exists.");
        } else {
            quizzes.put(quizName, new Quize(quizName));
            System.out.println("Quiz '" + quizName + "' created.");
        }
    }

    // Add a question to an existing quiz
    public static void addQuestion(Scanner scanner) {
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();

        if (!quizzes.containsKey(quizName)) {
            System.out.println("Quiz does not exist.");
            return;
        }

        Quize quiz = quizzes.get(quizName);
        System.out.print("Enter question: ");
        String questionText = scanner.nextLine();

        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.print("Option " + (i + 1) + ": ");
            options.add(scanner.nextLine());
        }

        System.out.print("Enter correct answer: ");
        String correctAnswer = scanner.nextLine();

        Question question = new Question(questionText, options, correctAnswer);
        quiz.addQuestion(question);
        System.out.println("Question added to quiz '" + quizName + "'.");
    }

    // Take a quiz
    public static void takeQuiz(Scanner scanner) {
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();

        if (!quizzes.containsKey(quizName)) {
            System.out.println("Quiz not found.");
            return;
        }

        Quize quiz = quizzes.get(quizName);
        int score = 0;
        int totalQuestions = quiz.getQuestions().size();

        for (Question question : quiz.getQuestions()) {
            System.out.println("\n" + question.getQuestionText());
            ArrayList<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + totalQuestions);
    }
}
