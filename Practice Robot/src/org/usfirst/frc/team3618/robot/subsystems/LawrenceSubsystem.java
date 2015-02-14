package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LawrenceSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Talon elbowMotor;
	private Talon shoulderMotor;
	
	public LawrenceSubsystem() {
		elbowMotor = new Talon(RobotMap.LAWRENCE_ELBOW_MOTOR);
		shoulderMotor = new Talon(RobotMap.LAWRENCE_SHOULDER_MOTOR);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void jogElbow(double output) {
    	elbowMotor.set(-output);
    }
    
    public void jogShoulder(double output) {
    	shoulderMotor.set(output);
    }
    
    public void stopMotors() {
    	elbowMotor.set(0);
    	shoulderMotor.set(0);
    }
    
}

