package org.usfirst.frc.team3618.robot;

import org.usfirst.frc.team3618.robot.commands.ArmsDownCommand;
import org.usfirst.frc.team3618.robot.commands.ArmsUpCommand;
import org.usfirst.frc.team3618.robot.commands.LeftToteArmDownCommand;
import org.usfirst.frc.team3618.robot.commands.LeftToteArmUpCommand;
import org.usfirst.frc.team3618.robot.commands.LiftDownCommand;
import org.usfirst.frc.team3618.robot.commands.LiftUpCommand;
import org.usfirst.frc.team3618.robot.commands.RightToteArmDownCommand;
import org.usfirst.frc.team3618.robot.commands.RightToteArmUpCommand;
import org.usfirst.frc.team3618.robot.commands.TotePusherInCommand;
import org.usfirst.frc.team3618.robot.commands.TotePusherOutCommand;

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
	public static Joystick launchpad = new Joystick (3);
	
	public Button liftUp = new JoystickButton(stick, 4);
	public Button liftDown = new JoystickButton(stick, 3);
	public Button pushIn = new JoystickButton(stick, 9);
	public Button pushOut = new JoystickButton(stick, 10);
	public Button armsDown = new JoystickButton(stick, 1);
	public Button armsUp = new JoystickButton(stick, 2);
	public Button rightToteArmUp = new JoystickButton(stick2, 1);
	public Button leftToteArmUp = new JoystickButton(stick2, 2);
	public Button rightToteArmDown = new JoystickButton(stick2, 3);
	public Button leftToteArmDown = new JoystickButton(stick2, 4);
	
public OI(){
	liftUp.whileHeld(new LiftUpCommand());
	liftDown.whileHeld(new LiftDownCommand());
	pushIn.whenPressed(new TotePusherInCommand());
	pushOut.whenPressed(new TotePusherOutCommand());
	armsDown.whenPressed(new ArmsDownCommand());
	armsUp.whenPressed(new ArmsUpCommand());
	rightToteArmUp.whenPressed(new RightToteArmUpCommand());
	leftToteArmUp.whenPressed(new LeftToteArmUpCommand());
	rightToteArmDown.whenPressed(new RightToteArmDownCommand());
	leftToteArmDown.whenPressed(new LeftToteArmDownCommand());
	
	
}
	
	
	
}

