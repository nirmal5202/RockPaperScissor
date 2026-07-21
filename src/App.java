/**
 * Author: github.com/nirmal5202 - Nirmal Patel
 * Using Swing/JFC to make this >>> Rock <?> Paper <?> Scissor <<< game for you. Have fun :)
 * Usage: README.md
 */
 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class App extends JFrame {

    private JLabel cpuPickLabel;
    private JLabel resultLabel;
    private JLabel userScoreLabel;
    private JLabel cpuScoreLabel;

    private int userScore = 0;
    private int cpuScore = 0;

    public App() {
        setTitle("Rock Paper Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Rock Paper Scissors", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");
        JButton resetButton = new JButton("Reset Game");

        rockButton.addActionListener(e -> playRound("Rock"));
        paperButton.addActionListener(e -> playRound("Paper"));
        scissorsButton.addActionListener(e -> playRound("Scissors"));
        resetButton.addActionListener(e -> resetGame());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        rockButton.setFont(buttonFont);
        paperButton.setFont(buttonFont);
        scissorsButton.setFont(buttonFont);

        rockButton.setBackground(new Color(210, 180, 140));
        paperButton.setBackground(new Color(255, 255, 180));
        scissorsButton.setBackground(new Color(180, 238, 180));

        cpuPickLabel = new JLabel("CPU picks: ?");
        resultLabel = new JLabel("Result: Start the game");
        userScoreLabel = new JLabel("You: 0");
        cpuScoreLabel = new JLabel("CPU: 0");

        cpuPickLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        userScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cpuScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        infoPanel.add(cpuPickLabel);
        infoPanel.add(resultLabel);

        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        scorePanel.add(userScoreLabel);
        scorePanel.add(cpuScoreLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(scorePanel, BorderLayout.NORTH);
        bottomPanel.add(resetButton, BorderLayout.SOUTH);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String getCpuChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    private void playRound(String userChoice) {
        String cpuChoice = getCpuChoice();
        cpuPickLabel.setText("CPU picks: " + cpuChoice);

        if (userChoice.equals(cpuChoice)) {
            resultLabel.setText("Result: Draw");
        } else if (
            (userChoice.equals("Rock") && cpuChoice.equals("Scissors")) ||
            (userChoice.equals("Paper") && cpuChoice.equals("Rock")) ||
            (userChoice.equals("Scissors") && cpuChoice.equals("Paper"))
        ) {
            userScore++;
            resultLabel.setText("Result: You win");
        } else {
            cpuScore++;
            resultLabel.setText("Result: CPU wins");
        }

        userScoreLabel.setText("You: " + userScore);
        cpuScoreLabel.setText("CPU: " + cpuScore);
    }

    private void resetGame() {
        userScore = 0;
        cpuScore = 0;
        cpuPickLabel.setText("CPU picks: ?");
        resultLabel.setText("Result: Start the game");
        userScoreLabel.setText("You: 0");
        cpuScoreLabel.setText("CPU: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}