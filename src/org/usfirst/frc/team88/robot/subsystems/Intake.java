package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.IntakeWithController;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
    
	private final CANTalon intakeTalon;
	private final AnalogInput lowerNestSensor;
	private final AnalogInput upperNestSensor;

	public Intake() {
		intakeTalon = new CANTalon(RobotMap.intakeMotor);
		intakeTalon.enableBrakeMode(true);
		intakeTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		lowerNestSensor = new AnalogInput(RobotMap.lowerNestSensor);
		upperNestSensor = new AnalogInput(RobotMap.upperNestSensor);
	}

	public void go (double voltage) {
		intakeTalon.set(voltage);
		
		SmartDashboard.putNumber("Intake Voltage: ", intakeTalon.getOutputVoltage());
		SmartDashboard.putNumber("Intake Current: ", intakeTalon.getOutputCurrent());
		getLowerNestDistance();
		getUpperNestDistance();
	}
	
    private double getLowerNestDistance() {
    	double distance = ( 4.95 / lowerNestSensor.getVoltage()) - 0.42; 

    	SmartDashboard.putNumber("Lower nest value: ", lowerNestSensor.getValue());
    	SmartDashboard.putNumber("Lower nest voltage: ", lowerNestSensor.getVoltage());
    	SmartDashboard.putNumber("Lower nest average voltage: ", lowerNestSensor.getAverageVoltage());
    	SmartDashboard.putNumber("Lower nest distance: ", distance);
		
    	return distance;
	}
	
    private double getUpperNestDistance() {
    	double distance = ( 4.95 / lowerNestSensor.getVoltage()) - 0.42; 

    	SmartDashboard.putNumber("Upper nest value: ", upperNestSensor.getValue());
    	SmartDashboard.putNumber("Upper nest voltage: ", upperNestSensor.getVoltage());
    	SmartDashboard.putNumber("Upper nest average voltage: ", upperNestSensor.getAverageVoltage());
    	SmartDashboard.putNumber("Upper nest distance: ", distance);
		
    	return distance;
	}
	
    public void initDefaultCommand() {
		setDefaultCommand(new IntakeWithController());
    }
}

