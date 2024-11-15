package w10;
import spaceinvadersProject.SpaceInvadersGame;
import javashooter.playground.Playground;
import playground.W10Level; 



public class EigenesSpielW10 extends SpaceInvadersGame {
	
	public EigenesSpielW10 () {
		System.out.println("Hallo");
	}
	EigenesSpielW10 currentLevel=null;
	
	
	@Override
	public Playground nextLevel(Playground currentLevel) {
		if (currentLevel == null) {
			currentLevel = new W10Level ();
			System.out.println("Next Level: " + currentLevel.getName ()) ;
		} 
		else {
			return null;
		}
		return currentLevel;
	}
		
		public static void main (String[] args) {
			EigenesSpielW10 game = new EigenesSpielW10 () ;
			game. nextLevel(null);
			game. runGame (args) ;
		}
}