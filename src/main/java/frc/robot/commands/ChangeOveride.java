package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.LEDs;

public class ChangeOveride extends CommandBase {
    private final Drivetrain mDrivetrain;
    //private final LEDs mLEDs;

    public ChangeOveride(Drivetrain _Drivetrain){
        mDrivetrain = _Drivetrain;
        //mLEDs = _LEDs;
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize(){
        mDrivetrain.changeMode();
        //mLEDs.setColor(mLEDs.RAINBOW_OCEAN);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
