


import mickel.anim.Qix;
import mickel.anim.Stage;
import mickel.audio.AudioFile;
import mickel.image.ImageFile;

import java.awt.Color;

import java.util.Scanner;


/** The primary GUI window of the BouncingBalls application.
 */
public class BouncingBallsGUI
{
	// FIELDS
	// ------------------------------------------------------------
	private Stage myStage;			// The base window for the app.
	
	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs and initializes each of the components for this
	 *  GUI window.
	 *
	 *  postcondition: The primary GUI window is initialized and
	 *                   its animation cycle is started.
	 *      algorithm: Initialize a new Stage to have a title of
	 *                   "Bouncing Balls", a width of 400, and a
	 *                   height of 400.
	 *                 Set the background of myStage to be a new
	 *                   Color of your choice, preferably with a
	 *                   low alpha value. For example, translucent
	 *                   orange would be new Color(200,100,0,66)
	 *                 Optionally, set the background of myStage
	 *                   to be an image (GIF, JPEG, or PNG)
	 *                   of your choice. For example, the Duke.png
	 *                   file has been provided for you. Construct
	 *                   it using new ImageFile("Duke.png")
	 *                 Set the location of myStage such that it
	 *                   will be centered on a 1280 x 1024 screen.
	 *                   HINT: Use a mathematical expression to
	 *                   automatically calculate the appropriate
	 *                   x and y coordinate the upper left corner
	 *                   of myStage.
	 *                 Invoke this object's addSprites() method.
	 *                 Tell myStage to open its window.
	 *                 Tell myStage to start its animation cycle.
	 */
	public BouncingBallsGUI()
	{
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("How many balls would you like to have? The number should be above three.");
		
		int numBalls = myObj.nextInt();  		
	    System.out.println("Number of balls in the stage are: " + numBalls);  
	    
	    myStage = new Stage("Bouncing Balls", 800, 600);
		
		myStage.setBackground(new Color(37,149,48,5));
		myStage.setLocation(0, 0);
		
		this.addDefaultSprites(numBalls);
		
		myStage.openWindow();
		
		pickSong();
	}
	
	private void pickSong() {
		
		AudioFile[] music = new AudioFile[6];
		
		int r = ((int) Math.abs(Math.random()*6+1));
		//System.out.println("====" + r + "====");
		
		AudioFile m1 = new AudioFile("Slow-Drift-Beat.mp3");
		AudioFile m2 = new AudioFile("music.mp3");
		AudioFile m3 = new AudioFile("Brick-Wall-Brass.mp3");
		AudioFile m4 = new AudioFile("Let_s-Roll-Strings.mp3");
		AudioFile m5 = new AudioFile("Yearning-Synth-Guitar.mp3");
		//AudioFile m6 = new AudioFile("music2.wav");
		
		music[0] = m1;
		music[1] = m2;
		music[2] = m3;
		music[3] = m4;
		music[4] = m5;
		//music[5] = m6;
		
		
		if(r==0) {//m1
			music[0].play();
			music[0].loop();
		}
		
		else if(r==1) {//m2
			music[1].play();
			music[1].loop();
		}
		
		else if(r==2){//m3
			music[2].play();
			music[2].loop();
		}
		else if(r==3) {//m4
			music[3].play();
			music[3].loop();
		}
		
		else if(r==4) {   //m5
			music[4].play();
			music[4].loop();
		}
		
		
		
		System.out.println("The m"+r+" is playing");
		
	}
	
	// METHODS
	// ------------------------------------------------------------
	/** Constructs and adds multiple Ball objects to the Stage.
	 *
	 *  postcondition: Constructs and adds one Ball object for each
	 *                   of the 3 Ball constructors to the Stage.
	 *      algorithm: Declare a Ball variable called b1 and assign
	 *                   to it a new Ball object with no parameters.
	 *                 Declare a Ball variable called b2 and assign
	 *                   to it a new Ball object with 2 specific
	 *                   parameters (width and height of myStage).
	 *                 Declare a Ball variable called b3 and assign
	 *                   to it a new Ball object with 4 specific
	 *                   parameters (x-location, y-location, size,
	 *                   color) of your choice and add it to myStage.
	 *                 Add b1 to myStage.
	 *                 Add b2 to myStage.
	 *                 Add b3 to myStage.
	 */
	
	private void addDefaultSprites(int num){

		Ball b1 = new Ball();
		myStage.add(b1);								//Adding Ball1. This is added by the default constructor.
		
		Ball b2 = new Ball(myStage.getWidth(), myStage.getHeight());
		myStage.add(b2);								//Adding Ball2. This is added using the second constructor. 
		
		Ball b3 = new Ball(myStage.getWidth()/2, myStage.getHeight()/2, 23, Color.orange);
		myStage.add(b3);	
		
		
		
		
		addSpriteUserWill(num);
		
		}
	
	private void addSpriteUserWill(int requestNum){
		System.out.println("Stage started");
		
		for(int i =0; i<(requestNum-3); i++) {
			Ball b4 = new Ball(myStage.getWidth()+5, myStage.getHeight()+10, 40 + 10*i, Color.BLUE);
			myStage.add(b4);							//Adding the balls requested 
	}
	}
}
