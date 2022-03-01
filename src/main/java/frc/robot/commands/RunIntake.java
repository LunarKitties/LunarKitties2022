package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {
    private final DoubleSupplier mrTrig1;
    private final DoubleSupplier mlTrig1;
    private final DoubleSupplier mrTrig2;
    private final DoubleSupplier mlTrig2;
    private final Intake mIntake;

   public RunIntake(Intake Subsystem, DoubleSupplier rTrig1, DoubleSupplier lTrig1,DoubleSupplier rTrig2, DoubleSupplier lTrig2)
    {
        mrTrig1 = rTrig1;
        mlTrig1 = lTrig1;
        mrTrig2 = rTrig2;
        mlTrig2 = lTrig2;
        mIntake = Subsystem;
        addRequirements(mIntake);
    }
    @Override
    public void execute() {
        mIntake.publish();
        double posSpeed, negSpeed, posSpeed2, negSpeed2;
    //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        posSpeed = -mrTrig1.getAsDouble();
        negSpeed = mlTrig1.getAsDouble();

        posSpeed2 = -mrTrig2.getAsDouble();
        negSpeed2 = mlTrig2.getAsDouble();
        
        if(mIntake.carriageTop()){
            if(mrTrig2.getAsDouble() > mlTrig2.getAsDouble()){
                mIntake.shootIntake(posSpeed2);
            }else{
                mIntake.shootIntake(negSpeed2);
            }
        }else{ 
            if(mrTrig1.getAsDouble() > mlTrig1.getAsDouble()){
                mIntake.runIntake(posSpeed);
            }else{ 
                mIntake.runIntake(negSpeed);
            }   
            //mIntake.stop();
        }
      
    }  

}