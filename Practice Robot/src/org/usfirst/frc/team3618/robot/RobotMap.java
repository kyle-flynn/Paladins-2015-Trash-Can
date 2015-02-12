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
	public static int LAWRENCE_SHOULDER_MOTOR = 2;
	public static int LEFT_LIFT_MOTOR = 3;
	public static int RIGHT_REAR_DRIVE_MOTOR = 4;
	public static int RIGHT_FRONT_DRIVE_MOTOR = 5;
	public static int RIGHT_LIFT_MOTOR = 6;
	public static int LAWRENCE_ELBOW_MOTOR = 7;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
					//Tote pusher solenoid 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//DIO
		//Limit Switches
	//public static int TOP_RIGHT_LIMIT = 0;
	//public static int TOP_LEFT_LIMIT = 1;
	public static int BOTTOM_LEFT_LIMIT = 2;
	public static int BOTTOM_RIGHT_LIMIT = 3;
		//Encoders
	public static int FRONT_LEFT_WHEEL_A = 4;	
	public static int FRONT_LEFT_WHEEL_B = 5;
	public static int FRONT_RIGHT_WHEEL_A = 6;
	public static int FRONT_RIGHT_WHEEL_B = 7;
	public static int REAR_LEFT_WHEEL_A = 8;  
	public static int REAR_LEFT_WHEEL_B = 9;
	public static int REAR_RIGHT_WHEEL_A = 0;
	public static int REAR_RIGHT_WHEEL_B = 1;
	public static int LAWRENCE_SHOULDER_A = 2;
	public static int LAWRENCE_SHOULDER_B = 3;
	public static int LAWRENCE_ELBOW_A = 4;
	public static int LAWRENCE_ELBOW_B = 5;
	public static int LEFT_LIFT_A = 6;
	public static int LEFT_LIFT_B = 7;
	public static int RIGHT_LIFT_A = 8;
	public static int RIGHT_LIFT_B = 9;
	
	
		
	
	
	
	
	
}
