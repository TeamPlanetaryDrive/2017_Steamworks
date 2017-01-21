package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain{
	
	
	
	RobotDrive drive;
	
	
	public DriveTrain(){
		drive = new RobotDrive(Constants.flMotor, Constants.rlMotor,
						Constants.frMotor, Constants.rrMotor);
		
		
	}
	
	

	public void tankDrive(GenericHID leftStick, GenericHID rightStick){
		drive.tankDrive(leftStick, rightStick);
	}

	
	
	
	
}
