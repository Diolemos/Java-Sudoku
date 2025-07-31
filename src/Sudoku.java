import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class Sudoku {
    int boardWidth = 600;
    int boardHeight= 650;

    JFrame frame = new JFrame("Sudoku");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    Sudoku(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); 

        textLabel.setFont(new Font("Arial", Font.BOLD,30));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText(("Sudoku: 0"));

        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        frame.revalidate();
        frame.repaint();
        
    }
}
