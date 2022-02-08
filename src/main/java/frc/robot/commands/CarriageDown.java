package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
//import frc.robot.subsystems.LEDs;

public class CarriageDown extends CommandBase {
    private final Carriage mCarriage;
    //private final LEDs mLEDs;

    public CarriageDown(Carriage _Carriage){
        mCarriage = _Carriage;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        mCarriage.liftDown();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){ 
        if(!mCarriage.limitSwitchState()){
        return true;
        }
        return false;
    }

    public void end()
    {

    }
}
