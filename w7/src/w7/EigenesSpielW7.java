package w7;

import playground.W7Level;
import javashooter.playground.Playground;
import spaceinvadersProject.SpaceInvadersGame;

public class EigenesSpielW7 extends SpaceInvadersGame {
    
    W7Level currentLevel=null ;
	

	public void nextLevel() {
		currentLevel = new W7Level();
	}
	
	public Playground nextLevel(Playground currentLevel) {
        if (currentLevel == null) {
            currentLevel = new W7Level();
            System.out.println("Next Level: " + currentLevel.getName());
        } else {
            return null;
        }
        return currentLevel;
    }
	
	public static void main(String[] args) {
		EigenesSpielW7 game = new EigenesSpielW7();
        game.nextLevel(null);    
        game.runGame(args);
    }

}

