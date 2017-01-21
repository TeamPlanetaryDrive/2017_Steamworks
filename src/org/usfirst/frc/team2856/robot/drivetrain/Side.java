package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Side extends PIDSubsystem{
	private static final double Kp = 1,
			Ki = 0.1,
			Kd = 0;
	
	//PIDController ...
	SpeedController motor;
	Encoder enc;
	
	
	public Side(){
		super("DriveTrain", Kp, Ki, Kd);
		
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(true);//XXX
		enc = new Encoder(0, 1);
		enc.reset();
		
		enc.setDistancePerPulse(Constants.distancePerPulse);
		this.setOutputRange(-1, 1);
	}

	public void setMotor(SpeedController sc){
		motor = sc;
	}
	
	public void setInverted(boolean inv){
		motor.setInverted(inv);
	}
	
	protected double returnPIDInput() {
		return enc.pidGet();
	}

	protected void usePIDOutput(double output) {
		motor.set(output);
	}

	//XXX
	protected void initDefaultCommand() {
		//this.setSetpoint(10);	
	}
	
}
