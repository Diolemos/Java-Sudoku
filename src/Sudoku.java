import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Sudoku {
    
    int boardWidth = 600;
    int boardHeight= 650;

    String[] puzzle = {
        "--74916-5",
        "2---6-3-9",
        "-----7-1-",
        "-586----4",
        "--3----9-",
        "--62--187",
        "9-4-7---2",
        "67-83----",
        "81--45---"
    };

    String[] solution = {
        "387491625",
        "241568379",
        "569327418",
        "758619234",
        "123784596",
        "496253187",
        "934176852",
        "675832941",
        "812945763"
    };

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

        boardPanel.setLayout(new GridLayout(9,9));
        setupTiles();
        frame.add(boardPanel,BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
        
        
    }
    void setupTiles() {
    for (int row = 0; row < 9; row++) {
        for (int column = 0; column < 9; column++) {
            Tile tile = new Tile(row, column);

            char tileChar = puzzle[row].charAt(column);
            if (tileChar != '-') {
                tile.setText(String.valueOf(tileChar));
                tile.setEnabled(false); // Optional: lock original values
            }

            // Define border thickness for 3x3 grid
            int top = (row % 3 == 0) ? 2 : 1;
            int left = (column % 3 == 0) ? 2 : 1;
            int bottom = (row == 8) ? 2 : 1;
            int right = (column == 8) ? 2 : 1;

            tile.setBorder(new MatteBorder(top, left, bottom, right, Color.BLUE));

            boardPanel.add(tile);
        }
    }
}
}
