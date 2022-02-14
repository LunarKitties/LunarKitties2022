package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
import edu.wpi.first.wpilibj.Timer;
//import frc.robot.subsystems.LEDs;

public class RunCarriageAuto extends CommandBase {
    private final Carriage mCarriage;
    private final Timer time = new Timer();
    private final double mSpeed;
    //private final LEDs mLEDs;

    public RunCarriageAuto(Carriage _Carriage, double s){
        mCarriage = _Carriage;
        mSpeed = s;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    public void initialize(){
        time.start();
        mCarriage.runCarriage(mSpeed);
        //mLEDs.setColor(mLEDs.RAINBOW);
    }
    
   public boolean isFinished(){
        if(time.get() > 2){
        mCarriage.runCarriage(0);
        return true;
        }
        return false;
    }

    public void end()
    {
        mCarriage.runCarriage(0);
    }
}