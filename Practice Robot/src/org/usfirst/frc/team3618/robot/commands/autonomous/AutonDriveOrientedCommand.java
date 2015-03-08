package org.usfirst.frc.team3618.robot.commands.autonomous;

import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class AutonDriveOrientedCommand extends Command {

	private double distance;
	private double angle;
	private double speed;
	
    public AutonDriveOrientedCommand(double speed, double angle, double distance) {
    	this.speed = speed;
    	this.angle = angle;
    	this.distance = distance;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.AutoDrive(Robot.chassisSubsystem.accel(speed, timeSinceInitialized(), 0.3), angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(distance != 0) {
    		return Robot.chassisSubsystem.getFeetFromTicks(Robot.chassisSubsystem.getEncoders())>distance;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.StopMe();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
}
