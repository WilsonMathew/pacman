import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PacMan extends GameObject {

	// PacMan properties
	private int x = 100;
	private int y = 100;
	private int width = 50;
	private int height = 50;
	private int sAngle = 45;
	private int  fill = 270;
	private int DIAMETER = 75;

	// game ob. to keep in the screen
	private Game game;
	
	// incrementors to move through the screen
	private int xa = 0;
	private int ya = 0;
	
	// mouth movement
	int mM = 1;

    public PacMan(Game game) {
    	this.game = game;		
		/*	//eye
		g.setColor(Color.black);
		g.fillOval(x+325,y+225,5,5);
		*/
    }
    
    // bullshit 
    
    int limit = 0 , FILL = 270, limit2 = 0;
    
    //@Override
	public void update() {	
		if (sAngle > limit  && fill <= FILL)
		mM = 1;
		else if(sAngle <= limit2)
			mM = -1;
		
		sAngle -= mM;	
		fill += 2*mM;
		
		x += xa;
		y += ya;
	}
	
	//@Override
	public void render(Graphics g) {
		// pacman
		g.setColor(Color.yellow);
		g.fillArc(300+x, 200+y, width, height, sAngle, fill);
	}
	
	public void keyReleased(KeyEvent e ) {
		xa = 0;
		ya = 0;
	}
	
	boolean up = true,down = true,left = true,right = true;
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
			if (left) {
				sAngle = 225;
				limit = 225;
				fill = 270;
				limit2 = 180;
			}

			right = true;
			up = true;
			left = false;
			down = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//countMoves = 0;
					
			xa = 1;
			if (right) {
			sAngle = 45;
			limit = 0;
			fill = 270;
			limit2 = 0;
			}

			right = false;
			up = true;
			left = true;
			down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			ya = -1;
			if (up) {
			sAngle = 135;
			limit = 135;
			fill = 270;
			limit2 = 90;
			}

			right = true;
			up = false;
			left = true;
			down = true;
			
			//countMoves++;
			
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			ya = 1;
			if (down) {
				sAngle = 315;
				limit = 315;
				fill = 270;
				limit2 = 270;
			}

			right = true;
			up = true;
			left = true;
			down = false;
		}
	}
}
