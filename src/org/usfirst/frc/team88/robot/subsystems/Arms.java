package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.MoveArmsWithController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arms extends Subsystem {
    
	private final CANTalon armTalon1;
	private final CANTalon armTalon2;

	public Arms() {
		armTalon1 = new CANTalon(RobotMap.intakeArmMotor1);
		armTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		armTalon2 = new CANTalon(RobotMap.intakeArmMotor2);
		armTalon2.changeControlMode(CANTalon.TalonControlMode.Follower);
		armTalon2.set(armTalon1.getDeviceID());
	}

	public void moveArms (double voltage){
		armTalon1.set(voltage);
		
		SmartDashboard.putNumber("Arm Master Voltage: ", armTalon1.getOutputVoltage());
		SmartDashboard.putNumber("Arm Master Current: ", armTalon1.getOutputCurrent());
		SmartDashboard.putNumber("Arm Slave Voltage: ", armTalon2.getOutputVoltage());
		SmartDashboard.putNumber("Arm Slave Current: ", armTalon2.getOutputCurrent());
	}
	
	
    public void initDefaultCommand() {
		setDefaultCommand(new MoveArmsWithController());
    }
}

