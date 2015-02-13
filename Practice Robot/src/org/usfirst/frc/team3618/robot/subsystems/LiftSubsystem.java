package org.usfirst.frc.team3618.robot.subsystems;

import org.usfirst.frc.team3618.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends PIDSubsystem {
    
	
	DoubleSolenoid Arms = new DoubleSolenoid(RobotMap.TOTE_ARM_CLAMP_IN,RobotMap.TOTE_ARM_CLAMP_OUT);
	public DigitalInput tlLimitSwitch = new DigitalInput(RobotMap.TOP_RIGHT_LIMIT);
	public DigitalInput trLimitSwitch = new DigitalInput(RobotMap.TOP_LEFT_LIMIT);
	public DigitalInput blLimitSwitch = new DigitalInput(RobotMap.BOTTOM_LEFT_LIMIT);
	public DigitalInput brLimitSwitch = new DigitalInput(RobotMap.BOTTOM_RIGHT_LIMIT);
	
		
	
	public static double toteHeight = 13.0;
	//Technically totes are 12.1 inches but 13.0 gives space for error.
	public static double levelsInches[] = {0.0, 2.0, 15.0, 28.0, 41.0};
	public int currentLevel = 0;
	public static double countsPerInch = 100;
	//TODO: Find out actual counts per inch
	
	//Level 0 is fully down
	//Level 1 is 2 inches up (first tote just off of floor), 
	//Level 2 is first tote high enough to clear a second tote and so on.
	
//I used liftUp, stopLiftingUp, liftDown, and stopLiftingDown	
	
	public LiftSubsystem(){
		
		getPIDController().setContinuous(false);
		setSetpoint(levelsInches[currentLevel] * countsPerInch);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands
	
    public void initDefaultCommand() {
		//double firstTote = toteHeight[1];
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
       
    
    public void moveArmsUp() {
    	Arms.set(DoubleSolenoid.Value.kForward);
    }
    
    public void moveArmsDown() {
    	Arms.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void liftUp(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void stopLifting(){
    	leftLiftTalon.set(0);
    	rightLiftTalon.set(0);
    }
    
    public void liftDown(double output){
    	leftLiftTalon.set(-output);
    	rightLiftTalon.set(output);
    }
    
    public void levelUp(){
    	if (currentLevel < 4)
    		currentLevel++;   		
    }
    
    public void levelDown(){
    	if (currentLevel > 0)
    		currentLevel--;
    }
    
    public double countsAtLevel(int level){
    	return levelsInches[level] * countsPerInch;
    }
    

}

