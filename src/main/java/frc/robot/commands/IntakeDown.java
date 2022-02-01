package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
//import frc.robot.subsystems.LEDs;

public class IntakeDown extends CommandBase {
    private final Intake mIntake;
    //private final LEDs mLEDs;

    public IntakeDown(Intake _Intake){
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
}
