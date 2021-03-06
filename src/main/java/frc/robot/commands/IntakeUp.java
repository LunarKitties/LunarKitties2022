package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WheelOfFortune;
//import frc.robot.subsystems.LEDs;

public class IntakeUp extends CommandBase {
    private final Intake mIntake;
    //private final LEDs mLEDs;

    public IntakeUp(Intake _Intake, WheelOfFortune wheelOfFortune){
        mIntake = _Intake;
        //mLEDs = _LEDs;
        addRequirements(mIntake);
    }

    @Override
    public void initialize(){
        mIntake.IntakeDown();
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
