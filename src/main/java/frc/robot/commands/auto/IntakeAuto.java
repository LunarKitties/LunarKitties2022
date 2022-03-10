package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;

public class IntakeAuto extends CommandBase{

    private final Intake mIntake;
    private final double speed;
    private final Timer time = new Timer();

    public IntakeAuto(Intake subsystem, double s)
    {
        mIntake = subsystem;
        speed = s;
        addRequirements(mIntake);
    }

    public void initialize()
    {
        time.start();
    }

    public void execute()
    {
        mIntake.runIntake(speed);
    }

    public boolean isFinished()
    {
        if(time.get() > 2)
        {
            mIntake.stop();
            return true;
        }
        return false;
    }
 
    public void end()
    {
        mIntake.stop();
    }
    
}

