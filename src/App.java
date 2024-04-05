import javax.swing.*;
import java.awt.*;

public class App extends JFrame{

    public App(){
        setTitle("Rock >?< Paper >?< Scissor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new BorderLayout());
        setLayout(new FlowLayout());

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
