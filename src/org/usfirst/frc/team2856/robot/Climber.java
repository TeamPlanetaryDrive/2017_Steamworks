package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

//this is the climber class
public class Climber {
	//PMVs
	private SpeedController motor;
	private double climbSpeed = 0.3424243244;	//climbSpeed & intakeSpeed are random values
	private final double intakeSpeed=0.111111111;
	
	
	private boolean intakeOn;
	boolean prevIntake;
	boolean currIntake;
	
	boolean running;
	boolean prevRunning;
	boolean currRunning;
	
	
	
	//constructor
	public Climber(){
		motor=Constants.climber; //not actual channel
		intakeOn=true;
		prevRunning = false;
		prevIntake = false;
		running = true;
	}
	
	//move
	public void updateTele(){
		currRunning = Constants.leftJoystick.getRawButton(00000000);
		currIntake = Constants.leftJoystick.getRawButton(00000001);
		
		if(currRunning && !prevRunning){
			running = !running;
		}
		
		if(currIntake && !prevIntake){
			intakeOn = !intakeOn;
		}
		
		climbSpeed=Constants.leftJoystick.getY();
		
		//if a different button is pressed and held, robot will move by a certain speed
		if(running){
			if(intakeOn){
				motor.set(intakeSpeed);
			}else{
				motor.set(climbSpeed);
			}
		}else{
			motor.set(0);
		}
		
		prevRunning = currRunning;
		prevIntake = currIntake;
	}
	
	//accessors
	public double getClimbSpeed(){return climbSpeed;}
	public double getIntakeSpeed(){return intakeSpeed;}
	
	//mutators
	public void setClimbSpeed(double num){climbSpeed=num;}
}
