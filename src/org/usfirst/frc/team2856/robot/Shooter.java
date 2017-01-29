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
		shooterOn = false;
		hopperOn = false;
		hopper = new Talon(10000);
		phopper = new Talon(10001);
		shooter = new Talon(10002);
		en = new Encoder(17648736, 36583275);
		pidShoot = new PIDMotor();
		pidShoot.init(shooter, false, en, true);
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
			pidShoot.setSetpoint(0.9);//XXX This will eventually be PID controlled
		else
			pidShoot.setSetpoint(0);
		
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
