import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.LinkedList;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Screen dimenssionsn
	private static int SCREEN_WIDTH = 800;
	private static int SCREEN_HEIGHT = 600;
	
	// Two dimenssional array to draw pills	
	private final int BALL_NUMBERS = 15;
	private Ball ballarray[][] = new Ball[BALL_NUMBERS][BALL_NUMBERS];

	GameObject go;
	
	// PacMan and Ghost Objects.
	private PacMan pacman = new PacMan(this);
	private Ghost ghost = new Ghost(this);
	
	// Game constructor
	public Game() {

		addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) { pacman.keyPressed(e); } 
			public void keyReleased(KeyEvent e) { pacman.keyReleased(e); }
			public void keyTyped(KeyEvent arg0){}
			}
		);

		setFocusable(true);
	}
	
	private void update() {
		ghost.Update();
		pacman.update();
	}
	
	/**
	 * Rendering all the objects to screen
	 * the pacman
	 * the ghost
	 * the pills
	 */
	public void paint(Graphics g) {

		// Two dimensional array for balls
		int rows = ballarray.length-3;
		int columns = ballarray.length;
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		//smooth graphics
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw the balls
		int xBall = 0, yBall = 0;
		for (int i = 0; i < rows ;i++) {
			for (int j = 0; j<columns;j++) {
				xBall += 50;
				ballarray[i][j] = new Ball(xBall,yBall);
				ballarray[i][j].render(g2d);
			}

			yBall += 50;
			xBall = 0;
		}
		
		ghost.render(g2d);
		pacman.render(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("PACMAN");
		Game game = new Game();
		frame.add(game);
		frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Game loop, fix this shit 
		while(true) {
			game.update();
			game.repaint();
			Thread.sleep(10);
		}
	}	
}
