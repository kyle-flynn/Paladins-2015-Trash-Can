package org.usfirst.frc.team3618.robot.commands.autonomous;

import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonDriveCommand extends Command {

	private double speed;
	private double rotation;
	private double angle;
	
	
    public AutonDriveCommand(double speed, double rotation) {
    	this.speed = speed;
    	this.rotation = rotation;
    	this.angle = 0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassisSubsystem);
    }

    public AutonDriveCommand(double speed, double rotation, double angle) {
    	this.speed = speed;
    	this.rotation = rotation;
    	this.angle = angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassisSubsystem);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.firstGyro.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.DriveMe(speed, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(angle == 0) {
    		return false;
    	}else {
    		return angle == Robot.chassisSubsystem.firstGyro.getAngle();
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
