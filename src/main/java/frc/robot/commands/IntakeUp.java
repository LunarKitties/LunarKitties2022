package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;

public class IntakeUp extends CommandBase {
    private final Intake mIntake;
    private final WheelOfFortune mWheelOfFortune;
    //private final LEDs mLEDs;

    public IntakeUp(Intake _Intake, WheelOfFortune wheelOfFortune){
        mIntake = _Intake;
        mWheelOfFortune = wheelOfFortune;
        //mLEDs = _LEDs;
        addRequirements(mIntake);
    }

    @Override
    public void initialize(){
        mIntake.IntakeDown();
        mWheelOfFortune.activate();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    public void end()
    {
        
    }
}
