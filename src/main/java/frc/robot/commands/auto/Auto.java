package frc.robot.commands.auto;

//subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeDown;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//commands
import frc.robot.commands.auto.DriveAuto;
import frc.robot.commands.RunWheel;
import frc.robot.commands.auto.RunIntakeAuto;



public class Auto extends SequentialCommandGroup
{
    private final Drivetrain mDrivetrain;
    private final WheelOfFortune mWheel;
    private final Intake mIntake;

    public Auto(Drivetrain drivetrain, WheelOfFortune Wheel, Intake intake)
    {
        mDrivetrain = drivetrain;
        mWheel = Wheel;
        mIntake = intake;

        addCommands(
            new RunIntakeAuto(mIntake, 1.0),
            new DriveAuto(mDrivetrain, 0.5)
        );
    }

}