package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.OI;
import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;


import edu.wpi.first.wpilibj.Joystick;

public class LiftSubsystem extends Subsystem{
	
	/*There are two motors operating the lift. The on on the left must spin counterclockwise to lift
	The one on the right must spin clockwise to lift.
	Clockwise is a positive value to the talon, counterclockwise negative
	*/
	
	private Talon leftTalon;
	private Talon rightTalon;
	
	private Joystick liftingStick;
	
	public LiftSubsystem() {
		leftTalon = new Talon(RobotMap.LEFT_LIFT_TALON_PORT);
		rightTalon = new Talon(RobotMap.RIGHT_LIFT_TALON_PORT);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void stopLift() {
		leftTalon.stopMotor();
		rightTalon.stopMotor();
	}
	
	public void liftUpIterative(){
		//Code to lift up lift
	}
	
	public void liftDownIterative(){
		//Code to lower lift
	}
	
	public void useStick()
	{
		//I am hoping like all hell that .getY() returns from -1 to 1
		double power = liftingStick.getY();
		leftTalon.set(-1 * power);//Must turn counterclockwise to lift
		rightTalon.set(power);//Must turn clockwise to lift
	}
	
	public void operateLift(Joystick liftStick)
	{
		//Code that calls stop, up, down, etc.
		liftingStick = liftStick;
		if(liftingStick.getRawButton(OI.liftUpButton)){//If button is pressed to increment lift
			liftUpIterative();
		}else if(liftingStick.getRawButton(OI.liftDownButton)){//If button is pressed to increment down
			liftDownIterative();
		}else if(liftingStick.getRawButton(OI.triggerLiftOn)){
			if(liftingStick.getY() == 0){//The stick is not being pressed
				stopLift();//It's not being used
			} else{
				useStick();
			}
		}
	}

}
