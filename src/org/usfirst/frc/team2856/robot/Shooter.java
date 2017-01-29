package org.usfirst.frc.team2856.robot;


/**
 * 
 * @author eric7
 * Contains both Shooter and Hopper
 */
public class Shooter {
	
	
	boolean shooterOn, hopperOn;
	
	//SpeedController hopper, shooter;
	//XXX create phopper
	
	public Shooter() {
		shooterOn = false;
		hopperOn = false;
	}
	
	public void toggleShooter() {
		shooterOn = !shooterOn;
	}
	
	public void toggleHopper() {
		hopperOn = !hopperOn;
	}
	
	/**
	 * This is a function that is called in a loop.
	 * Each call will be a single call within the loop.
	 * 
	 */
	public void update(){
		
		if(shooterOn)
			Constants.shooter.set(0.9);//XXX This will eventually be PID controlled
		else
			Constants.shooter.set(0);
		
		//XXX
		if(hopperOn){
			if(Constants.leftJoystick.getRawButton(3024721))//some value
				Constants.hopper.set(0.5);//XXX This will eventually be PID controlled
			else
				Constants.hopper.set(0.9);
		}else
			Constants.hopper.set(0);
		
		
		
		//Should use PID
		
	}
	
}
