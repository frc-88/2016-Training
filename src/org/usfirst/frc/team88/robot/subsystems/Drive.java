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
	private final CANTalon lTalonMaster, lTalonSlave1, rTalonMaster, rTalonSlave1;

	public Drive() {
		// set up drive masters
		lTalonMaster = new CANTalon(RobotMap.leftMotorController1);
		lTalonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		lTalonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		rTalonMaster = new CANTalon(RobotMap.rightMotorController1);
		rTalonMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rTalonMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		// set up drive slaves
		lTalonSlave1 = new CANTalon(RobotMap.leftMotorController2);
		lTalonSlave1.changeControlMode(CANTalon.TalonControlMode.Follower);
		lTalonSlave1.set(lTalonMaster.getDeviceID());

		rTalonSlave1 = new CANTalon(RobotMap.rightMotorController2);
		rTalonSlave1.changeControlMode(CANTalon.TalonControlMode.Follower);
		rTalonSlave1.set(rTalonMaster.getDeviceID());
	}
	
	public void move (double left, double right){
		SmartDashboard.putNumber("Left Input: ", left);
		SmartDashboard.putNumber("Right Input: ", right);
				
		lTalonMaster.set(left);
		rTalonMaster.set(-right);
		
		updateSmartDashboard();
	}
	
	private void updateSmartDashboard() {
		SmartDashboard.putNumber("Left Encoder: ", lTalonMaster.getEncPosition());
		SmartDashboard.putNumber("Left Master Voltage: ", lTalonMaster.getOutputVoltage());
		SmartDashboard.putNumber("Left Master Current: ", lTalonMaster.getOutputCurrent());
		SmartDashboard.putNumber("Left Slave 1 Voltage: ", lTalonSlave1.getOutputVoltage());
		SmartDashboard.putNumber("Left Slave 1 Current: ", lTalonSlave1.getOutputCurrent());

		SmartDashboard.putNumber("Right Encoder: ", rTalonMaster.getEncPosition());
		SmartDashboard.putNumber("Right Master Voltage: ", rTalonMaster.getOutputVoltage());
		SmartDashboard.putNumber("Right Master Current: ", rTalonMaster.getOutputCurrent());
		SmartDashboard.putNumber("Right Slave 1 Voltage: ", rTalonSlave1.getOutputVoltage());
		SmartDashboard.putNumber("Right Slave 1 Current: ", rTalonSlave1.getOutputCurrent());
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithControllerOpen());
	}
}

