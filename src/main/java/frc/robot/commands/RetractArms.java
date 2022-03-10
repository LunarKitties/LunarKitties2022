package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.WheelOfFortune;

public class RetractArms extends CommandBase {
    private final WheelOfFortune mIntake;
    //private final LEDs mLEDs;

    public RetractArms(WheelOfFortune _Intake){
        mIntake = _Intake;
        //mLEDs = _LEDs;
        addRequirements(mIntake);
    }

    public void initialize()
    {
        mIntake.activate();
    }
    @Override
    public void execute(){
        mIntake.stopArms();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
       
            return true;
    }


    public void end(){
        
    }
}