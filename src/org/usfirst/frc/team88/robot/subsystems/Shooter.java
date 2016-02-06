package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;
import org.usfirst.frc.team88.robot.commands.ShooterWithController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private final CANTalon shooterTalon;

	public Shooter(){
		shooterTalon = new CANTalon(RobotMap.shooterMotor);
		shooterTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void fire(double voltage){
		shooterTalon.set(voltage);
		
		SmartDashboard.putNumber("Shooter Voltage: ", shooterTalon.getOutputVoltage());
		SmartDashboard.putNumber("Shooter Current: ", shooterTalon.getOutputCurrent());
		SmartDashboard.putNumber("Shooter Encoder Position: ", shooterTalon.getEncPosition());
		SmartDashboard.putNumber("Shooter Encoder Velocity: ", shooterTalon.getEncVelocity());
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterWithController());
    }
}

