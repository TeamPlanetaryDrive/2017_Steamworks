package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

/**
 * 
 * @author eric7
 * Contains both Shooter and Hopper
 */
public class Shooter {
	
	//booleans added
	boolean shooterOn, hopperOn;
	boolean waspressed;
	
	private static double Kp = 1,
			Ki = 0.1,
			Kd = 0;
	
	SpeedController hopper, shooter;
	Encoder enc;
	PIDController pidShoot;
	
	public Shooter() {
		
		shooterOn = false;
		hopperOn = false;
		waspressed = false;		
		
		hopper = Constants.hopper;
		shooter = Constants.shooter;
		enc = Constants.SEnc;
		
		pidShoot = new PIDController(Kp, Ki, Kd, enc, shooter, 0.01);
		
		enc.reset();
		enc.setPIDSourceType(PIDSourceType.kRate);
		enc.setDistancePerPulse(Constants.distancePerPulse);
		enc.setSamplesToAverage(Constants.DRIVE_ENC_SAMPLES_TO_AVERAGE);
		
		
		pidShoot.setOutputRange (-0.95, 0.95);
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
		boolean ispressed = Constants.leftJoystick.getRawButton(1);
		
		if( ispressed && !waspressed){
			toggleShooter();
			toggleHopper();
		}
		
		waspressed = ispressed; //impressed
		
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
