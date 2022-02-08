package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Timer;

public class TestAutoCommand extends CommandBase{

    private final Drivetrain mDrivetrain;
    private final Timer time = new Timer();
    // private double

    public TestAutoCommand(Drivetrain subsystem)
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
        mDrivetrain.drive(1, 0);
    }

    public boolean isFinished()
    {
        
        if(time.get() > 3)
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
