package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class wait extends CommandBase{

    double mTime;
    private final Drivetrain mDrivetrain;
    private final Intake mIntake;

    private final Timer timer = new Timer();

    public wait(Drivetrain drivetrain, Intake intake, double time){
        mTime = time;
        mDrivetrain = drivetrain;
        mIntake = intake;
    }

    public void initialize()
    {
        timer.start();
    }
    public void execute()
    {
        mDrivetrain.stop();
        mIntake.stop();
    }

    public boolean isFinished()
    {
        if(timer.get() > mTime)
        {
            return true;
        }
        return false;
    }
    
}
