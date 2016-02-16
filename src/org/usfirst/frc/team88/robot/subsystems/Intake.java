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
	private final AnalogInput intakeSensor;

	public Intake() {
		intakeTalon = new CANTalon(RobotMap.intakeMotor);
		intakeTalon.enableBrakeMode(true);
		intakeTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		intakeSensor = new AnalogInput(RobotMap.nestSensor);
	}

	public void go (double voltage) {
		intakeTalon.set(voltage);
		
		SmartDashboard.putNumber("Intake Voltage: ", intakeTalon.getOutputVoltage());
		SmartDashboard.putNumber("Intake Current: ", intakeTalon.getOutputCurrent());
	}
	
	public double getDistance() {
    	SmartDashboard.putNumber("IR sensor value: ", intakeSensor.getValue());
    	SmartDashboard.putNumber("IR sensor voltage: ", intakeSensor.getVoltage());
    	SmartDashboard.putNumber("IR sensor average voltage: ", intakeSensor.getAverageVoltage());
		
    	return ( 4.95 / intakeSensor.getAverageVoltage()) - 0.42;
	}
	
    public void initDefaultCommand() {
		setDefaultCommand(new IntakeWithController());
    }
}

