import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;


@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
	private Dimension dim;
	private ImageIcon icon = null;
	private Button[][] buttons;

	// Constructor, sets up panel of buttons sized from piece image dimensions, sets up buttons array representing pieces.
	public BoardPanel(Piece sample, int widthInPieces, int heightInPieces, int interiorBorderInPixels) {
		dim = new Dimension(
			(int)(sample.getDim().getWidth() )*widthInPieces + (widthInPieces - 1)*interiorBorderInPixels, 
			(int)(sample.getDim().getHeight() )*heightInPieces + (heightInPieces - 1)*interiorBorderInPixels
		);
		buttons = new Button[heightInPieces][widthInPieces];
		this.setBackground(Color.white);
		this.setSize((int)dim.getWidth(), (int)dim.getHeight() );
		this.setLayout(new GridLayout(heightInPieces, widthInPieces, interiorBorderInPixels, interiorBorderInPixels) );
		for(int row = 0; row < heightInPieces; row++) {
			for(int col = 0; col < widthInPieces; col++) {
				buttons[row][col] = new Button();  
				buttons[row][col].setContentAreaFilled(false);
				buttons[row][col].setPreferredSize(sample.getDim());
				this.add(buttons[row][col]);
			}
		}
	}

	public Dimension getDim() { return dim; }

	public Button getButton(int x, int y) { return buttons[y][x]; }
}
