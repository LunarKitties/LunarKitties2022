package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.WheelOfFortune;
import edu.wpi.first.wpilibj.Timer;

public class StartClimbing extends CommandBase {
    private final WheelOfFortune mIntake;
    private final Timer time = new Timer();
    //private final LEDs mLEDs;

    public StartClimbing(WheelOfFortune _Intake){
        mIntake = _Intake;
        //mLEDs = _LEDs;
        addRequirements(mIntake);
    }

    public void initialize()
    {
        time.start();
        mIntake.activate();
    }
    @Override
    public void execute(){
        mIntake.deployArms();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
        if(time.get() > 3){
            mIntake.stopArms();
            return true;
        }
        return false;
    }


    public void end(){
        mIntake.stopArms();
    }
}