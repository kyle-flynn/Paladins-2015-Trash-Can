package org.usfirst.frc.team3618.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TotePusherSubsystem extends Subsystem {
	
	Solenoid TotePusherSolenoid = new Solenoid(4); 
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pushOut(){
    	TotePusherSolenoid.set(true);
    }
    
    public void pushIn(){
    	TotePusherSolenoid.set(false);
    }

}

