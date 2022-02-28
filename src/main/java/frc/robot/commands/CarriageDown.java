package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
//import frc.robot.subsystems.LEDs;

public class CarriageDown extends CommandBase {
    private final Intake mCarriage;
    //private final LEDs mLEDs;

    public CarriageDown(Intake _Carriage){
        mCarriage = _Carriage;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        mCarriage.liftDown();
        mCarriage.resetBalls();
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
