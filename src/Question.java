import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(String questionText, ArrayList<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

