package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DriveTrain{
	
	
	
	RobotDrive drive;
	PIDMotor left, right;
	Gyro gyro;
	
	public DriveTrain(){
		drive = new RobotDrive(Constants.lMotor, Constants.rMotor);
		left = new PIDMotor();
		right = new PIDMotor();
		
		left.init(Constants.lMotor, true, Constants.LEnc, false);
		right.init(Constants.rMotor, false, Constants.REnc, false);
		
		gyro = Constants.gyro;
		gyro.reset();
		gyro.calibrate();
	}
	
	public void setSetpoint(){
		
		left.setSetpoint(0000000000000000000);
		right.setSetpoint(0000000000000000000);
		
		Constants.sync_lMotor.set(Constants.lMotor.get());
		Constants.sync_rMotor.set(Constants.rMotor.get());
	}
	

	public void tankDrive(GenericHID leftStick, GenericHID rightStick){
		drive.tankDrive(leftStick, rightStick);
		Constants.sync_lMotor.set(Constants.lMotor.get());
		Constants.sync_rMotor.set(Constants.rMotor.get());
	}

	
	
	
	
}
