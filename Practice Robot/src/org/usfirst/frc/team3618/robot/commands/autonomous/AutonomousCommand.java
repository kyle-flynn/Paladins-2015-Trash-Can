package org.usfirst.frc.team3618.robot.commands.autonomous;

import org.usfirst.frc.team3618.robot.commands.ClampCommand;
import org.usfirst.frc.team3618.robot.commands.MoveToLevelCommand;
import org.usfirst.frc.team3618.robot.commands.ResetGyroCommand;
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
		addSequential(new ResetGyroCommand());
    	
    	switch(selection) {
	    	case 1:
	    		addSequential(new AutonDriveOrientedCommand(0.325, 0.0, 5.0), 5.0);
	    		end();
	    		break;
	    	case 4:
	    		addSequential(new ClampCommand());
	    		//addParallel(new MoveToLevelCommand(2));
	    		addSequential(new AutonDriveOrientedCommand(0.45, 90.0, 2.7)); //right
	    		
	    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 3.3));
	    		addSequential(new AutonDriveOrientedCommand(0.45, -90.0, 2.65));
	    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 1.5));
	    		addSequential(new UnclampCommand());
	    		//addSequential(new MoveToLevelCommand(0));
	    		addSequential(new TestWaitCommand(), 2.0);
	    	case 3:
	    		addSequential(new ClampCommand());
	    		// SECOND TOTE
	    		//addParallel(new MoveToLevelCommand(2));
	    		addSequential(new AutonDriveOrientedCommand(0.45, 90.0, 2.7));
	    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 3.3));
	    		addSequential(new AutonDriveOrientedCommand(0.45, -90.0, 2.65));
	    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 1.5));
	    		addSequential(new UnclampCommand());
	    		//addSequential(new MoveToLevelCommand(0));
	    		addSequential(new TestWaitCommand(), 2.0);
	    	case 2:
	    		addSequential(new ClampCommand());
	    		//addParallel(new MoveToLevelCommand(1));
	    		// THIRD TOTE EVENTUALLY
	    		addSequential(new AutonDriveOrientedCommand(0.75, 90.0, 7.0));
	    		addSequential(new UnclampCommand());
	    		addSequential(new AutonDriveOrientedCommand(0.5, 180, 2.0));
	    		break;
    	}
//    	
//    	if (selection == 1){
//    		addSequential(new ResetGyroCommand());
//    		addSequential(new AutonDriveOrientedCommand(0.325, 0.0, 5.0), 5.0);
//    		end();
//    		
//    		
//    	}
//    	
//    	else if (selection == 2){
//    		addSequential(new ResetGyroCommand());
//    		addSequential(new ClampCommand());
//    		// FIRST TOTE
//    		//addParallel(new MoveToLevelCommand(true));
//    		addSequential(new AutonDriveOrientedCommand(0.45, 90.0, 2.7)); //right
//    		//addParallel(new MoveToLevelCommand(true));
//    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 3.3));
//    		addSequential(new AutonDriveOrientedCommand(0.45, -90.0, 2.5));
//    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 1.5));
//    		addSequential(new UnclampCommand());
//    		//addSequential(new MoveToLevelCommand(false));
//    		//addSequential(new MoveToLevelCommand(false));
//    		addSequential(new TestWaitCommand(), 2.0);
//    		
//    		addSequential(new ClampCommand());
//    		// SECOND TOTE
//    		//addParallel(new MoveToLevelCommand(true));
//    		addSequential(new AutonDriveOrientedCommand(0.45, 90.0, 2.7));
//    		//addParallel(new MoveToLevelCommand(true));
//    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 3.3));
//    		addSequential(new AutonDriveOrientedCommand(0.45, -90.0, 2.5));
//    		addSequential(new AutonDriveOrientedCommand(0.5, 0.0, 1.5));
//    		//addSequential(new AutonDriveOrientedCommand(0.4, 0.0, 4.0));
//    		//addSequential(new AutonDriveOrientedCommand(0.45, 90.0, 4.0));
//    		addSequential(new UnclampCommand());
//    		//addSequential(new MoveToLevelCommand(false));
//    		//addSequential(new MoveToLevelCommand(false));
//    		addSequential(new TestWaitCommand(), 2.0);
//    		
//    		addSequential(new ClampCommand());
//    		//addParallel(new MoveToLevelCommand(true));
//    		// THIRD TOTE EVENTUALLY
//    		addSequential(new AutonDriveOrientedCommand(0.75, 90.0, 9.0));
//    		end();    		
//    	}
    	   	  	    		
    }
}
