package org.usfirst.frc.team88.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team88.robot.Robot;
import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.Distance;

import edu.wpi.first.wpilibj.AnalogInput;
/**
 *
 */
public class DistanceTracking extends Subsystem {
	
	private final AnalogInput irSensor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DistanceTracking(){
		irSensor = new AnalogInput(RobotMap.irSensor);
		
	}

	public double getDistance() {
    	SmartDashboard.putNumber("IR sensor value: ", irSensor.getValue());
    	SmartDashboard.putNumber("IR sensor voltage: ", irSensor.getVoltage());
    	SmartDashboard.putNumber("IR sensor average voltage: ", irSensor.getAverageVoltage());
		
    	return ( 4.95 / irSensor.getAverageVoltage()) - 0.42;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Distance());
    }
}

