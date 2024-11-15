package controller;

import javashooter.controller.LimitedTimeController;
import javashooter.gameobjects.GameObject;

public class ZickZackController extends LimitedTimeController {
    private double directionChangeInterval;
    private double minSpeed;
    private double maxSpeed;
    private double g0;
    private int direction;

    public ZickZackController(double directionChangeInterval, double minSpeed, double maxSpeed) {
        super(0, 1000); // Set the duration to 100 seconds
        this.directionChangeInterval = directionChangeInterval;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.direction = 1; // Start with positive direction
      
    }

    @Override
    public void updateObject() {   // This is likely to ensure that any necessary updates from the parent class are still being executed.
        super.updateObject();

        double gameTime = getPlayground().getGameTime();
        double elapsedTime = gameTime - g0;    //calculates the elapsed time since the last direction change.

        // Change the X-speed direction every directionChangeInterval seconds
        if (elapsedTime >= directionChangeInterval) {
            direction *= -1; // Invert the direction

            // Generate a new random speed between minSpeed and maxSpeed
            double newSpeed = minSpeed + Math.random() * (maxSpeed - minSpeed);  // The speed is calculated by generating a random number between 0 and 1 (with Math.random())
            gameObject.setVX(newSpeed * direction);  

            g0 = gameTime; // Update the starting time for the next direction change. Updates g0
        }
    }
}