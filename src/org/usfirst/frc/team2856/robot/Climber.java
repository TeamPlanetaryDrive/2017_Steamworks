package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//this is the climber class
public class Climber {
	//PMVs
	private SpeedController motor;
	private double climbSpeed = 0.3424243244;	//climbSpeed & intakeSpeed are random values
	
	//booleans for button pressing
	boolean running;
	boolean prevPressed;
	boolean currPressed;
	
	
	//constructor
	public Climber(){
		motor = Constants.climber; //not actual channel
		prevPressed = false;
		running = true;
	}
	
	//move
	public void updateTele(){
		currPressed = Constants.leftJoystick.getRawButton(6);
		if(currPressed)
			SmartDashboard.putString("DB/String 0", "Button 6 Pressed- climber");
		
		if(currPressed && !prevPressed){
			running = !running;
		}
		
		climbSpeed=Constants.leftJoystick.getY();
		
		//if a different button is pressed and held, robot will move by a certain speed
		if(running){
			motor.set(climbSpeed);
		}else{
			motor.set(0);
		}
		
		prevPressed = currPressed;
	}
	
	//accessor
	public double getClimbSpeed(){return climbSpeed;}
	
	//mutator
	public void setClimbSpeed(double num){climbSpeed=num;}
}
