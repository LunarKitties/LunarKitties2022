package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Carriage;

public class RunCarriage extends CommandBase {
    private final BooleanSupplier a;
    private final BooleanSupplier b;
    private final Carriage mCarriage;


   public RunCarriage(Carriage Subsystem, BooleanSupplier aButton , BooleanSupplier bButton)
    {
        mCarriage = Subsystem;
        b = bButton;
        a = aButton;
        addRequirements(mCarriage);
    }
    @Override
    public void execute() {

        if(a.getAsBoolean())
        {
            mCarriage.runCarriage(1);
        }
        else if(b.getAsBoolean())
        {
            mCarriage.runCarriage(-1);
        }
        else{
            mCarriage.runCarriage(0);
        }
      
    }  

}