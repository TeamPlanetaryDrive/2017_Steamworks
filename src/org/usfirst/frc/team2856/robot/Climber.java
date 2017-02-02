package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

//this is the climber class
public class Climber {
	//PMVs
	private SpeedController motor;
	private double speed = 0.6;
	
	//constructor
	public Climber(){
		motor = Constants.climber; //not actual channel
	}
	
	//move
	public void updateTele(){
		if(Constants.leftJoystick.getRawButton(0000000000000)){
			motor.set(speed);
		}else{
			motor.set(0);
		}
	}
	
	//getter
	public double getSpeed(){return speed;}
	
	//setter
	public void setSpeed(double num){speed=num;}
}
