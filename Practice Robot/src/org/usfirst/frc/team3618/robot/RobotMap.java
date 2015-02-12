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
	
	//public static int LEFT_LIFT_MOTOR = 5;
	
	
	
	//PWM
	
	public static int LEFT_FRONT_DRIVE_MOTOR = 0;
	public static int LEFT_REAR_DRIVE_MOTOR = 1;
	//2 not defined at this moment
	public static int LEFT_LIFT_MOTOR = 3;
	public static int RIGHT_REAR_DRIVE_MOTOR = 4;
	public static int RIGHT_FRONT_DRIVE_MOTOR = 5;
	public static int RIGHT_LIFT_MOTOR = 6;
	//7 not defined at this moment
	public static int LAWRENCE_SHOULDER_MOTOR = 8;
	public static int LAWRENCE_ELBOW_MOTOR = 9;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Solenoids
					//tote clamp double solenoids ->
		public static int LEFT_TOTE_ARM_CLAMP_IN = 1;
		public static int LEFT_TOTE_ARM_CLAMP_OUT = 0;
		public static int RIGHT_TOTE_ARM_CLAMP_IN = 3;
		public static int RIGHT_TOTE_ARM_CLAMP_OUT = 2;
					//tote arm Double Solenoids ->
		public static int LEFT_TOTE_ARM_OUT = 5;
		public static int LEFT_TOTE_ARM_IN = 6;
		public static int RIGHT_TOTE_ARM_OUT = 7;
		public static int RIGHT_TOTE_ARM_IN = 0;
					//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//DIO
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
}
