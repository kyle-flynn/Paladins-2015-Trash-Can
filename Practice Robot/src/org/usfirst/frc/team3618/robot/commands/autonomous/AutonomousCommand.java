package org.usfirst.frc.team3618.robot.commands.autonomous;

import org.usfirst.frc.team3618.robot.commands.ClampCommand;
import org.usfirst.frc.team3618.robot.commands.MoveToLevelCommand;
import org.usfirst.frc.team3618.robot.commands.UnclampCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
    
    public  AutonomousCommand(int selection) {
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	if (selection == 1){
    		addSequential(new AutonDriveCommand(.3, .0), 2.0);
    		end();
    		
    	}
    	
    	else if (selection == 2){
    		addSequential(new ClampCommand());
    		addSequential(new MoveToLevelCommand(true));
    		addSequential(new MoveToLevelCommand(true));
    		//Might be an issue since we haven't gone down yet
    		addSequential(new AutonDriveCommand(0, .4, 90));
    		addSequential(new AutonDriveCommand(.5, 0), 2.5);
    		addSequential(new MoveToLevelCommand(false));
    		addSequential(new MoveToLevelCommand(false));
    		addSequential(new UnclampCommand());
    		end();    		
    	}
    	
    	else if (selection == 3){
    		
    	}
    	
    	else if (selection == 4){
    		
    	}
    	
    	
    		
    }
}
