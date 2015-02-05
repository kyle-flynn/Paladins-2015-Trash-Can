package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.OI;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class TotePusherSubsystem extends Subsystem {
    
	private Solenoid pusherSolenoid = new Solenoid(OI.pusherSolenoidPort);//Single acting
	//Activate and hold to push on, let go to pull back
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	pusherSolenoid.set(false);
    }
    
    public void operate(Joystick drewStick)
    {
    	while(drewStick.getRawButton(OI.pusherButton)){//Button 3
    		pusherSolenoid.set(true);
    	}
    	pusherSolenoid.set(false);
    }
}

