package org.usfirst.frc.team3618.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3618.robot.commands.DriveCommand;
import org.usfirst.frc.team3618.robot.commands.LiftDownCommand;
import org.usfirst.frc.team3618.robot.commands.LiftUpCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick stick = new Joystick (1);
	
	public Button liftUp = new JoystickButton(stick, 4);
	public Button liftDown = new JoystickButton(stick, 3);
	
public OI(){
	liftUp.whileHeld(new LiftUpCommand());
	liftDown.whileHeld(new LiftDownCommand());
}
	
	
	
}

