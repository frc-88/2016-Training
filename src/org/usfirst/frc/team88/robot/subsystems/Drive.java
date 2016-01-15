package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.DriveWithControllerOpen;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Subsystem {
	private final CANTalon lTalonMaster, lTalonSlave, rTalonMaster, rTalonSlave;

	// PID constants
	private final static double P = 1.0;
	private final static double I = 0.002;
	private final static double D = 0.0;
	
	private final static double MAX_SPEED = 35.0;
	
	public Drive() {
		lTalonMaster = new CANTalon(RobotMap.leftMotorController);
		lTalonMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		lTalonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		lTalonMaster.setPID(P, I, D);

		rTalonMaster = new CANTalon(RobotMap.rightMotorController);
		rTalonMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		rTalonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rTalonMaster.setPID(P, I, D);

		// set up drive slaves
		lTalonSlave = new CANTalon(RobotMap.leftMotorController2);
		lTalonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		lTalonSlave.set(lTalonMaster.getDeviceID());

		rTalonSlave = new CANTalon(RobotMap.rightMotorController2);
		rTalonSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		rTalonSlave.set(rTalonMaster.getDeviceID());

	}
	
	public void move (double left, double right){
		left = left * MAX_SPEED;
		right = right * MAX_SPEED;
		
		lTalonMaster.set(left);
		rTalonMaster.set(right);

		updateSmartDashboard();
	}
	
	private void updateSmartDashboard() {
		SmartDashboard.putNumber("Left Encoder: ", lTalonMaster.getPosition());
		SmartDashboard.putNumber("Right Encoder: ", rTalonMaster.getPosition());
		SmartDashboard.putNumber("Left Encoder Velocity: ", lTalonMaster.getSpeed());
		SmartDashboard.putNumber("Right Encoder Velocity: ", rTalonMaster.getSpeed());
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithControllerOpen());
	}
}

