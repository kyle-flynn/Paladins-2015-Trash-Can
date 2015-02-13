package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	Talon leftLiftTalon = new Talon(RobotMap.LEFT_LIFT_MOTOR);
	Talon rightLiftTalon = new Talon(RobotMap.RIGHT_LIFT_MOTOR);
	DoubleSolenoid Arms = new DoubleSolenoid(RobotMap.TOTE_ARM_CLAMP_IN,RobotMap.TOTE_ARM_CLAMP_OUT);
	public DigitalInput tlLimitSwitch = new DigitalInput(RobotMap.TOP_RIGHT_LIMIT);
	public DigitalInput trLimitSwitch = new DigitalInput(RobotMap.TOP_LEFT_LIMIT);
	public DigitalInput blLimitSwitch = new DigitalInput(RobotMap.BOTTOM_LEFT_LIMIT);
	public DigitalInput brLimitSwitch = new DigitalInput(RobotMap.BOTTOM_RIGHT_LIMIT);
	
//I used liftUp, stopLiftingUp, liftDown, and stopLiftingDown	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
       
    
    public void moveArmsUp() {
    	Arms.set(DoubleSolenoid.Value.kForward);
    }
    
    public void moveArmsDown() {
    	Arms.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void liftUp(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void stopLifting(){
    	leftLiftTalon.set(0);
    	rightLiftTalon.set(0);
    }
    
    public void liftDown(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void leftLiftUp(double output){
    	leftLiftTalon.set(-output);
    }
    
    public void stopLiftingLeftUp(){
    	leftLiftTalon.set(0);
    }
    
    public void leftLiftDown(double output){
    	leftLiftTalon.set(-output);
    }
    
    public void stopLiftingLeftDown(){
    	leftLiftTalon.set(0);
    }
    
    public void rightLiftUp(double output){
    	rightLiftTalon.set(output);
    }
    
    public void stopLiftingRightUp(){
    	rightLiftTalon.set(0);
    }
    
    public void rightLiftDown(double output){
    	rightLiftTalon.set(output);
    }
    
    public void stopLiftingRightDown(){
    	rightLiftTalon.set(0);
    }
    	
}

