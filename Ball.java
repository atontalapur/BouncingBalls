


import mickel.anim.Sprite;
import mickel.anim.Stage;
import mickel.audio.AudioFile;
import mickel.image.ImageFile;
import mickel.io.Key;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;




/** Represents a Ball that dynamically bounces around the interior
 *  of a rectangular Stage.
 */
public class Ball extends Sprite 
{
	// FIELDS
	
	// ------------------------------------------------------------
	private int myPosX;		// X-coordinate of this Ball
	private int myPosY;		// Y-coordinate of this Ball

	private int myDirX;		// Horizontal speed of this Ball
	private int myDirY;		// Vertical speed of this Ball

	private int mySize;		// Diameter of this Ball
	private Color myColor;	// Color of this Ball


	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs a large, red Ball that is initially located in
	 *  the upper left corner of the screen.
	 *
	 *     algorithm: Assign mySize a value of 100.
	 *                Assign myPosX and myPosY a value of
	 *                  one half mySize plus one.
	 *                Assign myDirX a value of 2.
	 *                Assign myDirY a value of 1.
	 *                Assign myColor a Color value of RED.
	 */
	public Ball() {
		mySize=50;					// Diameter of this Ball
		myPosX=(mySize/2)+1;		// X-coordinate of this Ball
		myPosY=(mySize/2)+1;		// Y-coordinate of this Ball

		myDirX =2;		// Horizontal speed of this Ball
		myDirY=1;		// Vertical speed of this Ball

		myColor=Color.red;
	}

	/** Constructs a small, green Ball that is initially centered
	 *  on a specified region of the screen.
	 *
	 *  precondition: width >= 0, height >= 0
	 *     algorithm: Assign mySize a value of 25.
	 *                Assign myPosX a value of half of width
	 *                Assign myPosY a value of half of height
	 *                Assign myDirX a value of -2.
	 *                Assign myDirY a value of 5.
	 *                Assign myColor a Color value of GREEN.
	 *
	 * @param width		Width of the stage
	 * @param height	Height of the stage
	 */
	public Ball(double width, double height) {
		
		mySize=25;
		myPosX=(int)width;
		myPosY=(int)height;
		myDirX=-2;
		myDirY=5;
		myColor=Color.blue;
		
	}

	/** Constructs a Ball that initially has the specified
	 *  location, size, and color.
	 *
	 *     algorithm: Assign mySize a value of size.
	 *                Assign myPosX the value of x.
	 *                Assign myPosY the value of y.
	 *                Assign myDirX the value of 3.
	 *                Assign myDirY the value of 3.
	 *                Assign myColor the value of c.
	 *
	 * @param x		The x-coordinate of this Ball's location
	 * @param y		The y-coordinate of this Ball's location
	 * @param size	The diameter of this Ball
	 * @param c		The Color of this Ball
	 */
	public Ball(int x, int y, int size, Color c) {
		mySize=size;
		myPosX=x;
		myPosY=y;
		
		myDirX=3;
		myDirY=3;
		
		myColor=c;
				
	}
	
	// METHODS
	// ------------------------------------------------------------
	/** Performs one frame of movement for this Ball object.
	 *
	 *  precondition:
	 * postcondition: The location of this Ball will be incremented
	 *                by one frame in its current direction of
	 *                movement. If the resulting location lies
	 *                beyond the boundaries of the Stage, this Ball's
	 *                direction will be adjusted accordingly to
	 *                reflect a "bounce".
	 *     algorithm: Increment myPosX by myDirX.
	 *                Increment myPosY by myDirY.
	 *                Declare an int variable w and initialize it
	 *                  with the value of the width of this Ball's
	 *                  Stage.
	 *                Declare an int variable h and initialize it
	 *                  with the value of the height of this Ball's
	 *                  Stage.
	 *                If the left edge of this Ball is less than 0
	 *                  and this Ball is moving left, negate the
	 *                  value of myDirX.
	 *                If the right edge of this Ball is greater than
	 *                  w and this Ball is moving right, negate the
	 *                  value of myDirX.
	 *                If the top edge of this Ball is less than 0
	 *                  and this Ball is moving up, negate the
	 *                  value of myDirY.
	 *                If the bottom edge of this Ball is greater than
	 *                  h and this Ball is moving down, negate the
	 *                  value of myDirY.
	 */
	public void act()
	{
		myPosX+=myDirX;
		myPosY+=myDirY;
		int w = this.getStage().getWidth();
		int h = this.getStage().getHeight();
		
		//In the x Direction
		if(myPosX<0 && myDirX<0) {
			myDirX*=-1;
		}
		if(myPosX>(w-mySize) && myDirX>0) {
			myDirX*=-1;
		}
		
		//In the Y Direction
		if(myPosY<0 && myDirY<0) {
			myDirY*=-1;
		}
		if(myPosY>(h-mySize) && myDirY>0) {
			myDirY*=-1;
		}
	}


	/** Draws a representation of the current state of this Ball
	 *  onto the graphics canvas, g.
	 *
	 *  precondition: g is the "canvas" of the Stage
	 * postcondition: Draws a representation of the current state
	 *                of this Ball onto the graphics canvas, g.
	 *     algorithm: Set the Color of g to be myColor.
	 *                Paint a filled oval onto g that is located at
	 *                  (myPosX, myPosY) with a width and height of
	 *                  mySize.
	 *
	 * @param g	The "canvas" on which this Ball is to be drawn.
	 * 
	 */
	public void draw(Graphics2D g)
	{
		g.setColor(myColor);
		g.fillOval(myPosX, myPosY, mySize, mySize);
	}


	/** Gets the boundaries of this Sprite.
	 *
	 * postcondition: Returns a Shape object that corresponds to the
	 *                characteristics used in the draw() method.
	 *     algorithm: Return a new Ellipse2D.Double object that uses
	 *                  myPosX and myPosY for the x and y parameters
	 *                  and mySize for the width and height parameters.
	 *
	 * @return   The Shape specifying the boundaries of this Sprite
	 */
	public Shape getShape()
	{
		
		return new Ellipse2D.Double(myPosX, myPosY, mySize, mySize);	
	}


	/* The following methods are event-handling methods that respond
	 * to keyboard events and mouse events. You may wish to experiment
	 * with these to add additional "user controls" for Ball objects.
	 */
	public void keyPressed (Key k) { 
		if(k==Key.RIGHT ) {
			myDirX=5;
			myDirY=0;
		}
		if(k==Key.LEFT) {
			myDirX=-5;
			myDirY=0;
			
		}
		if(k==Key.DOWN ) {
			myDirY=5;
			myDirX=0;
		}
		if(k==Key.UP) {
			myDirY=-5;
			myDirX=0;
		}
		
		if(k==Key.ENTER) {
			myDirX+=10;
			myDirY+=10;
		}
		
		if(k==Key.L) {
			myDirX-=3;
			myDirY-=3;
		}
		if(k==Key.I) {
			myDirX+=3;
			myDirY+=3;
		}
		
	}
	public void keyReleased(Key k) { 
		if(k==Key.ONE) {
			getStage().setBackground(new ImageFile("background.jpeg"));
		}
		if(k==Key.TWO) {
			getStage().setBackground(new ImageFile("hi.gif"));
		}
		if(k==Key.THREE) {
			getStage().setBackground(new ImageFile("Globe.jpeg"));
		}
		if(k==Key.FOUR) {
			getStage().setBackground(new ImageFile("adsf.gif"));
		}
		
	}
	public void keyTyped   (Key k) { 
		
		
		if(k==Key.B) {
			mySize+=10;
		}
		if(k==Key.S) {
			 mySize-=10;
		}
	}

	public void mousePressed (int x, int y) {
		
	}
	public void mouseReleased(int x, int y, int z) { 
		
	}
	public void mouseClicked (int x, int y) {
		
		Ball ballFollow = new Ball(x,y);
		getStage().add(ballFollow);
	}
	
	public void mouseMoved(int x, int y) { 
		if(mySize>150) {
			mySize=10;
		}
	}
	
	public void mouseDragged (int x, int y) {  //Height of the stage is 800 and the width is 600
		int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B = (int)(Math.random()*256);
		myColor = new Color(R,G,B);
	}
	
	public void mouseEntered (int x, int y) { 
		getStage().start();
	}
	
	public void mouseExited  (int x, int y) { 
		getStage().stop();
	}
}
