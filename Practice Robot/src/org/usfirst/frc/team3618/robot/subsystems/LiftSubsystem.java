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
	DoubleSolenoid leftArm = new DoubleSolenoid(RobotMap.LEFT_TOTE_ARM_CLAMP_IN,RobotMap.LEFT_TOTE_ARM_CLAMP_OUT);
	DoubleSolenoid rightArm = new DoubleSolenoid(RobotMap.RIGHT_TOTE_ARM_CLAMP_IN,RobotMap.RIGHT_TOTE_ARM_CLAMP_OUT);
	public DigitalInput tlLimitSwitch = new DigitalInput(0);
	public DigitalInput trLimitSwitch = new DigitalInput(1);
	public DigitalInput blLimitSwitch = new DigitalInput(2);
	public DigitalInput brLimitSwitch = new DigitalInput(3);
	
//I used liftUp, stopLiftingUp, liftDown, and stopLiftingDown	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
       
    
    public void moveArmsUp() {
    	leftArm.set(DoubleSolenoid.Value.kForward);
    	rightArm.set(DoubleSolenoid.Value.kForward);
    }
    
    public void moveArmsDown() {
    	leftArm.set(DoubleSolenoid.Value.kReverse);
    	rightArm.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void liftUp(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void stopLiftingUp(){
    	leftLiftTalon.set(0);
    	rightLiftTalon.set(0);
    }
    
    public void liftDown(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void stopLiftingDown(){
    	leftLiftTalon.set(0);
    	rightLiftTalon.set(0);
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

