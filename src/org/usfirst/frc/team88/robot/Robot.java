
package org.usfirst.frc.team88.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team88.robot.subsystems.Arms;
import org.usfirst.frc.team88.robot.subsystems.Climber;
import org.usfirst.frc.team88.robot.subsystems.Drive;
import org.usfirst.frc.team88.robot.subsystems.HookDeliverySystem;
import org.usfirst.frc.team88.robot.subsystems.Intake;
import org.usfirst.frc.team88.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Arms arms;
	public static Climber climber;
	public static Drive drive;
	public static HookDeliverySystem hookDeliverySystem;
	public static Intake intake;
	public static Shooter shooter;
	public static OI oi;
//	public static CameraServer server;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		arms = new Arms();
		climber = new Climber();
		drive = new Drive();
		hookDeliverySystem = new HookDeliverySystem();
		intake = new Intake();
		shooter = new Shooter();

		// OI should always be last so it can refer to the other subsystems
		oi = new OI();

//        server = CameraServer.getInstance();
//        server.setQuality(50);
//        //the camera name (ex "cam0") can be found through the roborio web interface
//        server.startAutomaticCapture("cam0");

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
