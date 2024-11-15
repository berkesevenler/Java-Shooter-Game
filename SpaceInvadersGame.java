package spaceinvadersProject;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.awt.font.TextAttribute;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import javashooter.gameobjects.GameObject;
import javashooter.gameutils.GameLoop;
import javashooter.playground.Playground;
import javashooter.ui.GameUI;
import javashooter.ui.Menu;
import spaceinvadersProject.playground.*;
import java.awt.event.*;


import java.util.Timer;
import java.util.TimerTask;


public class SpaceInvadersGame extends GameLoop {

    Playground currentLevel = null;

    public Playground nextLevel(Playground currentLevel) {
        
        Level0 level0 = new Level0();


        this.currentLevel = level0;
        return this.currentLevel;
    }

    public static void main(String[] args) {
        SpaceInvadersGame game = new SpaceInvadersGame();
        game.runGame(args);
    }
}

