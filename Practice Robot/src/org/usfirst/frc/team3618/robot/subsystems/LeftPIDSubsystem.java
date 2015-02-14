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
public class LeftPIDSubsystem extends PIDSubsystem {

	Talon leftLiftTalon = new Talon(RobotMap.LEFT_LIFT_MOTOR);
	public Encoder leftLiftEncoder = new Encoder(RobotMap.LEFT_LIFT_A,
			 RobotMap.LEFT_LIFT_B);
	//public DigitalInput tLimitSwitch = new DigitalInput(RobotMap.TOP_LEFT_LIMIT);
	public DigitalInput bLimitSwitch = new DigitalInput(RobotMap.BOTTOM_LEFT_LIMIT);
	
	public boolean hasReset;
	
    // Initialize your subsystem here
    public LeftPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	super("LeftLiftSubsystem", 0.0025*0.9, 0.0002, 0.0);
    	
    	setAbsoluteTolerance(0.5*Robot.countsPerInch);
    	setInputRange(0.0, 41.0*Robot.countsPerInch);
    	
    	hasReset = false;
    }
    
  
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return leftLiftEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if(hasReset || !getPIDController().isEnable()) {
	    	double MaxOutput = 0.35;
	    	if(output < 0 && bLimitSwitch.get()) {
	    		output = 0;
	    		leftLiftEncoder.reset();
	    		Robot.currentLevel = 0;
	    		hasReset = true;
	    	}
	    	if (output > MaxOutput) {
	    		output = MaxOutput;    		
	    	} else if (output < -MaxOutput) {
	    		output = -MaxOutput;
	    	}
	    	leftLiftTalon.set(output);
    	}
    }
    
    public void jog(double output){
    	disable();
    	usePIDOutput(output);
    }
    
    public void stop(){
    	leftLiftTalon.set(0);
    }
    
    public void levelUp(){
    	if (Robot.currentLevel < 4) {
    		Robot.currentLevel++;   
    	}
    }
    
    public void levelDown(){
    	if (Robot.currentLevel > 0) {
    		Robot.currentLevel--;
    	}
    }
    
    @Override
    public boolean onTarget() {
    	double error = getSetpoint() - leftLiftEncoder.get();
    	
    	if(Math.abs(error) <= 0.4*Robot.countsPerInch) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}
