package frc.robot.commands.auto;

//subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeDown;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;

//commands
import frc.robot.commands.auto.DriveAuto;
import frc.robot.commands.TestWheel;
import frc.robot.commands.auto.ShootAuto;



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
            new ShootAuto(mIntake, 0.7),
            new CarriageDownAuto(mIntake),
            new DriveAuto(mDrivetrain, -0.5, 500),
            new ParallelRaceGroup(
                new IntakeAuto(mIntake, 1),
                new DriveAuto(mDrivetrain, -0.25, 10000000)),
            new DriveAuto(mDrivetrain, 0.6, 600),
            new ShootAuto(mIntake, 0.7)
            
        );
    }

}