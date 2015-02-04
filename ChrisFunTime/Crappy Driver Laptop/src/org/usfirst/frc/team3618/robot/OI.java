package org.usfirst.frc.team3618.robot;


import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public static Joystick driveStick = new Joystick(0);//Weston's joystick, make sure it's in zero spot
	public static Joystick bigStick = new Joystick(1);//Drew's joystick, goes in one spot
	public static Joystick launchPad = new Joystick(2);//The buttons affiliated with the launchpad
	
	public static int BadassSwitch = 8;
	public static int BigBlue = 10;
	public static int BigWhite = 11;
	public static int TopButton = 6;
	public static int BottomButton = 7;
	
	
	
	
	
	public static int liftUpButton = RobotMap.LIFT_UP_BUTTON;
	public static int liftDownButton = RobotMap.LIFT_UP_BUTTON;
	public static int triggerLiftOn = RobotMap.TRIGGER_LIFT_ON;
	
	public static int clampButton = RobotMap.CLAMP_UP_DOWN_BUTTON;
	public static int leftPushSolenoidPort = RobotMap.LEFT_PUSH_SOLENOID;
	public static int leftPullSolenoidPort = RobotMap.LEFT_PULL_SOLENOID;
	public static int rightPushSolenoidPort = RobotMap.RIGHT_PUSH_SOLENOID;
	public static int rightPullSolenoidPort = RobotMap.RIGHT_PULL_SOLENOID;
	
	public OI() {
	}
	
}

