import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;

        addQuestions();
    }

    private void addQuestions() {

        questions.add(new Question(
                "Which language is used for Android development?",
                new String[]{"Python", "Java", "HTML", "CSS"},
                1
        ));

        questions.add(new Question(
                "Which keyword is used to create a class in Java?",
                new String[]{"class", "Class", "new", "object"},
                0
        ));

        questions.add(new Question(
                "Which method is the starting point of a Java program?",
                new String[]{"start()", "run()", "main()", "begin()"},
                2
        ));

        questions.add(new Question(
                "Which data type is used to store whole numbers?",
                new String[]{"double", "String", "int", "boolean"},
                2
        ));

        questions.add(new Question(
                "Which symbol is used to end a statement in Java?",
                new String[]{".", ":", ";", ","},
                2
        ));

        questions.add(new Question(
                "Which keyword is used to inherit a class?",
                new String[]{"implements", "extends", "inherits", "super"},
                1
        ));

        questions.add(new Question(
                "Which collection stores elements in a dynamic array?",
                new String[]{"ArrayList", "HashMap", "TreeSet", "Queue"},
                0
        ));

        questions.add(new Question(
                "Which keyword is used to create an object?",
                new String[]{"create", "object", "new", "this"},
                2
        ));

        questions.add(new Question(
                "Which of these is not a primitive data type?",
                new String[]{"int", "boolean", "String", "double"},
                2
        ));

        questions.add(new Question(
                "What does JVM stand for?",
                new String[]{
                        "Java Variable Machine",
                        "Java Virtual Machine",
                        "Java Visual Machine",
                        "Java Verified Machine"
                },
                1
        ));
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void checkAnswer(int selectedAnswer, int questionNumber) {

        if (selectedAnswer == questions.get(questionNumber).getCorrectAnswer()) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }
}
