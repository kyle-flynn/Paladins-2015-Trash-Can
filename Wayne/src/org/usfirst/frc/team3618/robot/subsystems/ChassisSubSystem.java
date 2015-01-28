
package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChassisSubSystem extends Subsystem {
    CANJaguar fL = new CANJaguar(RobotMap.frontLeftMotor);
    CANJaguar rL = new CANJaguar(RobotMap.rearLeftMotor);
    CANJaguar fR = new CANJaguar(RobotMap.frontRightMotor);
    CANJaguar rR = new CANJaguar(RobotMap.rearRightMotor);
	
    // define standard 4 PWM output controlled motors, no feedback
	RobotDrive drive = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.rearLeftMotor,
			                          RobotMap.frontRightMotor,RobotMap.rearRightMotor); 
	
	public ChassisSubSystem() {
	    fL.setCurrentMode(CANJaguar.kQuadEncoder,
	    		          RobotMap.ENCODER_PULSES_PER_REVOLUTION,
	    		          RobotMap.KP,RobotMap.KI,RobotMap.KD);
	    fL.enableControl(); // turn on PID loop
	    // do all 4 motors!
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
        
}
