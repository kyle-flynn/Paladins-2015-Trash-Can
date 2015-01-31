package org.usfirst.frc.team3618.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
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
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void liftUp(Joystick stick){
    	
    }
    
    public void stopLiftingUp(Joystick stick){
    	
    }
    
    public void liftDown(Joystick stick){
    	
    }
    
    public void stopLiftingDown(Joystick stick){
    	
    }
}

