package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class DriveAuto extends CommandBase{

    private final Drivetrain mDrivetrain;
    private final double speed;
    private final Timer time = new Timer();
    // private double

    public DriveAuto(Drivetrain subsystem,double s)
    {
        mDrivetrain = subsystem;
        speed = s;
        addRequirements(mDrivetrain);
    }

    public void initialize()
    {
        time.start();
    }

    public void execute()
    {
        mDrivetrain.drive(speed, 0);
    }

    public boolean isFinished()
    {
        if(time.get() > 2)
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