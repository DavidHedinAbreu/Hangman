import java.awt.image.BufferedImage; 
import java.awt.Dimension;
import java.io.File;  
import java.io.IOException; 
import javax.imageio.ImageIO; 

public abstract class Piece {
	private Face face;
	private Dimension dim;
	private boolean selected;

	// Constructor.
	public Piece(Face face, String url) {  
		BufferedImage img = null;  // Only used to get dimensions.
		this.face = face;
		try {
			img = ImageIO.read(new File(url)); 
		} catch (IOException ex) {
			System.out.println("Can't load image.\n" + ex);
		}
		// May need to add 2x border width in Board class to accommodate border, if needed.
        dim = new Dimension(img.getWidth(), img.getHeight());  
        selected = false;
	}

    public Face getFace() { return face; };
	
	public void setFace(Face which) { face = which; };
	
	public Dimension getDim() { return dim; }
		
	public abstract String getIcon();  // Returns URL, defined in subclass.
	
	public boolean getSelected() { return selected; }
	
	public void setSelected(boolean on) { selected = on; }
}
