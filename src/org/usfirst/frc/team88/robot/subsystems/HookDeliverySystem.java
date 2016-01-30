package org.usfirst.frc.team88.robot.subsystems;

import org.usfirst.frc.team88.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class HookDeliverySystem extends Subsystem {
	
    private final CANTalon angleTalon;
    private final CANTalon HDSTalon;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public HookDeliverySystem() {
    	angleTalon = new CANTalon(RobotMap.hookDeliverySystemAngleMotor);
    	HDSTalon = new CANTalon(RobotMap.hookDeliverySystemHDSMotor);
    }
    
    public void setAngle(double voltage) {
    	angleTalon.set(voltage);
    	
    	SmartDashboard.putNumber("Angle Voltage: ", angleTalon.getOutputVoltage());
    	SmartDashboard.putNumber("Angle Current: ", angleTalon.getOutputCurrent());
    }
    
    public void moveHDS(double voltage){
    	HDSTalon.set(voltage);
    	
    	SmartDashboard.putNumber("HDS Voltage: ", HDSTalon.getOutputVoltage());
    	SmartDashboard.putNumber("HDS Current: ", HDSTalon.getOutputCurrent());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

