package org.usfirst.frc.team88.robot.commands;

import org.usfirst.frc.team88.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HookDeliverySystemWithController extends Command {

    public HookDeliverySystemWithController() {
    	requires(Robot.hookDeliverySystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angleSpeed = Robot.oi.getOperatorRightVerticalAxis();
    	double HDSSpeed = Robot.oi.getOperatorZAxis();
    	
    	angleSpeed = Robot.oi.applyDeadZone(angleSpeed);
    	HDSSpeed = Robot.oi.applyDeadZone(HDSSpeed);
    	
    	Robot.hookDeliverySystem.moveAngle(angleSpeed);
    	Robot.hookDeliverySystem.moveHDS(HDSSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
