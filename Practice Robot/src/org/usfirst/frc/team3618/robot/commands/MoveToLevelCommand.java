package org.usfirst.frc.team3618.robot.commands;

import java.util.Date;

import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveToLevelCommand extends Command {

	public static double toteHeight = 13.0;
	//Technically totes are 12.1 inches but 13.0 gives space for error.
	public static double levelsInches[] = {0.0, 3.0, 16.0, 29.0, 42.0};
	

	private boolean goUp;
	
	//Level 0 is fully down
	//Level 1 is 2 inches up (first tote just off of floor), 
	//Level 2 is first tote high enough to clear a second tote and so on.
	
    public MoveToLevelCommand(boolean increment) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	goUp = increment;
    	
    	requires(Robot.rightPIDSubsystem);
    	requires(Robot.leftPIDSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(goUp == true) {
    		Robot.leftPIDSubsystem.levelUp();
    	} else {
    		Robot.leftPIDSubsystem.levelDown();
    	}
    	    	
    	Robot.rightPIDSubsystem.setSetpoint(countsAtLevel(Robot.currentLevel));
    	Robot.leftPIDSubsystem.setSetpoint(countsAtLevel(Robot.currentLevel));
    	Robot.rightPIDSubsystem.enable();
    	Robot.leftPIDSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// watch for movement, fault if problem
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// If both are on target, or if one is on target and the other has an encoder reading of '0', then consider it finished
    	if ((Robot.rightPIDSubsystem.onTarget() && Robot.leftPIDSubsystem.onTarget()) 
    			|| (Robot.rightPIDSubsystem.onTarget() && Robot.leftPIDSubsystem.leftLiftEncoder.get() == 0)
    			|| (Robot.leftPIDSubsystem.onTarget() && Robot.rightPIDSubsystem.rightLiftEncoder.get() == 0)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rightPIDSubsystem.disable();
    	Robot.leftPIDSubsystem.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    
    
    
   public double countsAtLevel(int level){
    	return levelsInches[level] * Robot.countsPerInch;
    }
    
}
