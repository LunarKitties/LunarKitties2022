package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class TestAutoCommand2 extends CommandBase{

    private final Drivetrain mDrivetrain;
    private final Timer time = new Timer();
    // private double

    public TestAutoCommand2(Drivetrain subsystem)
    {
        mDrivetrain = subsystem;
        addRequirements(mDrivetrain);
    }

    public void initialize()
    {
        time.start();
    }

    public void execute()
    {
        mDrivetrain.drive(0.5, 0);
    }

    public boolean isFinished()
    {
        if(time.get() > 1)
        {
            mDrivetrain.drive(0, 0);
            return true;
        }
        return false;
    }
 
    public void end()
    {
        mDrivetrain.drive(0, 0);
    }
    
}