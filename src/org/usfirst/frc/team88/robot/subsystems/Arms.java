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
    
	private final CANTalon armTalon;

	public Arms() {
		armTalon = new CANTalon(RobotMap.armMotorController);
		armTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	public void moveArms (double voltage){
		armTalon.set(voltage);
		
		SmartDashboard.putNumber("Arm Master Voltage: ", armTalon.getOutputVoltage());
		SmartDashboard.putNumber("Arm Master Current: ", armTalon.getOutputCurrent());
	}
	
	
    public void initDefaultCommand() {
		setDefaultCommand(new MoveArmsWithController());
    }
}

