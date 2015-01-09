import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Ghost extends GameObject {

	// x and y for the ghost position
	private int x = 0;
	private int y = 0;
	
	// incrementors of the x and y
	private int xa = 1;
	private int ya = 1;
	
	// Diameter of the ghost
	private static final int DIAMETER = 75;
	
	// game object to make the ghost stay in the screen
	private Game game;
	
	public Ghost(Game game) { this.game = game; }
	
	// Updating the ghost
	public void Update() {

		if((x + xa + 200) < 0) xa = 1;
		if(x + xa + 220 > game.getWidth() - DIAMETER) xa = -1;
		if(y + ya + 130 < 0 ) ya = 1;
		if(y + ya + 200 > game.getHeight() - DIAMETER)ya = -1;
		
		x += xa;
		y += ya;
	}
	
	// Drawing the ghost
	public void render(Graphics g) {
		//ghost body
        g.setColor(Color.green );

        //ghost little legs
        g.fillArc(200+x,120+y,100,200,0,180);
	g.fillArc(200+x,180+y,20,60,180,175);
	g.fillArc(220+x,180+y,20,60,180,175);
        g.fillArc(240+x,180+y,20,60,180,175);
        g.fillArc(260+x,180+y,20,60,180,175);
        g.fillArc(280+x,180+y,20,60,180,175);
        
        g.setColor(Color.white);
        g.fillArc(225+x,150+y,20,20,0,360);
        g.fillArc(250+x,150+y,20,20,0,360);

        g.setColor(Color.black);
        g.fillArc(225+x,150+y,10,10,0,360);
        g.fillArc(250+x,150+y,10,10,0,360);
	}
}
