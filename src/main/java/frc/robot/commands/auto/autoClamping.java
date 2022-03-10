package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.UnclampHigh;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj.Timer;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import javax.lang.model.util.ElementScanner6;

public class autoClamping extends CommandBase {
    private final WheelOfFortune mWheel;
    
    private final Timer time = new Timer();
    //private final LEDs mLEDs;

    public autoClamping(WheelOfFortune _wheel){
        mWheel = _wheel;
        addRequirements(mWheel);
    }

    @Override
    public  void execute(){
        
    }
}

