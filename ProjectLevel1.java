package playground;

import spaceinvadersProject.playground.SpaceInvadersLevel;
import javashooter.gameobjects.*;

public class ProjectLevel1 extends SpaceInvadersLevel {
		public static final int NR_ENEMIES = 1;
		public static final double ENEMYSPEEDX = 160;
		public static final double ENEMYSPEEDY = 80;

		@Override
		public String getName () {
			return "Level1";
		}
		protected String getStartupMessage ( ) {
			return "Level 1";
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
		protected void actionIfEnemyIsHit(GameObject e, GameObject shot) {
			System.out.println("AUA!!");
			super.actionIfEnemyIsHit(e, shot);
		}	
}