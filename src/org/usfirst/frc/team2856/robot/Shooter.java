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
	
	SpeedController hopper, phopper, shooter;
	Encoder en;
	PIDMotor pidShoot;
	
	public Shooter() {
		// instantiate thingymabobs
		shooterOn = false; //is the shooter on
		hopperOn = false;  //is the hopper on
		hopper = new Talon(10000);  //new motor hopper
		phopper = new Talon(10001); //new motor pseudo-hopper
		shooter = new Talon(10002); //new motor shooter
		en = new Encoder(17648736, 36583275); //new encoder
		pidShoot = new PIDMotor();  //shooter needs to be precise, so use a PID
		pidShoot.init(shooter, false, en, true);  //initialize 
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
			pidShoot.setSetpoint(0.9); //make shooter spin
		else
			pidShoot.setSetpoint(0);   //make shooter not spin
		
		//XXX
		if(hopperOn){
			if(Constants.leftJoystick.getRawButton(3024721)){//some value
				Constants.hopper.set(0.5); //set hopper speed
			}else{
				Constants.hopper.set(0.9); //set heckin fast hopper speed
			}
		}
		else
			Constants.hopper.set(0);  //make hopper not spin
		
		
		
		//Should use PID
		
	}
	
}
