package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;
//import frc.robot.subsystems.LEDs;

public class CarriageUpAuto extends CommandBase {
    private final Intake mCarriage;
    private final Timer time = new Timer();
    //private final LEDs mLEDs;

    public CarriageUpAuto(Intake _Carriage){
        mCarriage = _Carriage;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        mCarriage.liftUp();
        time.start();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){ 
        if(time.get() > 1.5){
            return true;
        }
        return false;
    }

    public void end()
    {

    }
}
