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
	//public DigitalInput tLimitSwitch = new DigitalInput(RobotMap.TOP_RIGHT_LIMIT);
	public DigitalInput bLimitSwitch = new DigitalInput(RobotMap.BOTTOM_RIGHT_LIMIT);
	
	
    // Initialize your subsystem here
    public RightPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("RightLiftSubsystem", 0.0025, 0.0, 0.0);
    	
    	setAbsoluteTolerance(0.5*Robot.countsPerInch);
    	setInputRange(0.0, 41.0*Robot.countsPerInch);
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
    	
    	if(output < 0 && bLimitSwitch.get()) {
    		output = 0;
    		rightLiftEncoder.reset();
    	}
    	//if(output > 0 && tLimitSwitch.get())
    		//output = 0;
    	output = -output; // make 'down' negative
    	 rightLiftTalon.set(output);
    	
    }
    
    public void jog(double output){
    	disable();
    	usePIDOutput(output);
    }
    
    public void stop(){
    	rightLiftTalon.set(0);
    }
}
