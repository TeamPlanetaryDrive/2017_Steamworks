package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Constants {
	
	//CONSTANTS as in  numbers
	
	//Digital (0-9, 10-25)
	public static int LEFT_MOTOR_CHANNEL = 0,
			RIGHT_MOTOR_CHANNEL = 1,
			SYNC_LEFT_MOTOR_CHANNEL = 2,
			SYNC_RIGHT_MOTOR_CHANNEL = 3;
	
	public static int SHOOTER_CHANNEL = 4,
			HOPPER_CHANNEL = 5,
			SYNC_HOPPER_CHANNEL = 6,
			CLIMBER_CHANNEL = 7;
	
	public static Port GYRO_PORT;
	
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
	
	
	//HARDWARE
	public static Talon lMotor,
			rMotor,
			sync_lMotor,
			sync_rMotor;
	
	public static Talon shooter, 
			hopper, 
			sync_hopper,
			climber;

	
	public static Encoder LEnc,
			REnc,
			SEnc;
	
	public static Joystick leftJoystick,
			rightJoystick;
	
	public static Gyro gyro;
	
	public static void init(){
		GYRO_PORT.value = 0;
		
		lMotor = new Talon(LEFT_MOTOR_CHANNEL);
		rMotor = new Talon(RIGHT_MOTOR_CHANNEL);
		sync_lMotor = new Talon(SYNC_LEFT_MOTOR_CHANNEL);
		sync_rMotor = new Talon(SYNC_RIGHT_MOTOR_CHANNEL);
		
		shooter = new Talon(SHOOTER_CHANNEL);
		hopper = new Talon(HOPPER_CHANNEL);
		sync_hopper = new Talon(SYNC_HOPPER_CHANNEL);
		climber = new Talon(CLIMBER_CHANNEL);
		
		LEnc = new Encoder(LEFT_ENC_CHANNEL_A, LEFT_ENC_CHANNEL_B);
		REnc = new Encoder(RIGHT_ENC_CHANNEL_A, RIGHT_ENC_CHANNEL_B);
		SEnc = new Encoder(SHOOTER_ENC_CHANNEL_A, SHOOTER_ENC_CHANNEL_B);
		
		leftJoystick = new Joystick(LEFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RIGHT_JOYSTICK_PORT);
		
		gyro = new ADXRS450_Gyro(GYRO_PORT);
		
	}
	
}
