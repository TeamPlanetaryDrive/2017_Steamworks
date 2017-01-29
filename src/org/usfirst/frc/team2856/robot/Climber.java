package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

//this is the climber class
public class Climber {
	//PMVs
	private SpeedController motor;
	private double speed = 0.6;
	
	//constructor
	public Climber(){
		motor=new Talon(786856); //not actual channel
	}
	
	//where it actually moves, tell it whether or not to move
	public void set(boolean turn){
		if(turn)
			motor.set(speed);
		else
			motor.set(0);
	}
	
	//getter
	public double getSpeed(){return speed;}
	
	//setter
	public void setSpeed(double num){speed=num;}
}
