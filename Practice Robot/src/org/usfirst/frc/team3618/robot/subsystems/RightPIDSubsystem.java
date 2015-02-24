package org.usfirst.frc.team3618.robot.subsystems;


import org.usfirst.frc.team3618.robot.Robot;
import org.usfirst.frc.team3618.robot.RobotMap;
import org.usfirst.frc.team3618.robot.commands.RightPIDDefaultCommand;

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
	
//	public double upSpeed = 0.38;
//	public double downSpeed = -0.34;

	public double upSpeed = 0.585;
	public double downSpeed = -0.575;
	
	public boolean hasReset;
	public boolean isMyEncoderAwful = false;
	
	private double lastCount = 0;
	private double lastTime = 0.0;
	
    // Initialize your subsystem here
    public RightPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("RightLiftSubsystem", 0.00125, 0.0001, 0.0);
    	
    	setAbsoluteTolerance(0.5*Robot.countsPerInch);
    	setInputRange(0.0, 41.0*Robot.countsPerInch);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RightPIDDefaultCommand()); 
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
    	if(hasReset || !getPIDController().isEnable()) {
	    	if(output < 0 && bLimitSwitch.get()) {
	    		output = 0;
	    		rightLiftEncoder.reset();
	    		isMyEncoderAwful = false;
	    		hasReset = true;
	    	}
	    	output = -output; // make 'down' negative
	    	double MaxOutput = 0.75;
	    	if (output > MaxOutput)
	    		output = MaxOutput;
	    	else if (output < -MaxOutput)
	    		output = -MaxOutput;
	   	 	rightLiftTalon.set(output);
    	}
  }
    
    public void jog(double output){
    	disable();
    	usePIDOutput(output);
    }
    
    //Testing method that should NOT be used in the code
    public void bypassPIDJog(double output) {
    	rightLiftTalon.set(output);
    }
    
    public void stop(){
    	rightLiftTalon.set(0);
    }
    
    @Override
    public boolean onTarget() {
    	double error = getSetpoint() - rightLiftEncoder.get();
    	
    	if(Math.abs(error) <= 0.4*Robot.countsPerInch) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isDeadEncoder(double time) {
    	int curCount = rightLiftEncoder.get();
    	if(curCount != lastCount) {
    		lastTime = time;
    		lastCount = curCount;
    	}
    	if ((time - lastTime) >= 0.5)
    		isMyEncoderAwful = true;
    	return isMyEncoderAwful;
    
    	
    }
    
}
