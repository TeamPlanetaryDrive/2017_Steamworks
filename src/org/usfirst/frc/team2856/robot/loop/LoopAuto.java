package org.usfirst.frc.team2856.robot.loop;

import org.usfirst.frc.team2856.robot.Constants;
import org.usfirst.frc.team2856.robot.Robot;
//import org.usfirst.frc.team2856.robot.Shooter;
import org.usfirst.frc.team2856.robot.drivetrain.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoopAuto extends Loop{

	static String[] modes = {"l", "m", "r", "s"};
	
	//IterativeRobot robot;
	private String autoSelected;
	private Integer state;
	private DriveTrain drive;
	public LoopAuto(Robot rob){super(rob);}
	
	public void init() {
		robot.driveTrain.drive.setSafetyEnabled(false);		
		Constants.lMotor.setInverted(false);
		Constants.rMotor.setInverted(true);
		autoSelected = SmartDashboard.getString("Auto Selector", "None");
		autoSelected = "Line";
		System.out.println("Auto selected: " + autoSelected);
		state = 0;
		
		robot.driveTrain.drive.setSafetyEnabled(false);		
		drive = robot.driveTrain;
		stateMachine();
	}

	public void loop() {
		
		stateMachine();
		drive.update(false);
	}
	
	public static void addModes(){
		
		for(int i = 0; i < modes.length; i++){
			SmartDashboard.putString("Auto Selector", modes[i]);
		}
		
	}
	
	
	private void stateMachine() {
		switch(autoSelected) {
			case "Forward":
				switch(state) {
					case 0:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(Constants.AUTO_DIST);
							state++;
						}
						break;
					default:
						break;
				}
				break;
			case "FwdRev":
				switch(state) {
					case 0:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(Constants.AUTO_DIST);
							state++;
						}
						break;
					case 1:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(-Constants.AUTO_DIST);
							state++;
						}
						break;
					default:
						break;
				}
				break;
			case "Line":
				switch(state) {
					case 0:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(6.0);
							state++;
						}
						break;
					case 1:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(180.0, 0.0);
							state++;
						}
						break;
					case 2:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(6.0);
							state++;
						}
						break;
					case 3:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(-180.0, 0.0);
							state++;
						}
						break;
					default:
						break;
				}
				break;
			case "Square":
				switch(state) {
					case 0:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(3.0);
							state++;
						}
						break;
					case 1:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(90.0, 2.0);
							state++;
						}
						break;
					case 2:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(3.0);
							state++;
						}
						break;
					case 3:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(90.0, 2.0);
							state++;
						}
						break;
					case 4:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(3.0);
							state++;
						}
						break;
					case 5:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(90.0, 2.0);
							state++;
						}
						break;
					case 6:
						if(!drive.moveGetActive())
						{
							drive.moveStraight(3.0);
							state++;
						}
						break;
					case 7:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(90.0, 2.0);
							state++;
						}
						break;
					default:
						break;
				}
				break;
			case "Turn":
				switch(state) {
					case 0:
						if(!drive.moveGetActive())
						{
							drive.moveTurn(90.0, 0.0);
							state++;
						}
						break;
					default:
						break;
				}
				break;
			default:
				// No match found, do nothing
				break;
		}
	}
	
	
	public void leftPegCommands() {
		robot.driveTrain.moveStraight(1);
		//robot.driveTrain.moveTurn(1, 90);
	}
	public void middlePegCommands() {
		robot.driveTrain.moveStraight(1);
		robot.driveTrain.moveTurn(1, 90);
	}
	public void rightPegCommands(){
		robot.driveTrain.moveStraight(1);
		robot.driveTrain.moveTurn(1, 90);
	}
	public void shootCommands() {
		robot.driveTrain.moveStraight(2);
		robot.driveTrain.moveTurn(1, 90);
//		Constants.shooter.set(0.98);;
	}
	
}
