
package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.Robot;
import org.usfirst.frc.team3618.robot.RobotMap;
import org.usfirst.frc.team3618.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
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
	public Gyro firstGyro = new Gyro(0);
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 public ChassisSubsystem() {
	    	myRobotDrive.setInvertedMotor(MotorType.kRearRight, true);
	    	myRobotDrive.setInvertedMotor(MotorType.kFrontRight, true);
	    	firstGyro.reset();
	    	
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
    	double max = 0.75;
    	double x = stick.getX();
    	double y = stick.getY();
    	double z = stick.getZ()*max; // always 1/2 again
    	
    	myRobotDrive.mecanumDrive_Cartesian(x,y,z,Robot.chassisSubsystem.firstGyro.getAngle()); 	   	
    }
    public void DriveMe (Joystick stick, double limit) { 
    	double max = 0.75;
    	double x = stick.getX();
    	double y = stick.getY();
    	double z = stick.getZ()*max*limit; // always 1/2 again
    	
    	myRobotDrive.mecanumDrive_Cartesian(x,y,z,Robot.chassisSubsystem.firstGyro.getAngle()); 	   	
    }
    public void DriveMe(double speed, double rotation) {
    	myRobotDrive.mecanumDrive_Cartesian(0,-speed,0,rotation); 	   	
    }
        
    
    public void StopMe () {
    	myRobotDrive.drive(0, 0);
    }
    

	}


