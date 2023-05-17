import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

// The "View" in MVC design pattern.
@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private BoardPanel hangedMan, word;
    private JLabel prompt, message;
    private JTextField guess;
    private JPanel box, bottom;
    public GameFrame() {
		this.setTitle("Hangman");
		box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS) ); 
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS) ); 
        hangedMan = new BoardPanel(new HangedMan(Face.ONE), 1, 1, 0);
        word = new BoardPanel(new Letter(Face.A), 14, 1, 0);
        prompt = new JLabel("  Letter? ");
        prompt.setSize(new Dimension(70, 30));
		prompt.setFont(new Font("Dialog", Font.BOLD, 20));
        guess = new JTextField();
        guess.setPreferredSize(new Dimension(30, 30));
		guess.setFont(new Font("Dialog", Font.BOLD, 20));
        //header = new JLabel("  Guessed: ");
        //header.setSize(new Dimension(70, 30));
		//header.setFont(new Font("Dialog", Font.BOLD, 20));
        message = new JLabel("");
        message.setSize(new Dimension(200, 30));
		message.setFont(new Font("Dialog", Font.BOLD, 20));
		setSize((int)word.getDim().getWidth(), (int)hangedMan.getDim().getHeight() + (int)word.getDim().getHeight() + 30);
        box.add(hangedMan);
        box.add(word);
        bottom.add(prompt);
        bottom.add(guess);
        //bottom.add(header);
        bottom.add(message);
        box.add(bottom);
        this.add(box);
        this.pack();
        this.setVisible(true);
		guess.addActionListener(new Play(this));
		guess.requestFocusInWindow();  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }	

    // GameFrame methods, to assist Play methods interacting with GameFrame object.
    public BoardPanel getHangedMan() { return hangedMan; }
    public BoardPanel getWord() { return word; }
    public JLabel getMessageLabel() { return message; }
    public JTextField getGuessField() { return guess; }

    
}
