
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;

public class RunWheel extends CommandBase {
    private final WheelOfFortune mWheel;
    private double speed;
    //private final LEDs mLEDs;

    public RunWheel(WheelOfFortune _wheel, double s){
        mWheel = _wheel;
        speed = s;
        addRequirements(mWheel);
    }

    @Override
    public  void initialize(){
        mWheel.climb(speed);
    }

}

