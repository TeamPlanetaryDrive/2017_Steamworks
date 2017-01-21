package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem{
	
	private static final double Kp = 1,
								Ki = 0.1,
								Kd = 0;
	
	RobotDrive drive;
	Encoder enc;
	
	
	public DriveTrain(){
		super("DriveTrain", Kp, Ki, Kd);
		drive = new RobotDrive(Constants.flMotor, Constants.rlMotor,
						Constants.frMotor, Constants.rrMotor);
		
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(true);//XXX
		enc = new Encoder(0, 1);
		enc.reset();
		
		enc.setDistancePerPulse(Constants.distancePerPulse);
		this.setOutputRange(-1, 1);
	}
	
	

	@Override
	protected double returnPIDInput() {
		return enc.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		drive.tankDrive(0, output);
	}

	//XXX
	protected void initDefaultCommand() {
		//this.setSetpoint(10);	
	}
	
	public void tankDrive(GenericHID leftStick, GenericHID rightStick){
		drive.tankDrive(leftStick, rightStick);
	}
	
	
	
	
}
