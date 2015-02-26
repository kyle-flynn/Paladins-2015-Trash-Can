
package org.usfirst.frc.team3618.robot;

import org.usfirst.frc.team3618.robot.commands.MoveToLevelCommand;
import org.usfirst.frc.team3618.robot.commands.autonomous.AutonomousCommand;
import org.usfirst.frc.team3618.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LawrenceSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.LeftPIDSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.ClampSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.RightPIDSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.ToteArmSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.TotePusherSubsystem;
import org.usfirst.frc.team3618.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	public static final ClampSubsystem liftSubsystem = new ClampSubsystem();
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
	private int lastPress = -1; // no press active
	
	private SendableChooser autoChooser;
	private SendableChooser averagingChooser;
	private Command autonomousCommand;
	
    private BuiltInAccelerometer accel = new BuiltInAccelerometer();
    private Timer timer = new Timer();
    private double lastTime = 0.0;
    private double averageX = 0.0;
    private double averageY = 0.0;
    private double averageZ = 0.0;
    private int numSamples = 0;
    private boolean averaged = false;
    private double xSum = 0;
    private double ySum = 0;
    private double zSum = 0;
    private int lastChooser = 0;
    private double xDist = 0;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code. */
   	
	public void robotInit() {
		// Creating instances of objects
    	oi = new OI();
    	pdp = new PowerDistributionPanel(); 

        accel.setRange(Accelerometer.Range.k2G);
    	timer.start();

    	autoChooser = new SendableChooser();
    	autoChooser.addDefault("Drive Forward Only", 1);
    	autoChooser.addObject("One to Score", 2);
    	autoChooser.addObject("2 Totes", 3);
    	autoChooser.addObject("3 Totes", 4);
    	SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);

    	averagingChooser = new SendableChooser();
    	averagingChooser.addDefault("Use Average offset", 1);
    	averagingChooser.addObject("Use no offset", 2);
    	SmartDashboard.putData("AveragingChooser", averagingChooser);
	}
	
	
	public void disabledPeriodic() {
		double thisTime = timer.get();
		double elapsed = thisTime - lastTime;
		lastTime = thisTime;
		double x = accel.getX();
		double y = accel.getY();
		double z = accel.getZ();
		if (thisTime < 15.0) {
			SmartDashboard.putString("Timing", "Averaging...");
			numSamples++;
			averageX += x;
			averageY += y;
			averageZ += z;
		}
		else {
			if (!averaged) {
				averageX /= numSamples;
				averageY /= numSamples;
				averageZ /= numSamples;
				SmartDashboard.putNumber("AvgX", averageX);
				SmartDashboard.putNumber("AvgY", averageY);
				SmartDashboard.putNumber("AvgZ", averageZ);
				averaged = true;
			}

			// Determine average values, with the stationary values removed
			int thisChooser = (int)averagingChooser.getSelected();
			if (thisChooser != lastChooser) {
				xSum = ySum = zSum = xDist = 0;
				lastChooser = thisChooser;
			}
			if (lastChooser == 1) {
				x -= averageX;
				y -= averageY;
				z -= averageZ;
			}
			// else we get the raw values in x, y, z - no offset

			SmartDashboard.putNumber("X", x);

			// So now, lets figure out the sum of movement
			// 1.0 is 1g = 9.8 m/s/s = 386.22047 in/s^2
			xSum += x*elapsed; // Current speed (m/s) is the sum of the accelerations measured: (g)*s yields m/s
			ySum += y*elapsed;
			zSum += z*elapsed;
			SmartDashboard.putNumber("Xsum", xSum);

			
			xDist += xSum*elapsed*39.37; // m/s * s yields m

			SmartDashboard.putString("Timing", Double.toString(thisTime));
			SmartDashboard.putNumber("Ysum", ySum);
			SmartDashboard.putNumber("Zsum", zSum);
			SmartDashboard.putNumber("X inches", xDist);
			SmartDashboard.putNumber("elapsed",elapsed);
		}
	
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = new AutonomousCommand((int) autoChooser.getSelected());
    	autonomousCommand.start();
    	timer.reset();
     
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
//		Compressor c = new Compressor();
//		
//		c.stop();
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
        
        SmartDashboard.putBoolean("Awful Left Encoder?", Robot.leftPIDSubsystem.isMyEncoderAwful);
        SmartDashboard.putBoolean("Awful Right Encoder?", Robot.rightPIDSubsystem.isMyEncoderAwful);
        
        int thisPress = oi.DrewsXBoxController.getPOV();
        SmartDashboard.putNumber("This press", thisPress);
        if(thisPress != lastPress) {
        	Command move;
        	if (thisPress == 0) {
        		move = new MoveToLevelCommand(true);
        		move.start();
        	}else if(thisPress == 180){
	        	move = new MoveToLevelCommand(false);
	        	move.start();
        	}
            lastPress = thisPress;
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
