package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Intake;
//import frc.robot.subsystems.LEDs;

public class CarriageUpAuto extends CommandBase {
    private final Intake mCarriage;
    private final Timer time = new Timer();
    //private final LEDs mLEDs;

    public CarriageUpAuto(Intake intake){
        mCarriage = intake;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        mCarriage.liftUp();
        time.start();
    }


    @Override
    public boolean isFinished(){
        if(time.get() > 2){
        return true;
        }
        return false;
    }

    public void end()
    {
    }
}