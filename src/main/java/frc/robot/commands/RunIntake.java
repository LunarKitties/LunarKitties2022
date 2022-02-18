package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Carriage;

public class RunIntake extends CommandBase {
    private final DoubleSupplier mrTrig2;
    private final DoubleSupplier mlTrig2;
    private final Intake mIntake;
    private final Carriage mCarriage;


   public RunIntake(Carriage Subsystem1, Intake Subsystem, DoubleSupplier rTrig2, DoubleSupplier lTrig2)
    {
        mrTrig2 = rTrig2;
        mlTrig2 = lTrig2;
        mCarriage = Subsystem1;
        mIntake = Subsystem;

        addRequirements(mCarriage);
        addRequirements(mIntake);
    }
    @Override
    public void execute() {
        double posSpeed, negSpeed;
    //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        posSpeed = -mrTrig2.getAsDouble();
        negSpeed = mlTrig2.getAsDouble();
        
        if(mIntake.liftIsUp()){
            if(mrTrig2.getAsDouble() > mlTrig2.getAsDouble()){
                mIntake.shootIntake(posSpeed);
                mCarriage.runCarriage(posSpeed);
            }else{
                mIntake.shootIntake(negSpeed);
                mCarriage.runCarriage(negSpeed);
            }
        }else{
            if(mrTrig2.getAsDouble() > mlTrig2.getAsDouble()){
                mIntake.runIntake(posSpeed);
                // mCarriage.runCarriage(negSpeed);
            }else{
                mIntake.runIntake(negSpeed);
            }   
            mCarriage.stop();
        }
      
    }  

}