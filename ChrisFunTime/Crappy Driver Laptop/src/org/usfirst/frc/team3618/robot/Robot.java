
package org.usfirst.frc.team3618.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3618.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.ClampSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
	public static final LiftSubsystem liftSubsystem = new LiftSubsystem();
	public static final ClampSubsystem clampSubsystem = new ClampSubsystem();
	public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        chassisSubsystem.driveMe(OI.driveStick);
        liftSubsystem.operateLift(OI.bigStick);
        
        Joystick launchPad = OI.launchPad;
        if(launchPad.getRawButton(OI.BadassSwitch)){
        	chassisSubsystem.drive.mecanumDrive_Cartesian(.5, -.5, 0.0, 0.0);
        	System.out.println("Switch hit.");
        }
        if(launchPad.getRawButton(OI.BigBlue)){
        	System.out.println("Big Blue.");
        }
        if(launchPad.getRawButton(OI.BigWhite)){
        	System.out.println("Big White.");
        }
        if(launchPad.getRawButton(OI.TopButton)){
        	System.out.println("Top Button.");
        }
        if(launchPad.getRawButton(OI.BottomButton)){
        	System.out.println("Bottom Button.");
        }
        
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
