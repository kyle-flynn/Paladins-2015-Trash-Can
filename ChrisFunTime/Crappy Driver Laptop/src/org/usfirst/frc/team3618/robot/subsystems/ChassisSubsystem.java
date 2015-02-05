
package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.OI;
import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.lang.Math;
/**
 *
 */
public class ChassisSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private RobotDrive drive = new RobotDrive(RobotMap.LEFT_FRONT_DRIVE_MOTOR, 
									  RobotMap.LEFT_BACK_DRIVE_MOTOR,
									  RobotMap.RIGHT_FRONT_DRIVE_MOTOR,
									  RobotMap.RIGHT_BACK_DRIVE_MOTOR);
	//Robot drive should NOT be public, just for testing
	
	public ChassisSubsystem() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveMe(Joystick stick) {
    	//Modified to be more precise and awesome
    	if(stick.getRawButton(OI.drivePrecise)){
    		double xValue = stick.getX();
    		double yValue = stick.getY();
    		double zValue = stick.getZ();
    		xValue *= Math.abs(xValue);
    		yValue *= Math.abs(yValue);
    		zValue *= Math.abs(zValue);
    		drive.mecanumDrive_Cartesian(xValue, yValue, zValue, 0);
    	}
    	else{
    		drive.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getZ(), 0);
    	}
    }
    
    public void stopRobot()
    {
    	drive.stopMotor();
    }
    
}



