package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Carriage;

public class RunCarriage extends CommandBase {
   
    private final Carriage mCarriage;
    
   public RunCarriage(Carriage Subsystem)
    {
        mCarriage = Subsystem;
        addRequirements(mCarriage);
    }
    @Override
    public void initialize() {
        mCarriage.runCarriage(-1);
    }  

    public boolean isFinished()
    {
        return true;
    }

}