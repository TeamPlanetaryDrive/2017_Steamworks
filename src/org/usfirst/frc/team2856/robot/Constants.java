package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Constants {
	
	//CONSTANTS as in  numbers
	
	//Digital (0-9, 10-25)
	public static int LEFT_MOTOR_CHANNEL = 0,
			RIGHT_MOTOR_CHANNEL = 1;
	
	public static int SHOOTER_CHANNEL = 2,
			HOPPER_CHANNEL = 3,
			CLIMBER_CHANNEL = 4;
	
	public static int LIMIT_SWITCH_CHANNEL = 5;
	
//	public static Port GYRO_PORT;
	
	//Analog Channels (0-3, 4-7)
	
	public static int LEFT_ENC_CHANNEL_A = 0,
			LEFT_ENC_CHANNEL_B = 1,
			RIGHT_ENC_CHANNEL_A = 2,
			RIGHT_ENC_CHANNEL_B = 3,
			SHOOTER_ENC_CHANNEL_A = 4,
			SHOOTER_ENC_CHANNEL_B = 5;
	
	
	public static int LEFT_JOYSTICK_PORT = 0,
			RIGHT_JOYSTICK_PORT = 1;
	
	public static double distancePerPulse = 0.0637;
	
	
	
	
	
	//Will add PWM Channels
	
	//HARDWARE
	public static Talon lMotor,
			rMotor;
	
	public static Talon shooter, 
			hopper, 
			climber;

	public static DigitalInput gearIn;
	
	public static Encoder LEnc,
			REnc,
			SEnc;
	
	public static Joystick leftJoystick,
			rightJoystick;
	
	public static Gyro gyro;
	
	public static DigitalInput gear;
	
	public static void init(){
//		GYRO_PORT.value = 0;
		
		lMotor = new Talon(LEFT_MOTOR_CHANNEL);
		rMotor = new Talon(RIGHT_MOTOR_CHANNEL);
		
		shooter = new Talon(SHOOTER_CHANNEL);
		hopper = new Talon(HOPPER_CHANNEL);
		climber = new Talon(CLIMBER_CHANNEL);
		
		gearIn = new DigitalInput(LIMIT_SWITCH_CHANNEL);
		
		LEnc = new Encoder(LEFT_ENC_CHANNEL_A, LEFT_ENC_CHANNEL_B);
		REnc = new Encoder(RIGHT_ENC_CHANNEL_A, RIGHT_ENC_CHANNEL_B);
		SEnc = new Encoder(SHOOTER_ENC_CHANNEL_A, SHOOTER_ENC_CHANNEL_B);
		
		leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
		
		gyro = new ADXRS450_Gyro();
		
		gear = new DigitalInput(LIMIT_SWITCH_CHANNEL);
	}
	
}
