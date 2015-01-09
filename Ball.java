import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class Ball extends GameObject {

	// x and y position of the ball
	private int x = 0;
	private int y = 0;
	private Color color = Color.blue;

	// for the balls (just a test though)
	private boolean visible = true;

	// size of the ball
	private final int DIAMETER = 15;
	
	/**
	 * This constructor sets x and y position and a color.
	 */
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This constructor sets x and y position.
	 */
	public Ball(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	/**
	 * This draws the ball in the screen with a default color of blue
	 * @param g passes a graphic to the drawn in the screen
	 */
	public void render(Graphics2D g) {

		g.setColor(color);
		if (visible) { g.fillOval(x, y, DIAMETER, DIAMETER); }
	}
}
