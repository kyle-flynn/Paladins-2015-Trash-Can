package org.usfirst.frc.team3618.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	Talon leftLiftTalon = new Talon(3);
	Talon rightLiftTalon = new Talon(6);
	
//I used liftUp, stopLiftingUp, liftDown, and stopLiftingDown	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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

