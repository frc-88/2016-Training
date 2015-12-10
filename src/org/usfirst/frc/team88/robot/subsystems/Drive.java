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

	public Drive() {
		lTalonMaster = new CANTalon(RobotMap.leftMotorController);
		rTalonMaster = new CANTalon(RobotMap.rightMotorController);
		lTalonSlave = new CANTalon(RobotMap.leftMotorController2);
		rTalonSlave = new CANTalon(RobotMap.rightMotorController2);

		// set up drive slaves
		lTalonSlave.changeControlMode(CANTalon.ControlMode.Follower);
		lTalonSlave.set(lTalonMaster.getDeviceID());

		rTalonSlave.changeControlMode(CANTalon.ControlMode.Follower);
		rTalonSlave.set(rTalonMaster.getDeviceID());

	}
	
	public void move (double left, double right){
		lTalonMaster.set(left);
		rTalonMaster.set(-right);

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

