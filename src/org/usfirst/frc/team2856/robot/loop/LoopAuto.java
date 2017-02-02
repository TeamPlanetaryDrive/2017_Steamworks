package org.usfirst.frc.team2856.robot.loop;

import org.usfirst.frc.team2856.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoopAuto extends Loop{

	static String[] modes = {"LeftPeg", "MiddlePeg", "RightPeg"};
	
	public LoopAuto(Robot rob){super(rob);}
	
	public void init() {
		
	}

	public void loop() {
		
	}
	
	public static void addModes(){
		
		for(int i = 0; i < modes.length; i++){
			SmartDashboard.putString("Auto Selector", modes[i]);
		}
		
	}
	
}