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
		//trigger code(firing)
		if(Constants.leftJoystick.getRawButton(1)==true){
			robot.shooter.toggleShooter();
			robot.shooter.toggleHopper();
		}
		else{
			robot.shooter.setshooterOn(false);
			robot.shooter.sethopperOn(false);
		}
		//climber code(switching intake modes)
		if(Constants.leftJoystick.getRawButton(6)==true){
			robot.climber.toggleIntake();
		}
		robot.driveTrain.arcadeDrive(robot.left);
		robot.shooter.updateTele();
		robot.climber.updateTele();


	}

}
