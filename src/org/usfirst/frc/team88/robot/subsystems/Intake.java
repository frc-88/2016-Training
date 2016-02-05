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
    
	private final CANTalon armTalon1;
	private final CANTalon armTalon2;
	private final CANTalon intakeTalon;
	private final AnalogInput intakeSensor;

	public Intake() {
		armTalon1 = new CANTalon(RobotMap.intakeArmMotor1);
		
		armTalon2 = new CANTalon(RobotMap.intakeArmMotor2);
		armTalon2.changeControlMode(CANTalon.TalonControlMode.Follower);
		armTalon2.set(armTalon1.getDeviceID());

		intakeTalon = new CANTalon(RobotMap.intakeMotor);
		intakeSensor = new AnalogInput(RobotMap.intakeSensor);
	}

	public void go (double voltage) {
		intakeTalon.set(voltage);
		
		SmartDashboard.putNumber("Intake Voltage: ", intakeTalon.getOutputVoltage());
		SmartDashboard.putNumber("Intake Current: ", intakeTalon.getOutputCurrent());
		//SmartDashboard.putNumber("Intake ", value);
	}
	
	public void moveArms (double voltage){
		armTalon1.set(voltage);
		
		SmartDashboard.putNumber("Arm Voltage: ", armTalon1.getOutputVoltage());
		SmartDashboard.putNumber("Arm Current: ", armTalon1.getOutputCurrent());
	}
	
	public double getDistance() {
    	SmartDashboard.putNumber("IR sensor value: ", intakeSensor.getValue());
    	SmartDashboard.putNumber("IR sensor voltage: ", intakeSensor.getVoltage());
    	SmartDashboard.putNumber("IR sensor average voltage: ", intakeSensor.getAverageVoltage());
		
    	return ( 4.95 / intakeSensor.getAverageVoltage()) - 0.42;
	}
	
    public void initDefaultCommand() {

    }
}

