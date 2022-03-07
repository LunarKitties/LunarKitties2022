// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
//array list
import java.util.ArrayList;

//subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//commands
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveWithController;
import frc.robot.commands.RunIntake;
import frc.robot.commands.WheelsShiftHigh;
import frc.robot.commands.WheelsShiftLow;
import frc.robot.commands.auto.DriveAuto;
import frc.robot.commands.CarriageUp;
import frc.robot.commands.ChangeOveride;
import frc.robot.commands.CarriageDown;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.ClampMid;
import frc.robot.commands.UnclampMid;
import frc.robot.commands.TestWheel;
import frc.robot.commands.auto.Auto;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  
  private final Drivetrain mDrivetrain = new Drivetrain();
  private final Intake mIntake = new Intake();
  private final WheelOfFortune mWheel = new WheelOfFortune();
  
  public XboxController xbox1 = new XboxController(0);
  public XboxController xbox2 = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    /*
    mDrivetrain.gyroCalibrate();
    mDrivetrain.gyroReset();
*/
    mDrivetrain.setDefaultCommand(
      new DriveWithController(
        mDrivetrain, 
        () -> xbox1.getLeftTriggerAxis(), 
        () -> xbox1.getRightTriggerAxis(),  
        () -> xbox1.getRightX(),
        () -> xbox1.getLeftY(),
        () -> xbox1.getRightY(),
        mDrivetrain.getConfig(),
        mDrivetrain.getMode()
      )
    );

    mIntake.setDefaultCommand(
      new RunIntake(
        mIntake,
        () -> xbox1.getLeftTriggerAxis(),
        () -> xbox1.getRightTriggerAxis(),
        () -> xbox2.getLeftTriggerAxis(),
        () -> xbox2.getRightTriggerAxis()
      )
    );
    
    

    mWheel.setDefaultCommand(
      new TestWheel(
        mWheel, 
        () -> xbox2.getRightY(),
        () -> xbox2.getRightBumper(),
        () -> xbox2.getLeftBumper(),
        () -> xbox2.getAButton(),
        () -> xbox2.getBButton()
      )
    );

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    
    new JoystickButton(xbox1, Button.kRightBumper.value).whenPressed(new WheelsShiftHigh(mDrivetrain));
    new JoystickButton(xbox1, Button.kLeftBumper.value).whenPressed(new WheelsShiftLow(mDrivetrain));
    new JoystickButton(xbox2, Button.kLeftBumper.value).whenPressed(new ChangeOveride(mDrivetrain));

    //new JoystickButton(xbox2, Button.kX.value).whenPressed(new StopWheel(mWheel));

    new JoystickButton(xbox1, Button.kB.value).whenPressed(new IntakeUp(mIntake, mWheel));
    new JoystickButton(xbox1, Button.kX.value).whenPressed(new IntakeDown(mIntake));

    new JoystickButton(xbox2, Button.kY.value).whenPressed(new CarriageUp(mIntake));
    new JoystickButton(xbox2, Button.kA.value).whenPressed(new CarriageDown(mIntake));

    
    new JoystickButton(xbox2, Button.kB.value).whenPressed(new ClampMid(mWheel));
    new JoystickButton(xbox2, Button.kX.value).whenPressed(new UnclampMid(mWheel));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new Auto(mDrivetrain, mWheel, mIntake);
    //return auto;
  }
}
