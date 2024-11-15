package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import javashooter.controller.BounceController;
import javashooter.controller.BounceController1;
import javashooter.controller.KinematicsController;
import javashooter.gameobjects.RectObject;
import javashooter.playground.Playground;

public class W7Level extends Playground {
	
	//private int objX = 100;     // X-position of the object
	//private int objY = 100;     // Y-position of the object
	//private int objWidth = 80;  // Width of the object
	//private int objHeight = 10; // Height of the object
	//private int objSpeedX = 10; // Velocity of the object in the X-direction
	//private int objSpeedY = 10; // Velocity of the object in the Y-direction
	
	//W7Level level = new W7Level();
	//level.prepareLevel("W7Level");
	

   /* @Override
    public void updateObjects() {
        // Update the position of the object based on the velocity
        objX += objSpeedX;
        objY += objSpeedY;

       
    }*/

   /* @Override
    public void redraw(Graphics2D g) {
        // Set the color of the object to red
        g.setColor(Color.BLUE);

        // Draw the rectangular object at the current position
        g.fillRect(objX, objY, objWidth, objHeight);
    }*/

	@Override
	public void prepareLevel(String level) {
	    System.out.println("Hello world!");

	    RectObject rectObject = new RectObject("rectObject", this, 300, 300, 150, 50, 30, 30, Color.BLUE);
	    BounceController1 bounceController1 = new BounceController1();
	    rectObject.setController(bounceController1);
	    addObject(rectObject);

	  /*  RectObject rectObject1 = new RectObject("rectObject1", this, 200, 200, 150, 50, -150, -50, Color.GREEN);
	    BounceController1 bounceController1 = new BounceController1();
	    rectObject1.setController(bounceController1);
	    addObject(rectObject1); */
	    
	    RectObject rectObject1 = new RectObject("rectObject1", this, 200, 200, -150, -50, 30, 30, Color.GREEN);
	    addObject(rectObject1);
	    rectObject1.setController(new BounceController());
	}

    

   protected boolean doneLevel = false;

    
    
  @Override
  public int preferredSizeX() {
    return 700;
  }

  @Override
  public int preferredSizeY() {
    return 700;
  }
  
  @Override
  public String getName() {
    return "My Game's Level 1";
  }
  


  @Override
  public void applyGameLogic() {

  }

  @Override
  public boolean gameOver() {
    return false; 
  }


  @Override
  public boolean resetRequested() {
    return false; 
  }

  @Override
  public void redrawLevel(Graphics2D g2) {
    
  }

@Override
public boolean levelFinished() {
	// TODO Auto-generated method stub
	return false;
}
  
  
}
