package org.usfirst.frc.team3618.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VisionSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CameraServer camera;
	
	public VisionSubsystem() {
		camera = CameraServer.getInstance();
	}
	
	public void init() {
		camera.setQuality(75);
		camera.startAutomaticCapture("cam0");
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void processImage() {
    	
    }
    
}

