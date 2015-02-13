
package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.Robot;
import org.usfirst.frc.team3618.robot.RobotMap;
import org.usfirst.frc.team3618.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChassisSubsystem extends Subsystem {
	RobotDrive 	myRobotDrive =new RobotDrive (RobotMap.LEFT_FRONT_DRIVE_MOTOR,
											  RobotMap.LEFT_REAR_DRIVE_MOTOR,
											  RobotMap.RIGHT_FRONT_DRIVE_MOTOR,
											  RobotMap.RIGHT_REAR_DRIVE_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 public ChassisSubsystem() {
	    	myRobotDrive.setInvertedMotor(MotorType.kRearRight, true);
	    	myRobotDrive.setInvertedMotor(MotorType.kFrontRight, true);
//	    	frontRight.reset();
//	    	backRight.reset();
//	    	frontLeft.reset();
//	    	backLeft.reset();
	    }
	// public Encoder frontRight = new Encoder(0,1, false,Encoder.EncodingType.k4X); 
	 
	 //public Encoder backRight = new Encoder(2,3, false,Encoder.EncodingType.k4X);
	// public Encoder frontLeft = new Encoder(3,5, false,Encoder.EncodingType.k4X);
	// public Encoder backLeft = new Encoder(6,7, false,Encoder.EncodingType.k4X); 
	 
	 public void resetEncoders() {
		 //frontRight.reset();
		 //backRight.reset();
		 //frontLeft.reset();
		 //backLeft.reset();
	 }
	 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
    
    public void DriveMe (Joystick stick) { 
    	double max = 0.5;
    	double x = stick.getX()*max;
    	double y = stick.getY()*max;
    	double z = stick.getZ()*max;
    	
    	myRobotDrive.mecanumDrive_Cartesian(0,0,0,0); 	   	
    }
    public void DriveMe(float speed) {
    	myRobotDrive.mecanumDrive_Cartesian(speed,0,0,0); 	   	
    }
        
    public void StopMe () {
    	myRobotDrive.drive(0, 0);
    }

	}


