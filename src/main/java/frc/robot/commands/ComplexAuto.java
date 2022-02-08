package frc.robot.commands;

import frc.robot.subsystems.Carriage;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class ComplexAuto extends SequentialCommandGroup {
  
  public ComplexAuto(Drivetrain drive, Carriage carriage) {
    addCommands(new CarriageDownAuto(carriage), new CarriageUpAuto(carriage));
  }
}