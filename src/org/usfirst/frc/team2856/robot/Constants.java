package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;

public class Constants {
	
	//CONSTANTS as in  numbers
	public static int FRONT_LEFT_MOTOR_CHANNEL = 0,
			FRONT_RIGHT_MOTOR_CHANNEL = 1,
			REAR_LEFT_MOTOR_CHANNEL = 2,
			REAR_RIGHT_MOTOR_CHANNEL = 3;
	
	public static int LEFT_ENC_CHANNEL_A = 0,
			LEFT_ENC_CHANNEL_B = 1,
			RIGHT_ENC_CHANNEL_A = 2,
			RIGHT_ENC_CHANNEL_B = 3;
	
	public static int LEFT_JOYSTICK_PORT = 0,
			RIGHT_JOYSTICK_PORT = 1;
	
	public static double distancePerPulse = 0.0637;
	
	
	//HARDWARE
	public static Talon flMotor,
			frMotor,
			rlMotor,
			rrMotor;
	
	public static Encoder LEnc,
			REnc;
	
	public static Joystick leftJoystick,
			rightJoystick;
	
	public static void init(){
		flMotor = new Talon(FRONT_LEFT_MOTOR_CHANNEL);
		frMotor = new Talon(FRONT_RIGHT_MOTOR_CHANNEL);
		rlMotor = new Talon(REAR_LEFT_MOTOR_CHANNEL);
		rrMotor = new Talon(REAR_RIGHT_MOTOR_CHANNEL);
		
		LEnc = new Encoder(LEFT_ENC_CHANNEL_A, LEFT_ENC_CHANNEL_B);
		REnc = new Encoder(RIGHT_ENC_CHANNEL_A, RIGHT_ENC_CHANNEL_B);
		
		leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
	}
	
}
