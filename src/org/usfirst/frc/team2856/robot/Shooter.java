package org.usfirst.frc.team2856.robot;

import org.usfirst.frc.team2856.robot.drivetrain.PIDMotor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * 
 * @author eric7
 * Contains both Shooter and Hopper
 */
public class Shooter {
	
	//booleans added
	boolean shooterOn, hopperOn;
	
	SpeedController hopper, shooter;
	Encoder enc;
	PIDMotor pidShoot;
	
	public Shooter() {
		// instantiate thingymabobs
		shooterOn = false; //is the shooter on
		hopperOn = false;  //is the hopper on
		
		hopper = Constants.hopper;  //new motor hopper
		shooter = Constants.shooter; //new motor shooter
		enc = Constants.SEnc; //new encoder
		
		pidShoot = new PIDMotor();  //shooter needs to be precise, so use a PID
		pidShoot.init(shooter, false, enc, true);  //initialize 
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
	public void updateTele(){
		
		
		
		if(shooterOn)
			pidShoot.setSetpoint(0.9);
		else
			pidShoot.setSetpoint(0);
		
		//XXX
		if(hopperOn){
			if(Constants.leftJoystick.getRawButton(3024721)){
				Constants.hopper.set(0.5);
			}else{
				Constants.hopper.set(0.9);
			}
		}else{
			Constants.hopper.set(0);
		}
		
		//Should use PID
		
	}
	
}
