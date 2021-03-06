package org.usfirst.frc.team88.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

// Drive
	// encoders on masters
	public static int driveLeftMaster=1;
	public static int driveLeftSlave=2;

	public static int driveRightMaster=6;
	public static int driveRightSlave=8;

// Intake
	public static int intakeMotor = 4;
	public static int shooterMotor = 3;
    // light sensor switch to known when boulder is in the nest
	public static int lowerNestSensor = 0;
	public static int upperNestSensor = 1;

	
// Arms
	public static int armMotorController = 9;
	// encoder to know angle of arms

// HDS - Hook Delivery System
	public static int hdsElevatorMotorController = 5;
	public static int hdsAngleMotorController = 7;
	// switch to determine if hook is on bar, limit switch? 
	// encoder on angle motor
	
// Climber
    public static final int climberSolenoidIn = 0;
    public static final int climberSolenoidOut = 1;
	// some mechanism to release clock springs, solenoid?
	// or, alternatively, one motor to run winch
	
// Camera
	public static String cameraName = "cam0";
	
// Shooter ???

// CatABuster ???	
}
