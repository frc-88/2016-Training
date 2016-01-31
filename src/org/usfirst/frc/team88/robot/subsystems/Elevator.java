package org.usfirst.frc.team88.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.ElevatorWithController;

import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
public class Elevator extends Subsystem {
    
	private final CANTalon elevatorTalon;
	
	public Elevator(){
		elevatorTalon = new CANTalon(RobotMap.elevatorMotor);
	}
	
	public void releaseElevator(double speed){
		elevatorTalon.set(speed);
		
		SmartDashboard.putNumber("Elevator Voltage: ", elevatorTalon.getOutputVoltage());
		SmartDashboard.putNumber("Elevator Current: ", elevatorTalon.getOutputCurrent());
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorWithController());
    }
}

