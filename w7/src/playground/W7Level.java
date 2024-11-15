package playground;

import javashooter.playground.Playground;
import javashooter.controller.BounceController;
import javashooter.gameobjects.RectObject;
import java.awt.Graphics2D;
import java.awt.Color;
import javashooter.controller.BounceController1;


public class W7Level extends Playground {

	@Override
	public void prepareLevel(String level) {
		
	    RectObject rectObject = new RectObject("rectObject", this, 300, 300, 150, 50, 30, 30, Color.BLUE); //X, Y (positions), Velocity H, Velocity V, width, height.
	    BounceController1 bounceController1 = new BounceController1();   //creates a new instance of the BounceController1 class and assigns it to the variable bounceController1. It initializes the controller object.
	    rectObject.setController(bounceController1); //sets the previously created bounceController1 as the controller for the rectObject
	    addObject(rectObject); //adds the object to the level
	  
	    RectObject rectObject1 = new RectObject("rectObject1", this, 200, 200, -150, -50, 30, 30, Color.GREEN);
	    rectObject1.setController(new BounceController());
	    addObject(rectObject1);  
	}

    /*
  protected boolean doneLevel = false;
*/
    
    
  @Override
  public int preferredSizeX() {     //size of the level
    return 700;
  }

  @Override
  public int preferredSizeY() {
	return 700;
  }
  
  @Override
  public String getName() {
    return "Level 1";
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
	
	return false;
  }
  
  
}


