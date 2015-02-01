package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

public class LiftSubsystem extends Subsystem{
	
	RobotDrive lift;
	
	public LiftSubsystem() {
		lift = new RobotDrive(RobotMap.LEFT_LIFT_MOTOR, RobotMap.RIGHT_LIFT_MOTOR);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void stopLift() {
		lift.stopMotor();
	}
	
	

}
