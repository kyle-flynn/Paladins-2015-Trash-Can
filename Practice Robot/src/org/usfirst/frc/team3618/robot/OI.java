package org.usfirst.frc.team3618.robot;

import org.usfirst.frc.team3618.robot.commands.ArmsDownCommand;
import org.usfirst.frc.team3618.robot.commands.ArmsUpCommand;
import org.usfirst.frc.team3618.robot.commands.JogDownCommand;
import org.usfirst.frc.team3618.robot.commands.JogUpCommand;
import org.usfirst.frc.team3618.robot.commands.LawrenceDeployCommand;
import org.usfirst.frc.team3618.robot.commands.LeftToteArmDownCommand;
import org.usfirst.frc.team3618.robot.commands.LeftToteArmUpCommand;
import org.usfirst.frc.team3618.robot.commands.MoveToLevelCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick stick = new Joystick (1);
	public static Joystick stick2 = new Joystick (2);
	
	public Button liftUp = new JoystickButton(stick, 4);
	public Button liftDown = new JoystickButton(stick, 5);
//	public Button pushIn = new JoystickButton(stick2, 2);    Being removed from robot
//	public Button pushOut = new JoystickButton(stick2, 3);   Being removed from robot
	public Button armsDown = new JoystickButton(stick2, 2);
	public Button armsUp = new JoystickButton(stick2, 1);
	public Button leftToteArmUp = new JoystickButton(stick2, 7);
	public Button leftToteArmDown = new JoystickButton(stick2, 6);
	public Button levelUp = new JoystickButton(stick2, 11);
	public Button levelDown = new JoystickButton(stick2, 10);
	public static Button shoulderUp = new JoystickButton(stick2,5); // used in LawrenceDefaultCommand
	public static Button shoulderDown = new JoystickButton(stick2,6); // used in LawrenceDefaultCommand
	public Button deployLawrence = new JoystickButton(stick2,3);
	
	// Drew wants stick2, button 2 to be toggle for tote clamping
	// Drew wants stick2, button 3 to be toggle for tote pushing
	
	
	// manual in/out for Elbow/Shoulder (4 buttons)
	// XBox buttons:            Functions
	//  1  A                    Clamp
	//  2  B                    UnClamp
	//  3  X                    Deploy Lawrence
	//  4  Y                    Stow Lawrence
	//  5  LeftBumper           Shoulder Up (spool)
	//  6  RightBumper          Shoulder Down (unspool)
	//  7  BACK                 
	//  8  Start                
	//  9  LeftStickClick
	// 10  RightStickClick
	//     POV 'up'             Increment Level
	//     POV 'down'           Decrement Level
	// Axes:
	//  0  Left X Axes
	//  1  Left Y Axes          Left lift jog Up/Down
	//  2  Left Trigger         Elbow Up (spool)
	//  3  Right Trigger        Elbow Down (unspool)
	//  4  Right X Axes
	//  5  Right Y Axes         Right lift jog Up/Down
	
public OI(){
	liftUp.whileHeld(new JogUpCommand());
	liftDown.whileHeld(new JogDownCommand());
//	pushIn.whenPressed(new TotePusherInCommand());
//	pushOut.whenPressed(new TotePusherOutCommand());
	armsDown.whenPressed(new ArmsDownCommand());
	armsUp.whenPressed(new ArmsUpCommand());
	leftToteArmUp.whenPressed(new LeftToteArmUpCommand());
	leftToteArmDown.whenPressed(new LeftToteArmDownCommand());
	levelUp.whenPressed(new MoveToLevelCommand(true));
	levelDown.whenPressed(new MoveToLevelCommand(false));
	deployLawrence.whenPressed(new LawrenceDeployCommand());
}
	
	
	
}

