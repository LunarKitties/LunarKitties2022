package frc.robot.commands.auto;

//subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.RunCarriageAuto;
import frc.robot.subsystems.Carriage;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//commands
import frc.robot.commands.auto.CarriageDownAuto;
import frc.robot.commands.auto.CarriageUpAuto;
import frc.robot.commands.auto.DriveAuto;
import frc.robot.commands.RunWheel;
import frc.robot.commands.auto.RunIntakeAuto;


public class Auto extends SequentialCommandGroup
{
    private final Drivetrain mDrivetrain;
    private final Carriage mCarriage;
    private final WheelOfFortune mWheel;
    private final Intake mIntake;

    public Auto(Drivetrain drivetrain, Carriage carriage, WheelOfFortune Wheel, Intake intake)
    {
        mDrivetrain = drivetrain;
        mCarriage = carriage;
        mWheel = Wheel;
        mIntake = intake;

        addCommands(
            new DriveAuto(mDrivetrain, 0.5),
            new IntakeUp(mIntake),
            new DriveAuto(mDrivetrain, -0.5),
            new DriveAuto(mDrivetrain, 0.5)
        );
    }

}