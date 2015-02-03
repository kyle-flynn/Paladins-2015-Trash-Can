package org.usfirst.frc.team3618.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	
	public static int LIFT_UP_BUTTON = 4;
	public static int LIFT_DOWN_BUTTON = 5;
	public static int TRIGGER_LIFT_ON = 1;//Drew's custom controls
	public static int LEFT_LIFT_TALON_PORT = 3;
	public static int RIGHT_LIFT_TALON_PORT = 6;//They are like this on the practice robot
	
	
	public static int LEFT_FRONT_DRIVE_MOTOR = 0;
	public static int LEFT_BACK_DRIVE_MOTOR = 1;
	public static int RIGHT_FRONT_DRIVE_MOTOR = 5;
	public static int RIGHT_BACK_DRIVE_MOTOR = 4;
	//These are how they are labeled on the practice robot
	
	
}
