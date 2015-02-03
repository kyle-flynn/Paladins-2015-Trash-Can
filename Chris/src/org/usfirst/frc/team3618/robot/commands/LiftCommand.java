package org.usfirst.frc.team3618.robot.commands;

import org.usfirst.frc.team3618.robot.OI;
import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftCommand extends Command {
	public LiftCommand(){
		requires(Robot.liftSubsystem);
	}
	
	protected void initialize()
	{
		//Does stuff before this command runs the first time
	}
	
	protected void execute()
	{
		Robot.liftSubsystem.operateLift(OI.bigStick);
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		Robot.liftSubsystem.stopLift();
	}
	
	protected void interrupted()
	{
		end();
	}

}
