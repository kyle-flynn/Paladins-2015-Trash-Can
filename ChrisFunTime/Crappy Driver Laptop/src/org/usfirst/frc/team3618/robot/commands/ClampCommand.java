package org.usfirst.frc.team3618.robot.commands;

import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClampCommand extends Command{
	
	public ClampCommand()
	{
		requires(Robot.clampSubsystem);
	}
	
	public void initialize()
	{
		//Does stuff before command runs for the first time
	}
	
	public void interrupted()
	{
		end();
	}
	
	public boolean isFinished()
	{
		return false;
	}
	
	public void execute()
	{
		Robot.clampSubsystem.operateClamp();
	}
	
	public void end()
	{
		
	}
	
	

}
