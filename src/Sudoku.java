import java.awt.BorderLayout;
import java.awt.Color;
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
    // JLabel textLabel = new JLabel();
    // JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton resetButton = new JButton("Reset");
    JButton newGameButton = new JButton("New Game");

    Tile[][] tiles = new Tile[9][9];
    Sudoku(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); 

        // textLabel.setFont(new Font("Arial", Font.BOLD,30));
        // textLabel.setHorizontalAlignment(JLabel.CENTER);
        // textLabel.setText(("Sudoku: 0"));

        // textPanel.add(textLabel);
        // frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(9,9));
        loadGame(puzzle, solution);
        frame.add(boardPanel,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

resetButton.addActionListener(e -> {
    int option = JOptionPane.showConfirmDialog(frame, "Reset this puzzle?", "Confirm Reset", JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
        loadGame(puzzle, solution); // Reload the same puzzle
    }
});

newGameButton.addActionListener(e -> {
    int option = JOptionPane.showConfirmDialog(frame, "Start a new game?", "Confirm New Game", JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
        // TODO: Replace with random puzzle logic later
        loadGame(puzzle, solution); // Reuse current for now
    }
});

buttonPanel.add(resetButton);
buttonPanel.add(newGameButton);
frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        
        
    }
    
void loadGame(String[] puzzle, String[] solution) {
    boardPanel.removeAll(); // Clear old tiles

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            Tile tile = new Tile(row, col);
            tiles[row][col] = tile;
            char ch = puzzle[row].charAt(col);

            if (ch != '-') {
                tile.setText(String.valueOf(ch));
                tile.setEditable(false);
                tile.setBackground(Color.LIGHT_GRAY);
                tile.setForeground(Color.BLACK);
            } else {
                tile.makeEditable(String.valueOf(solution[row].charAt(col)));
                tile.setText(""); // Blank for user to fill
                tile.setBackground(Color.WHITE);
            }

            int top = (row % 3 == 0) ? 2 : 1;
            int left = (col % 3 == 0) ? 2 : 1;
            int bottom = (row == 8) ? 2 : 1;
            int right = (col == 8) ? 2 : 1;

            tile.setBorder(new MatteBorder(top, left, bottom, right, Color.GRAY));
            boardPanel.add(tile);
        }
    }

    boardPanel.revalidate();
    boardPanel.repaint();
}
}
