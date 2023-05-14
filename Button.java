import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Button extends JButton {
    private Piece piece;

    public Button() {
        this.setBorderPainted(false);
        this.setBorderPainted(false);
    }

    public Button(Piece p) {
        piece = p;
		ImageIcon icon = new ImageIcon(piece.getIcon() );
        this.setIcon(icon);
    }

    public void setPiece(Piece p) {
        piece = p;
        ImageIcon icon = new ImageIcon(piece.getIcon() );
        this.setIcon(icon);
    }
}
