package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {
    private final DoubleSupplier mrTrig2;
    private final DoubleSupplier mlTrig2;
    private final Intake mIntake;


   public RunIntake (Intake Subsystem, DoubleSupplier rTrig2, DoubleSupplier lTrig2)
    {
        mrTrig2 = rTrig2;
        mlTrig2 = lTrig2;
        mIntake = Subsystem;
        addRequirements(mIntake);
    }
    @Override
    public void execute() {
        double posSpeed, negSpeed;
    //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        posSpeed = -mrTrig2.getAsDouble();
        negSpeed = mlTrig2.getAsDouble();

        if(mrTrig2.getAsDouble() > mlTrig2.getAsDouble())
        {
            mIntake.runIntake(posSpeed);
        }
        else
        {
            mIntake.runIntake(negSpeed);
        }
      
    }  

}