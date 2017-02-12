package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

//this is the climber class
public class Climber {
	//PMVs
	private SpeedController motor;
	private double climbSpeed = 0.3424243244;	//climbSpeed & intakeSpeed are random values
	private final double intakeSpeed=0.111111111;
	private boolean intakeOn;
	
	//constructor
	public Climber(){
		motor=Constants.climber; //not actual channel
		intakeOn=true;
	}
	
	public void toggleIntake(){
		intakeOn=!intakeOn;
	}
	
	//move
	public void updateTele(){
		climbSpeed=Constants.leftJoystick.getY();
		
		if(Constants.leftJoystick.getRawButton(0000000000000)){
			if(intakeOn){
				motor.set(intakeSpeed);
			}else{
				motor.set(climbSpeed);
			}
		}else{
			motor.set(0);
		}
	}
	
	//accessors
	public double getClimbSpeed(){return climbSpeed;}
	public double getIntakeSpeed(){return intakeSpeed;}
	
	//mutators
	public void setClimbSpeed(double num){climbSpeed=num;}
}
