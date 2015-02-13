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
	public DigitalInput tLimitSwitch = new DigitalInput(RobotMap.TOP_LEFT_LIMIT);
	public DigitalInput bLimitSwitch = new DigitalInput(RobotMap.BOTTOM_LEFT_LIMIT);
	
    // Initialize your subsystem here
    public LeftPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	super("LeftLiftSubsystem", 1.0, 0.0, 0.0);
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
    	return leftLiftEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if(output < 0 && bLimitSwitch.get())
    		output = 0;
    	if(output > 0 && tLimitSwitch.get())
    		output = 0;
    	 leftLiftTalon.set(output);
    }
    
    public void jog(double output){
    	disable();
    	leftLiftTalon.set(output);
    }
    
    public void stop(){
    	leftLiftTalon.set(0);
    }
}
