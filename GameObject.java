import java.awt.*;

public class GameObject {

	Rectangle boundsRectangle;
	Point point;
	
	public GameObject() {
		point = new Point(0,0);	
	}
	
	public GameObject(int x, int y) {
		point = new Point(x,y);	
		boundsRectangle = new Rectangle(x,y,50,	50);
	}
	
	public GameObject(int x, int y, int width, int height) {
		boundsRectangle = new Rectangle(x,y,width,height);
	}

	public void update() {}
	public void update(float gameTime) {}
	public void render(Graphics g) {}
	
	public boolean collisionCheck(Rectangle collisionCheck) {
		return boundsRectangle.intersects(collisionCheck);
	}
}
