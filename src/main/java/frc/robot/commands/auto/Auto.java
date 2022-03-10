package frc.robot.commands.auto;

//subsystems
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.auto.IntakeAuto;
import frc.robot.commands.auto.wait;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

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
            new IntakeDown(mIntake),
            new ParallelCommandGroup(
                new DriveAuto(mDrivetrain, 0.3, 19),
                new IntakeAuto(mIntake, 1.0)),
            new wait(mDrivetrain, mIntake, 0.5),
            new DriveAuto(mDrivetrain, -0.3, 21),
            new CarriageUpAuto(mIntake),
            new ShootAuto(mIntake, 1.0),
            new CarriageDownAuto(mIntake),
            new DriveAuto(mDrivetrain, 0.5, 35)  
            
        );
    }

}