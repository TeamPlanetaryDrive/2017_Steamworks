package org.usfirst.frc.team2856.robot.loop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoopAuto extends Loop{

	static String[] modes = {"0", "1", "2", "3", "4", "5", "6"};
	
	
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
