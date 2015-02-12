package org.usfirst.frc.team3618.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteArmSubsystem extends Subsystem {
    DoubleSolenoid leftTArm = new DoubleSolenoid(0,1);
    DoubleSolenoid rightTArm = new DoubleSolenoid(2,3);
    //CHANGE numbers before running the robot
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void rightToteArmUp() {
    	rightTArm.set(DoubleSolenoid.Value.kReverse);
        }
    public void rightToteArmDown(){
    	rightTArm.set(DoubleSolenoid.Value.kForward);
    	   		
    }
    public void leftToteArmUp(){
    	leftTArm.set(DoubleSolenoid.Value.kReverse);
    }
    public void leftToteArmDown(){
    	leftTArm.set(DoubleSolenoid.Value.kForward);
    }
}

