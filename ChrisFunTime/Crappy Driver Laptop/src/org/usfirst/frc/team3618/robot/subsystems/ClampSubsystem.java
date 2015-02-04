package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.OI;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

public class ClampSubsystem extends Subsystem{
	
	Compressor airCompressor;
	Solenoid leftPullSolenoid;
	Solenoid leftPushSolenoid;
	Solenoid rightPullSolenoid;
	Solenoid rightPushSolenoid;
	
	boolean clampUp = false;
	
	public ClampSubsystem()
	{
		airCompressor = new Compressor();
		leftPullSolenoid = new Solenoid(OI.leftPullSolenoidPort);
		leftPushSolenoid = new Solenoid(OI.leftPushSolenoidPort);
		rightPullSolenoid = new Solenoid(OI.rightPullSolenoidPort);
		rightPushSolenoid = new Solenoid(OI.rightPushSolenoidPort);
	}
	
	public void initDefaultCommand()
	{
		lowerClamp();
	}
	
	public void liftClamp()
	{
		leftPushSolenoid.set(false);
		leftPullSolenoid.set(true);
		
		rightPushSolenoid.set(false);
		rightPullSolenoid.set(true);
		
		clampUp = true;
	}

	public void lowerClamp()
	{
		leftPullSolenoid.set(false);
		leftPushSolenoid.set(true);
		
		rightPullSolenoid.set(false);
		rightPullSolenoid.set(true);
		
		clampUp = false;
	}
	
	public void operateClamp()
	{
		if(OI.bigStick.getRawButton(OI.clampButton)){//If Drew presses clamp button
			if(clampUp){
				lowerClamp();
			}else{//clamp is down
				liftClamp();
			}
		}
	}
	
}
