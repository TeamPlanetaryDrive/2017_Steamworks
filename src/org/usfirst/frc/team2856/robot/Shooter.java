package org.usfirst.frc.team2856.robot;


/**
 * 
 * @author eric7
 * Contains both Shooter and Hopper
 */
public class Shooter {
	
	private double lowSpeed = 0.2, 
			highSpeed = 0.8;
	
	boolean shooterOn = false;
	
	boolean hopperOn = false;
	boolean hopperFast = false;
	
	
	//SpeedController hopper, shooter;
	
	public Shooter() {
		
	}
	
	public void toggleShooter(){
		shooterOn = true;
	}
	
	public void toggleHopper(){
		
	}
	
	
	public void update(){
		
		if(!hopperOn){
			Constants.hopper.set(0);
		}else if(!hopperFast){
			Constants.hopper.set(lowSpeed);
		}else{
			Constants.hopper.set(highSpeed);
		}
		
		//Should use PID
		//Constants.shooter.set(0.9);
		
	}
	
}
