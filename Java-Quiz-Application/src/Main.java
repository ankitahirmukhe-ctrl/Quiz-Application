import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Main extends JFrame {

    private Quiz quiz;
    private List<Question> questions;

    private int currentQuestion = 0;
    private int timeLeft = 10;

    private JLabel questionLabel;
    private JLabel questionNumberLabel;
    private JLabel timerLabel;

    private JRadioButton[] options;
    private ButtonGroup optionGroup;

    private JButton nextButton;

    private Timer timer;

    public Main() {

        quiz = new Quiz();
        questions = quiz.getQuestions();

        setTitle("Java Quiz Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();

        showQuestion();

        setVisible(true);
    }

    private void createGUI() {

        setLayout(new BorderLayout(10, 10));

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());

        questionNumberLabel = new JLabel();
        questionNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timerLabel.setForeground(Color.RED);

        topPanel.add(questionNumberLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        centerPanel.add(questionLabel);
        centerPanel.add(Box.createVerticalStrut(20));

        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {

            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 16));
            options[i].setAlignmentX(Component.LEFT_ALIGNMENT);

            optionGroup.add(options[i]);
            centerPanel.add(options[i]);

            centerPanel.add(Box.createVerticalStrut(10));
        }

        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();

        nextButton = new JButton("Next");

        nextButton.setFont(new Font("Arial", Font.BOLD, 14));

        nextButton.addActionListener(e -> nextQuestion());

        bottomPanel.add(nextButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void showQuestion() {

        if (currentQuestion >= questions.size()) {
            showResult();
            return;
        }

        Question question = questions.get(currentQuestion);

        questionNumberLabel.setText(
                "Question " + (currentQuestion + 1) + " / " + questions.size()
        );

        questionLabel.setText(question.getQuestion());

        String[] questionOptions = question.getOptions();

        for (int i = 0; i < 4; i++) {
            options[i].setText(questionOptions[i]);
            options[i].setSelected(false);
        }

        optionGroup.clearSelection();

        timeLeft = 10;

        timerLabel.setText("Time: " + timeLeft);

        startTimer();
    }

    private void startTimer() {

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(1000, e -> {

            timeLeft--;

            timerLabel.setText("Time: " + timeLeft);

            if (timeLeft <= 0) {

                timer.stop();

                nextQuestion();
            }
        });

        timer.start();
    }

    private void nextQuestion() {

        if (timer != null) {
            timer.stop();
        }

        int selectedAnswer = -1;

        for (int i = 0; i < 4; i++) {

            if (options[i].isSelected()) {
                selectedAnswer = i;
                break;
            }
        }

        if (selectedAnswer != -1) {

            quiz.checkAnswer(
                    selectedAnswer,
                    currentQuestion
            );
        }

        currentQuestion++;

        if (currentQuestion < questions.size()) {

            showQuestion();

        } else {

            showResult();
        }
    }

    private void showResult() {

        if (timer != null) {
            timer.stop();
        }

        int score = quiz.getScore();
        int total = questions.size();

        String message;

        if (score >= 8) {

            message = "Excellent!";

        } else if (score >= 5) {

            message = "Good Job!";

        } else {

            message = "Keep Practicing!";
        }

        int result = JOptionPane.showOptionDialog(
                this,
                "Your Score: " + score + " / " + total
                        + "\n\n" + message
                        + "\n\nDo you want to try again?",
                "Quiz Result",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Restart", "Exit"},
                "Restart"
        );

        if (result == JOptionPane.YES_OPTION) {

            restartQuiz();

        } else {

            System.exit(0);
        }
    }

    private void restartQuiz() {

        currentQuestion = 0;

        quiz.resetScore();

        showQuestion();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
