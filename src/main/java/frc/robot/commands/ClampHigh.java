package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;

public class ClampHigh extends CommandBase {
    private final WheelOfFortune mWheelOfFortune;
    //private final LEDs mLEDs;

    public ClampHigh(WheelOfFortune _WheelOfFortune){
        mWheelOfFortune = _WheelOfFortune;
        //mLEDs = _LEDs;
        addRequirements(mWheelOfFortune);
    }

    @Override
    public void initialize(){ 
        mWheelOfFortune.clampHigh();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
