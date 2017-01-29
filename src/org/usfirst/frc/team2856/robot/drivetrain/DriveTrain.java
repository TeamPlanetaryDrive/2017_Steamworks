package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain{
	
	
	
	RobotDrive drive;
	PIDMotor left, right;
	
	
	public DriveTrain(){
		drive = new RobotDrive(Constants.lMotor, Constants.sync_lMotor,
						Constants.rMotor, Constants.sync_rMotor);
		left = new PIDMotor();
		right = new PIDMotor();
		
		left.init(Constants.lMotor, true, Constants.LEnc, false);
		left.init(Constants.rMotor, false, Constants.REnc, false);
		
		
		
	}
	
	public void setSetpoint(){
		
	}
	

	public void tankDrive(GenericHID leftStick, GenericHID rightStick){
		drive.tankDrive(leftStick, rightStick);
	}

	
	
	
	
}
