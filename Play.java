import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// The "Controller", containing rudimentary "Model" functionality, in MVC design pattern.
@SuppressWarnings("serial")
public class Play implements ActionListener {
	private String word, showWord, guess, guessed, guessThis;
	private ArrayList<String> words;
	private int stage;
	private GameFrame gf;
	private Scanner input;
	private Random rand;
	
	// Constructor. Adds GUI, gets hangman word from file, calls provision method.
	public Play(GameFrame gameFrame) {
		// Adds the GUI, which is passed into Play at the addActionListener call in GameFrame.
		// There must be only ONE GameFrame object that the Play actionlistener works on.
		gf = gameFrame;  
		
		// Get word from file of hangman words.
		words = new ArrayList<String>();
        try
        {
			input = new Scanner(new File("words.txt")).useDelimiter("\n");
            while(input.hasNextLine()) {
				String raw = new String(input.nextLine());
				words.add(raw.toUpperCase());
			}
			input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }		
       		
       	// Ensures the randomly selected words are different every game.
		rand = new Random();
		long seed = System.currentTimeMillis();
		rand.setSeed(seed);
		
		// Sets up the game using the provision method.
		provision();
	}
	
	// ALL STUDENT CODE IN ACTIONPERFORMED METHOD BELOW.
	public void actionPerformed(ActionEvent event) {
		guess = getGuess();
		// Your code here...
		
	}
	
	// DO NOT CHANGE THE METHODS BELOW.

    // In the actionPerformed method, students will call these methods to 
    // interact with the user interface in GameFrame.
    
    // Sets up GUI with the right number of blanks for the concealed word, and a scaffold.
    public void setWord(String showWord) {
        for(int x = 0; x < 14; x++) {  // Provision word boardpanel, set all buttons to blank after last letter in showWord.
			if(x < showWord.length())
				gf.getWord().getButton(x, 0).setPiece(new Letter(Face.EMPTY));
			else
				gf.getWord().getButton(x, 0).setPiece(new Letter(Face.BLANK));
		}
        gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.ONE));  // Provision hangedman boardpanel.
	}
	
	// Retrieve letter from guess field, and reset it to empty.
	public String getGuess() {
		String result = gf.getGuessField().getText().toUpperCase();
		gf.getGuessField().setText("");
		return result;
	}
	
	// Update message field, used for guessed letters and play-again prompt.
	public void resetMessage(String message) {
		gf.getMessageLabel().setText(message);
	}
	
	// Update word shown to user with String showWord.  Hyphen characters are represented as blank squares.
	public void resetWord(String showWord) {
		for(int x = 0; x < showWord.length(); x++) {
			switch(showWord.substring(x, x + 1)) {
				case "A":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.A));
					break;
				case "B":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.B));
					break;
				case "C":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.C));
					break;
				case "D":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.D));
					break;
				case "E":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.E));
					break;
				case "F":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.F));
					break;
				case "G":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.G));
					break;
				case "H":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.H));
					break;
				case "I":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.I));
					break;
				case "J":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.J));
					break;
				case "K":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.K));
					break;
				case "L":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.L));
					break;
				case "M":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.M));
					break;
				case "N":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.N));
					break;
				case "O":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.O));
					break;
				case "P":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.P));
					break;
				case "Q":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.Q));
					break;
				case "R":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.R));
					break;
				case "S":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.S));
					break;
				case "T":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.T));
					break;
				case "U":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.U));
					break;
				case "V":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.V));
					break;
				case "W":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.W));
					break;
				case "X":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.X));
					break;
				case "Y":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.Y));
					break;
				case "Z":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.Z));
					break;
				case "-":
					gf.getWord().getButton(x, 0).setPiece(new Letter(Face.EMPTY));
					break;
			}
		}
	}
	
	// Updates scaffold with the various stages of the demise of the poor guy, using the value of int "stage".
	public void resetMan(int stage) {
		switch(stage) {
			case 2:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.TWO));
				break;
			case 3:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.THREE));
				break;
			case 4:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.FOUR));
				break;
			case 5:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.FIVE));
				break;
			case 6:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.SIX));
				break;
			case 7:
				gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.SEVEN));
		}
	}
	
	// A little celebration when you win.
	public void winner() {
		gf.getHangedMan().getButton(0, 0).setPiece(new HangedMan(Face.WINNER));
	}

	// Shows the word if you lost.
	public void loser() {
		resetWord(guessThis);
	}
	
	// Uses the message field to message the user that they need to choose   
	// whether to play again.
	public void prompt() {
		resetMessage("(Play again? Type Y or N.)");  
	}
	
	// When play begins, sets all the data (the "Model") to starting values, gets a new word, and
	// resets the GUI.
	public void provision() {
		stage = 1;  // Reset game data.
		guessed = "";
		showWord = "";
        
		word = words.get(rand.nextInt(words.size()));  // Get randomly assigned word.
		guessThis = word; 
				
		for(int i = 0; i < word.length(); i++) {  // Provision showWord with the right number of hyphens.
			showWord += "-";
		}
		
		setWord(showWord);		
		resetMessage("Guessed: " + guessed);
		
		System.out.println(word);  // For cheaters.

	}
}
