
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import javax.lang.model.util.ElementScanner6;

public class TestWheel extends CommandBase {
    private final WheelOfFortune mWheel;
    private final DoubleSupplier mLeftStickY;
    private final BooleanSupplier mrBumper;
    private final BooleanSupplier mlBumper;
    private final BooleanSupplier ma;
    private final BooleanSupplier mb;
    private final Timer time = new Timer();
    //private final LEDs mLEDs;

    public TestWheel(
        WheelOfFortune _wheel, 
        DoubleSupplier LeftStickY, 
        BooleanSupplier rBumper, 
        BooleanSupplier lBumper,
        BooleanSupplier a,
        BooleanSupplier b
    ){
        mWheel = _wheel;
        mLeftStickY = LeftStickY;
        mrBumper = rBumper;
        mlBumper = lBumper;
        ma = a;
        mb = b;
        addRequirements(mWheel);
    }

    @Override
    public  void execute(){
    if(mWheel.active == true)
        {
        if(mLeftStickY.getAsDouble() > 0.1 || mLeftStickY.getAsDouble() < -0.1){
            mWheel.spinWheel(-mLeftStickY.getAsDouble());
        }
        else{
            mWheel.spinWheel(0);
        }
    }

    if(!mWheel.tarmLSwitch.get() && !mWheel.tarmRSwitch.get()){
        mWheel.unclampHigh();
        mWheel.unclampMid();
    }
    else if(!mWheel.harmLSwitch.get() && !mWheel.harmRSwitch.get())
    {
        mWheel.clampMid();
    }
    else if(!mWheel.marmLSwitch.get() && !mWheel.marmRSwitch.get()){
        mWheel.clampHigh();
    }
    mWheel.publish();
        mWheel.publish();
    }
}

