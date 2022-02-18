
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
import java.util.function.DoubleSupplier;
//import frc.robot.subsystems.LEDs;

public class RunWheel extends CommandBase {
    private final WheelOfFortune mWheel;
    //private final DoubleSupplier mLeftStickY;
    //private final LEDs mLEDs;

    public RunWheel(WheelOfFortune _wheel/*, DoubleSupplier LeftStickY*/){
        mWheel = _wheel;
        //mLeftStickY = LeftStickY;
        addRequirements(mWheel);
    }

    @Override
    public  void execute(){
        mWheel.climb(0.5);
    }

}

