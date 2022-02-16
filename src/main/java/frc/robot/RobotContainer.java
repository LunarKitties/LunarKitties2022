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
import frc.robot.subsystems.Carriage;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//commands
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveWithController;
import frc.robot.commands.RunIntake;
import frc.robot.commands.StopWheel;
import frc.robot.commands.WheelsShiftHigh;
import frc.robot.commands.WheelsShiftLow;
import frc.robot.commands.CarriageUp;
import frc.robot.commands.CarriageDown;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.RunWheel;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.DriveAuto;
 import frc.robot.commands.RunCarriage;
 import frc.robot.commands.CarriageUpAuto;
import frc.robot.commands.ChangeConfig;
import frc.robot.commands.CarriageDownAuto;
 import frc.robot.commands.RunCarriageAuto;
 import frc.robot.commands.StopCarriage;

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
  private final Carriage mCarriage = new Carriage();
  private final WheelOfFortune mWheel = new WheelOfFortune();

  private final DriveAuto step1 = new DriveAuto(mDrivetrain, -0.5);
  
  private boolean ar = false;
  private boolean t = true;
  private boolean altAr = true;
  // private final DriveAuto step1 = new DriveAuto(mDrivetrain, 0.5);
  // private final DriveAuto step2 = new DriveAuto(mDrivetrain, 0);
  // private final DriveAuto step3 = new DriveAuto(mDrivetrain, -0.5);
 
  private final CarriageUpAuto step2 = new CarriageUpAuto(mCarriage);
  private final CarriageDownAuto step3 = new CarriageDownAuto(mCarriage);



  private SequentialCommandGroup autoStart = new SequentialCommandGroup();
  public XboxController xbox1 = new XboxController(0);
  public XboxController xbox2 = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    mDrivetrain.setDefaultCommand(
      new DriveWithController(
        mDrivetrain, 
        () -> xbox1.getLeftTriggerAxis(), 
        () -> xbox1.getRightTriggerAxis(), 
        () -> xbox1.getRightX(),
        () -> xbox1.getLeftY(),
        () -> xbox1.getRightY(),
        mDrivetrain.getConfig()
      )
    );

    mIntake.setDefaultCommand(
      new RunIntake(
        mCarriage,
        mIntake,
        () -> xbox2.getLeftTriggerAxis(),
        () -> xbox2.getRightTriggerAxis()
      )
    );

    mWheel.setDefaultCommand(
      new RunWheel(
        mWheel, 
        () -> xbox2.getLeftY()
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

    //new JoystickButton(xbox2, Button.kX.value).whenPressed(new StopWheel(mWheel));
    new JoystickButton(xbox1, Button.kB.value).whenPressed(new ChangeConfig(mDrivetrain));

    new JoystickButton(xbox1, Button.kY.value).whenPressed(new IntakeUp(mIntake));
    new JoystickButton(xbox1, Button.kX.value).whenPressed(new IntakeDown(mIntake));

    new JoystickButton(xbox2, Button.kY.value).whenPressed(new CarriageUp(mCarriage));
    new JoystickButton(xbox2, Button.kA.value).whenPressed(new CarriageDown(mCarriage));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    autoStart.addCommands(new DriveAuto(mDrivetrain, 0.5), new DriveAuto(mDrivetrain, 0));
    return autoStart;
    //return auto;
  }
}
