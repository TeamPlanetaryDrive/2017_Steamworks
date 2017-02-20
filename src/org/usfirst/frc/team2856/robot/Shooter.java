package org.usfirst.frc.team2856.robot;

import org.usfirst.frc.team2856.robot.drivetrain.PIDMotor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	PIDMotor pidShoot;
	
	public Shooter() {
		
		shooterOn = false;
		hopperOn = false;
		waspressed = false;		
		
		hopper = Constants.hopper;
		shooter = Constants.shooter;
		enc = Constants.SEnc;
		
		pidShoot = new PIDMotor(Kp, Ki, Kd);
		
		pidShoot.init(shooter, false, enc);
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
		if(ispressed)//added
			SmartDashboard.putString("DB/String 0", "Button 1 Pressed- shooter"); //added
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
			if(Constants.leftJoystick.getRawButton(3)){
				Constants.hopper.set(0.5);
				SmartDashboard.putString("DB/String 0", "Button 3 Pressed- positive hopper");
			}else{
				if(Constants.leftJoystick.getRawButton(2)){
				Constants.hopper.set(-0.5);
				SmartDashboard.putString("DB/String 0", "Button 2 Pressed- negative hopper");
				}
			
		else{
			Constants.hopper.set(0);
		}
		}
		//Should use PID
		
	}
	
	}
	}
