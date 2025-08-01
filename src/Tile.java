import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tile extends JTextField {
    int rowNumber;
    int columnNumber;
    boolean isEditable;

    Tile(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;

        setFont(new Font("Arial", Font.BOLD, 20));
        setHorizontalAlignment(JTextField.CENTER);
         setForeground(Color.BLACK);
    }

    void makeEditable(String correctAnswer) {
        this.isEditable = true;

        // Validate when user types and hits Enter or moves focus
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validateInput(correctAnswer);
            }
        });

        this.addActionListener(e -> validateInput(correctAnswer));
    }

    private void validateInput(String correctAnswer) {
        String input = getText().trim();

        if (!input.matches("[1-9]")) {
            setBackground(Color.PINK); // Invalid
        } else if (input.equals(correctAnswer)) {
            setBackground(new Color(144, 238, 144)); // Correct = light green
            setEditable(false); // Optional: lock after correct
        } else {
            setBackground(Color.PINK); // Incorrect
        }
    }
}