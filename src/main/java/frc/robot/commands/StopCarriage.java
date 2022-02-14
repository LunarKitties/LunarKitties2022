package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;

public class StopCarriage extends CommandBase {
   
    private final Carriage mCarriage;
    
   public StopCarriage(Carriage Subsystem)
    {
        mCarriage = Subsystem;
        addRequirements(mCarriage);
    }
    @Override
    public void initialize() {
        mCarriage.runCarriage(0);
    }  

    public boolean isFinished()
    {
        return true;
    }

}