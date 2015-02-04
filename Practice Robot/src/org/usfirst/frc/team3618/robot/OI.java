package org.usfirst.frc.team3618.robot;

import org.usfirst.frc.team3618.robot.commands.LeftLiftDownCommand;
import org.usfirst.frc.team3618.robot.commands.LeftLiftUpCommand;
import org.usfirst.frc.team3618.robot.commands.LiftDownCommand;
import org.usfirst.frc.team3618.robot.commands.LiftUpCommand;
import org.usfirst.frc.team3618.robot.commands.RightLiftDownCommand;
import org.usfirst.frc.team3618.robot.commands.RightLiftUpCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick stick = new Joystick (1);
	
	public Button liftUp = new JoystickButton(stick, 4);
	public Button liftDown = new JoystickButton(stick, 3);
	public Button rightLiftUp = new JoystickButton(stick, 5);
	public Button rightLiftDown = new JoystickButton(stick, 6);
	public Button leftLiftUp = new JoystickButton(stick, 7);
	public Button leftLiftDown = new JoystickButton(stick, 8);
	
public OI(){
	liftUp.whileHeld(new LiftUpCommand());
	liftDown.whileHeld(new LiftDownCommand());
	rightLiftUp.whileHeld(new RightLiftUpCommand());
	rightLiftDown.whileHeld(new RightLiftDownCommand());
	leftLiftUp.whileHeld(new LeftLiftUpCommand());
	leftLiftDown.whileHeld(new LeftLiftDownCommand());
	
	
}
	
	
	
}

