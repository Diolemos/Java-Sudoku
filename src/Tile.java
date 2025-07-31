
import javax.swing.JButton;

public class Tile extends JButton {
    int rowNumber;
    int columnNumber;

    Tile(int rowNumber, int columnNumber){
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

}
