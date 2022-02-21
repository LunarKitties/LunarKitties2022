package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;
import java.lang.Math;

public class DriveAuto extends CommandBase{

    private final Drivetrain mDrivetrain;
    private final double rotations;
    private final double speed;
    private final Timer time = new Timer();

    public DriveAuto(Drivetrain subsystem, double s, double r)
    {
        mDrivetrain = subsystem;
        speed = s;
        rotations = r;
        addRequirements(mDrivetrain);
    }

    public void initialize()
    {
        mDrivetrain.resetLeftEncoders();
        mDrivetrain.resetRightEncoders();
        time.start();
    }

    public void execute()
    {
        if(Math.abs(mDrivetrain.getLeftEncoders()) > rotations ||
         Math.abs(mDrivetrain.getRightEncoders()) > rotations){
             mDrivetrain.arDrive(0, 0);
         }
         else{
        mDrivetrain.arDrive(speed, 0);
         }
        mDrivetrain.publish();
    }

    public boolean isFinished()
    {
        if(Math.abs(mDrivetrain.getLeftEncoders()) > rotations ||
         Math.abs(mDrivetrain.getRightEncoders()) > rotations)
         {
            mDrivetrain.arDrive(0, 0);
            return true;
        }
        return false;
    }
 
    public void end()
    {
        mDrivetrain.arDrive(0, 0);
    }
    
}