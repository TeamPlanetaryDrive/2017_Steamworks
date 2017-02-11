package org.usfirst.frc.team2856.robot.drivetrain;

import org.usfirst.frc.team2856.robot.Constants;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDMotor extends PIDSubsystem{
	private static final double Kp = 1,
			Ki = 0.1,
			Kd = 0;
	
	//PIDController ...
	SpeedController motor;
	Encoder enc;
	
	
	/**
	 * Init needs to be called
	 */
	public PIDMotor(){
		super("PIDMotor", Kp, Ki, Kd);
		
		this.setOutputRange(-0.95, 0.95);
		this.setAbsoluteTolerance(0.05);
		this.getPIDController().setContinuous(true);//XXX
	}
	
	public void init(SpeedController sc, boolean inv, Encoder en, boolean rate){
		motor = sc;
		motor.setInverted(inv);
		
		enc = en;
		enc.reset();
		enc.setDistancePerPulse(Constants.distancePerPulse);
		
		if(rate)
			enc.setPIDSourceType(PIDSourceType.kRate);
		else
			enc.setPIDSourceType(PIDSourceType.kDisplacement);
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
	