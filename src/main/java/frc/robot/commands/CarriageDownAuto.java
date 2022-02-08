package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
import edu.wpi.first.wpilibj.Timer;
//import frc.robot.subsystems.LEDs;

public class CarriageDownAuto extends CommandBase {
    private final Carriage mCarriage;
    private final Timer time = new Timer();
    private boolean done = false;
    //private final LEDs mLEDs;

    public CarriageDownAuto(Carriage _Carriage){
        mCarriage = _Carriage;
        
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        time.start();
        mCarriage.liftDown();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }


    @Override
    public boolean isFinished(){
        if(time.get() < 2){
            return true;
            }
           return false;
    }
    
    public void end()
    {
        mCarriage.liftDown();  
    }
}