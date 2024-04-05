import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class App extends JFrame{

    // class properties
    private int winCount = 0;
    private int loseCount = 0;
    private int drawCount = 0;
    private JLabel winLabel;
    private JLabel loseLabel;
    private JLabel drawLabel;
    private JLabel resultLabel;
    private JLabel cpuLabel;

    // constructor mathod 
    public App(){
        // App appearance
        setTitle("Rock >?< Paper >?< Scissor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(700, 70);
    
        // declare buttons (rock, paper, scissor)
        JButton rock = new JButton("Rock");
        JButton paper = new JButton("Paper");
        JButton scissor = new JButton("Scissor");
        
        // score board
        resultLabel = new JLabel("Begin");
        cpuLabel = new JLabel();
        winLabel = new JLabel();
        loseLabel = new JLabel();
        drawLabel = new JLabel();

	    add(rock);
        add(paper);
        add(scissor);
        add(resultLabel);
        add(cpuLabel);
        add(winLabel);
        add(loseLabel);
        add(drawLabel);

        // adding listener to buttons
        rock.addActionListener(new getUserChoice("Rock"));
        paper.addActionListener(new getUserChoice("Paper"));
        scissor.addActionListener(new getUserChoice("Scissor"));

    }

    // when user choose rock/paper/scissor
    private class getUserChoice implements ActionListener {
        private final String userMove;

        // method: get set user choice as a constant
        public getUserChoice(String move) {
            this.userMove = move;
        }

        // event listener to calc & display results
        @Override
        public void actionPerformed(ActionEvent e) {
            // method to get choices and check for result
            String cpuMove = cpuChoice();
            String result = checkResult(userMove, cpuMove);
            // output result
            resultLabel.setText(result);
            cpuLabel.setText("Computer chose: " + cpuMove + ". ");
            winLabel.setText("Wins: " + winCount);
            loseLabel.setText("Losses: " + loseCount);
            drawLabel.setText("Draws: " + drawCount);
        }
    }

    // method: randomize cpu choice
    private String cpuChoice() {
        String[] moves = {"Rock", "Paper", "Scissor"};
        int index = new Random().nextInt(moves.length);
        return moves[index];
    }

    // method: checks result
    private String checkResult(String userMove, String cpuMove) {
        // check for draw
        if (userMove.equals(cpuMove)) {
            drawCount++;
            return "It's a draw!";
        }
        // user winning possiblities
        if ((userMove.equals("Rock") && cpuMove.equals("Scissor")) ||
            (userMove.equals("Paper") && cpuMove.equals("Rock")) ||
            (userMove.equals("Scissor") && cpuMove.equals("Paper"))) {
            winCount++;
            return "You win!";
        } 
        // cpu wins
        else {
            loseCount++;
            return "You lose!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
