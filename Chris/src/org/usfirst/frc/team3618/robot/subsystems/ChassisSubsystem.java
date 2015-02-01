
package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.*;
/**
 *
 */
public class ChassisSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive drive = new RobotDrive(RobotMap.LEFT_FRONT_DRIVE_MOTOR, 
									  RobotMap.LEFT_BACK_DRIVE_MOTOR,
									  RobotMap.RIGHT_FRONT_DRIVE_MOTOR,
									  RobotMap.RIGHT_BACK_DRIVE_MOTOR);
	
	public ChassisSubsystem() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveMe(Joystick stick) {
    	drive.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getZ(), 0);
    }
    
    public void stopRobot()
    {
    	drive.stopMotor();
    }
    
    public void spinRobot(boolean clockwise)
    {
    	if(clockwise){
    		drive.setLeftRightMotorOutputs(.5, -.5);
    	}
    	else {
    		drive.setLeftRightMotorOutputs(-.5,.5);
    	}
    }
    
}



