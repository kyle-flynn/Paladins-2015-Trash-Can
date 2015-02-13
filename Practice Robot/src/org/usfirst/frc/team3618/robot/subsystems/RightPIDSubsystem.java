package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.Robot;
import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class RightPIDSubsystem extends PIDSubsystem {

	Talon rightLiftTalon = new Talon(RobotMap.RIGHT_LIFT_MOTOR);
	public Encoder rightLiftEncoder = new Encoder(RobotMap.RIGHT_LIFT_A,
			  RobotMap.RIGHT_LIFT_B);
	public DigitalInput tLimitSwitch = new DigitalInput(RobotMap.TOP_RIGHT_LIMIT);
	public DigitalInput bLimitSwitch = new DigitalInput(RobotMap.BOTTOM_RIGHT_LIMIT);
	
	
    // Initialize your subsystem here
    public RightPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	super("RightLiftSubsystem", 1.0, 0.0, 0.0);
    	setSetpoint(Robot.liftSubsystem.countsAtLevel(0));
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return rightLiftEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if(output < 0 && bLimitSwitch.get())
    		output = 0;
    	if(output > 0 && tLimitSwitch.get())
    		output = 0;
    	 rightLiftTalon.set(output);
    	
    }
    
    public void jog(double output){
    	disable();
    	rightLiftTalon.set(output);
    }
    
    public void stop(){
    	rightLiftTalon.set(0);
    }
}
