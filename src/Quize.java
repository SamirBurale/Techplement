import java.util.ArrayList;

public class Quize {
    private String quizName;
    private ArrayList<Question> questions;

    public Quize(String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<>();
    }

    public String getQuizName() {
        return quizName;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}

