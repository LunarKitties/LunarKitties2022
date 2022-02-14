package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
import edu.wpi.first.wpilibj.Timer;
public class RunCarriage extends CommandBase {
    
    private final Carriage mCarriage;
    private final double speed;
    private final Timer time = new Timer();
    
   public RunCarriage(Carriage Subsystem, double s)
    {
        mCarriage = Subsystem;
        speed = s;
        addRequirements(mCarriage);
    }
    @Override
    public void initialize() {
        mCarriage.runCarriage(speed);
        time.start();
    }  
    public boolean isFinished()
    {
        if(time.get() > 2)
        {
        return true;
        }
        else{
            return false;
        }
    }
    public void end()
    {
        time.stop();
        mCarriage.stop();
    }

}