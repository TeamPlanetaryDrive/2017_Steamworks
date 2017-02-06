package org.usfirst.frc.team2856.robot.loop;

import org.usfirst.frc.team2856.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoopAuto extends Loop{

	static String[] modes = {"l", "m", "r", "s"};
	
	String autoSelected;
	
	public LoopAuto(Robot rob){super(rob);}
	
	public void init() {
		autoSelected = SmartDashboard.getString("Auto Selector", "None");
		
		
		switch(autoSelected){
		
		case "l":
			break;
		case "m":
			break;
		case "r":
			break;
		case "s":
			break;
		default:
			break;
		}
		
		
		
		
	}

	public void loop() {
		
	}
	
	public static void addModes(){
		
		for(int i = 0; i < modes.length; i++){
			SmartDashboard.putString("Auto Selector", modes[i]);
		}
		
	}
	
}
