
package org.usfirst.frc.team3618.robot;

import org.usfirst.frc.team3618.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LawrenceSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LeftPIDSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.RightPIDSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.ToteArmSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.TotePusherSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static final VisionSubsystem visionSubsystem = new VisionSubsystem();
	public static final TotePusherSubsystem totePusherSubsystem = new TotePusherSubsystem();
	public static final ToteArmSubsystem toteArmSubsystem = new ToteArmSubsystem();
	public static final RightPIDSubsystem rightPIDSubsystem = new RightPIDSubsystem();
	public static final LeftPIDSubsystem leftPIDSubsystem = new LeftPIDSubsystem();
	public static final LawrenceSubsystem lawrenceSubsystem = new LawrenceSubsystem();
	public static OI oi;
	
	
	public static int currentLevel = 0;
	public static double countsPerInch = 102.7492;
	

	// Power Distribution Panel instance for seeing current
	private PowerDistributionPanel pdp;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		// Creating instances of objects
    	oi = new OI();
    	pdp = new PowerDistributionPanel(); 
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
     
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
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
        
        // PDP Values are being sent to SmartDashboard constantly
        SmartDashboard.putNumber("PDP Total Current", pdp.getTotalCurrent());
        SmartDashboard.putNumber("Motor 2 Current (Elbow)", pdp.getCurrent(0));
        SmartDashboard.putNumber("Motor 3 Current (Left Lift)", pdp.getCurrent(1));
        SmartDashboard.putNumber("Motor 0 Current (LF Drive)", pdp.getCurrent(2));
        SmartDashboard.putNumber("Motor 1 Current (LR Drive)", pdp.getCurrent(3));
        SmartDashboard.putNumber("Motor 5 Current (RF Drive)", pdp.getCurrent(12));
        SmartDashboard.putNumber("Motor 4 Current (RR Drive)", pdp.getCurrent(13));
        SmartDashboard.putNumber("Motor 7 Current (Shoulder)", pdp.getCurrent(14));
        SmartDashboard.putNumber("Motor 6 Current (Right Lift)", pdp.getCurrent(15));
        
        SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());  
        SmartDashboard.putBoolean(
        		"BottomLeftLimit", Robot.leftPIDSubsystem.bLimitSwitch.get());
        SmartDashboard.putBoolean(
        		"BottomRightLimit", Robot.rightPIDSubsystem.bLimitSwitch.get());
        SmartDashboard.putNumber(
        		"LeftEncoder", Robot.leftPIDSubsystem.leftLiftEncoder.get());
        SmartDashboard.putNumber(
        		"RightEncoder", Robot.rightPIDSubsystem.rightLiftEncoder.get());
        
        SmartDashboard.putNumber("PID Current Level", currentLevel);
        SmartDashboard.putNumber("PID Setpoint", leftPIDSubsystem.getSetpoint());
        //Periodic methods are called once every 20ms (50Hz) and that equates to 50 cycles per 1 second
        
        SmartDashboard.putData("Left Lift", leftPIDSubsystem.getPIDController());
        SmartDashboard.putData("Right  Lift", rightPIDSubsystem.getPIDController());
        
        SmartDashboard.putNumber("ShoulderEncoder", Robot.lawrenceSubsystem.shoulderEncoder.get());
        SmartDashboard.putNumber("Elbow Encoder", Robot.lawrenceSubsystem.elbowEncoder.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
