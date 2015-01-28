package org.usfirst.frc.team3618.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// chassis needs these:
    public static final int frontLeftMotor = 0;
    public static final int rearLeftMotor = 1;
    public static final int frontRightMotor = 2;
    public static final int rearRightMotor = 3;

    public static final double DRIVE_WHEEL_DIAMETER_FEET = 0.5;
    public static final double MOTOR_TO_WHEEL_GEAR_RATIO = 12.0/30.0;
    public static final int ENCODER_PULSES_PER_REVOLUTION = 205;

    public static final double KP = 1.0; // Proportional factor
    public static final double KI = 1.0; // Integral factor
    public static final double KD = 0; // Derivative factor

    public static final int CHASSIS_ENCODER_FL = 1;
    public static final int CHASSIS_ENCODER_RL = 2;
    public static final int CHASSIS_ENCODER_FR = 3;
    public static final int CHASSIS_ENCODER_RR = 4;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
