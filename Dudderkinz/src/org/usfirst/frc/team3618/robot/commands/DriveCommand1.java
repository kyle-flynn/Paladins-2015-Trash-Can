
package org.usfirst.frc.team3618.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3618.robot.Robot1;

/**
 *
 */
public class DriveCommand1 extends Command {

    public DriveCommand1() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot1.chassisSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot1.chassisSubsystem.DriveMe(Robot1.oi.stick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot1.chassisSubsystem.StopMe();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot1.chassisSubsystem.StopMe();
    }
}
