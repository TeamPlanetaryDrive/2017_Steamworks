package org.usfirst.frc.team2856.robot.loop;

import org.usfirst.frc.team2856.robot.Constants;
import org.usfirst.frc.team2856.robot.Robot;
import org.usfirst.frc.team2856.robot.Shooter;
public class LoopTele extends Loop{

	//DriveTrain driveTrain

	public LoopTele(Robot rob){super(rob);}


	//XXX Disable autonomous dependencies
	public void init() {

	}




	//XXX DriveTrain
	//XXX Shooter
	//XXX Climber

	public void loop() {

		robot.driveTrain.arcadeDrive(robot.left);
		robot.shooter.updateTele();
		robot.climber.updateTele();

		//trigger code
		if(Constants.leftJoystick.getRawButton(1)==true){
			robot.shooter.toggleShooter();
			robot.shooter.toggleHopper();
		}
		else{
			robot.shooter.setshooterOn(false);
			robot.shooter.sethopperOn(false);
		}

	}

}
