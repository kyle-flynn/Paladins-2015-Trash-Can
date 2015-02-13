package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TotePusherSubsystem extends Subsystem {
	
	DoubleSolenoid TotePusherSolenoid = new DoubleSolenoid(RobotMap.TOTE_PUSHER_IN, RobotMap.TOTE_PUSHER_OUT); 
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pushOut(){
    	TotePusherSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void pushIn(){
    	TotePusherSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}

