
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;

public class StopWheel extends CommandBase {
    private final WheelOfFortune mWheel;
    //private final LEDs mLEDs;

    public StopWheel(WheelOfFortune _wheel){
        mWheel = _wheel;
        addRequirements(mWheel);
    }

    @Override
    public  void initialize(){
        mWheel.climb(0);
    }

}

