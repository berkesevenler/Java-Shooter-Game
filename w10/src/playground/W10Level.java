package playground;

import spaceinvadersProject.gameobjects.EgoObject;
import spaceinvadersProject.playground.SpaceInvadersLevel;
import java.awt.Color;
import javashooter.controller.*;
import javashooter.gameobjects.GameObject;
import javashooter.gameobjects.RectObject;
import javashooter.gameobjects.TextObject;
import javashooter.rendering.PulsatingCircleArtist;
import java.util.LinkedList;
import spaceinvadersProject.controller.*;
import controller.ZickZackController;



public class W10Level extends SpaceInvadersLevel {
		public static final int NR_ENEMIES = 10;
		public static final double ENEMYSPEEDX = 180.0; // /40.0;
		public static final double ENEMYSPEEDY = 0;
		public static final int BOSS_HEALTH = 1;

		private int bossHealth;
	
		 
		@Override
		public String getName () {
			return "Level1";
		}
		protected String getStartupMessage ( ) {
			return "W10-level";
		}
		protected double calcEnemySpeedX() {
			return ENEMYSPEEDX;
		}
		protected double calcEnemySpeedY() {
			return ENEMYSPEEDY;
		}
		protected int calcNrEnemies() {
			return NR_ENEMIES;
		}
		public double calcEnemyShotProb() {
		    return 0.1 * this.getTimestep();
		  }
	
		 
		 
		 @Override
		    protected void actionIfEnemyIsHit(GameObject e, GameObject shot) {
		        bossHealth--;		       
		        if (bossHealth <= 0) {
		            deleteObject(shot.getId());
		            deleteObject(e.getId());		           
		           int pts = points.get();
		           points.set(pts + 200);
		        } else {
		            deleteObject(shot.getId());
		           
		        }
		    }

		    @Override
		    public void prepareLevel(String id) {
		        super.prepareLevel(id);
		        bossHealth = BOSS_HEALTH;		      
		     }
		    
		    @Override
		    public void applyGameLogic() {
		      super.applyGameLogic();
		      GameObject s = this.getObject("ego");

		      // When hearts are collected
		      LinkedList<GameObject> collects = collectObjects("collect", false);
		      for (GameObject c : collects) {  //"foreach" loop which will iterate over each GameObject in the collects LinkedList.
		        if (s.collisionDetection(c)) {
		          activateRotatingShots();
		         // actionIfEgoCollidesWithCollect(c, s);
		        }
		      }
		    }
		    
	   		  
		    @Override
		    protected GameObject createEgoObject() {
		    	/*
		      CollisionAware4WayController egoController = new CollisionAware4WayController(this.calcEgoSpeed());
		      egoController.setSpeed(this.calcEgoSpeed());

		      GameObject ego = new EgoObject("ego", this, 50, preferredSizeY() - 60, 0, 0, EGORAD)
		        .setController(egoController)
		        .generateColliders();
		        */
		    	GameObject ego = super.createEgoObject();

		      // Create the PulsatingCircleArtist with the ego object, the initial radius, color, reduction, and frequency
		      PulsatingCircleArtist artist = new PulsatingCircleArtist(ego, EGORAD, Color.GREEN, 0.7, 0.16);
		    
		      // Adding the PulsatingCircleArtist to the EgoObject
		      ego.addArtist(artist); 

		      return ego;
		    }
		    
		    
		    protected GameObject createEnemyShotObject(GameObject parentObject, String name,
		     ObjectController limitedTimeController) {
		     ZickZackController controller = new ZickZackController(0.5, -30, 30);
		     GameObject to =  new TextObject(name, this, parentObject.getX(), parentObject.getY(), 0, ENEMYSHOTSPEED, "I",
		    	       20, Color.YELLOW).generateColliders().setController(controller);

		        return to;
		    }   
		    
		    
		    private boolean isRotatingShotActive = false;  // flag for the rotating shot effect
		    private long effectEndTime;  // time when the effect ends

		    // Method to activate the rotating shot effect
		    public void activateRotatingShots() {
		      isRotatingShotActive = true;
		      effectEndTime = System.currentTimeMillis() + 5000;  //the current system time plus 5000 milliseconds (5 seconds)
		    }

		    @Override
		    public GameObject createEgoShot(String shotName, GameObject ego) {
		      SimpleShotController simpleshot = new SimpleShotController();
		      GameObject ss = new RectObject(shotName, this, ego.getX(), ego.getY(), 0,
		          -1. * SpaceInvadersLevel.SHOTSPEED, 4, 12, Color.CYAN).setController(simpleshot);

		      // If less than 5 seconds have passed since the rotating shot was activated
		      if (isRotatingShotActive && System.currentTimeMillis() < effectEndTime) {
		        ss.setOmega(Math.PI);  // set angular velocity ω = π
		      } else {
		        // If the effect has ended, deactivate it
		        isRotatingShotActive = false;
		      }

		      ss.generateColliders();
		      return ss;
		    }
		    
}

