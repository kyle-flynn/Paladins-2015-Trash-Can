package org.usfirst.frc.team3618.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team3618.robot.OI;
import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class LiftSubsystem extends Subsystem{
	
	/*There are two motors operating the lift. The on on the left must spin counterclockwise to lift
	The one on the right must spin clockwise to lift.
	Clockwise is a positive value to the talon, counterclockwise negative
	*/
	
	private Talon leftTalon;
	private Talon rightTalon;
	
	private DigitalInput leftTopLimitSwitch;
	private DigitalInput rightTopLimitSwitch;
	private DigitalInput leftBottomLimitSwitch;
	private DigitalInput rightBottomLimitSwitch;
	
	public LiftSubsystem() {
		leftTalon = new Talon(RobotMap.LEFT_LIFT_TALON_PORT);
		rightTalon = new Talon(RobotMap.RIGHT_LIFT_TALON_PORT);
		leftTopLimitSwitch = new DigitalInput(OI.leftTopSwitch);
		rightTopLimitSwitch = new DigitalInput(OI.rightTopSwitch);
		leftBottomLimitSwitch = new DigitalInput(OI.leftBottomSwitch);
		rightBottomLimitSwitch = new DigitalInput(OI.rightBottomSwitch);
		
	}
	
	public void initDefaultCommand() {
		stopLift();//Safety, just for fun
	}
	
	
	
	
	
	DigitalInput limitSwitch; 
	

	//I really have no idea if this will work or not
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
	
	public void useStick(Joystick stick)
	{
		//I am hoping like all hell that .getY() returns from -1 to 1
		double power = stick.getY();
		leftTalon.set(-1 * power);//Must turn counterclockwise to lift
		rightTalon.set(power);//Must turn clockwise to lift
	}
	
	public void operateLift(Joystick liftStick)
	{
		//Code that calls stop, up, down, etc.
		if(leftTopLimitSwitch.get() ||
		   rightTopLimitSwitch.get() ||
		   leftBottomLimitSwitch.get() ||
		   rightBottomLimitSwitch.get()){
			//If a limit is hit
			stopLift();
			liftStick.setRumble(Joystick.RumbleType.kLeftRumble, 1);
			try{
				liftStick.wait(3);
			} catch(InterruptedException i){
				//Idk what to do if this happens or if it will
			}
		}else {
			while(liftStick.getRawButton(OI.triggerLiftOn)){
				useStick(liftStick);
			}
			//If the button is not pressed
			stopLift();
		}
	}

}
