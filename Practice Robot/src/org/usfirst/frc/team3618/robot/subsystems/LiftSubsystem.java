package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	
	DoubleSolenoid Arms = new DoubleSolenoid(RobotMap.TOTE_ARM_CLAMP_IN,RobotMap.TOTE_ARM_CLAMP_OUT);
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	
    public void initDefaultCommand() {
		//double firstTote = toteHeight[1];
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
       
    
    public void moveArmsUp() {
    	Arms.set(DoubleSolenoid.Value.kForward);
    }
    
    public void moveArmsDown() {
    	Arms.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    

}

