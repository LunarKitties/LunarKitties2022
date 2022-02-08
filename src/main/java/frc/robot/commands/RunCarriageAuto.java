package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Carriage;
import edu.wpi.first.wpilibj.Timer;
//import frc.robot.subsystems.LEDs;

public class RunCarriageAuto extends CommandBase {
    private final Carriage mCarriage;
    private final Timer time = new Timer();
    private final double speed;
    //private final LEDs mLEDs;

    public RunCarriageAuto(Carriage _Carriage, double s){
        mCarriage = _Carriage;
        speed = s;
        //mLEDs = _LEDs;
        addRequirements(mCarriage);
    }

    @Override
    public void initialize(){
        time.start();
        //mLEDs.setColor(mLEDs.RAINBOW);
    }

    public void execute()
    {
        mCarriage.runCarriage(speed);
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
        mCarriage.runCarriage(0);
    }
}