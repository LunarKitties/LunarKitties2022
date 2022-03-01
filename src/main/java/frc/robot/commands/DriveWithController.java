package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;
import java.lang.Math;

import javax.lang.model.util.ElementScanner6;

public class DriveWithController extends CommandBase{
    private final Drivetrain mDrivetrain;
    private final DoubleSupplier mLeftTrigger;
    private final DoubleSupplier mRightTrigger;
    private final DoubleSupplier mRightStickX;
    private final DoubleSupplier mLeftStickY;
    private final DoubleSupplier mRightStickY;
    private boolean manualOveride;
    private int mConfig;

    public DriveWithController( Drivetrain subsystem, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rightStickX, DoubleSupplier leftStickY, DoubleSupplier rightStickY, int config, boolean MmanualOveride){
        mDrivetrain = subsystem;
        mLeftTrigger = leftTrigger;
        mRightTrigger = rightTrigger;
        mRightStickX = rightStickX;
        mLeftStickY = leftStickY;
        mRightStickY = rightStickY;
        mConfig = config;
        manualOveride = MmanualOveride;
        addRequirements(mDrivetrain);
    }

    @Override
    public void execute(){
        //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        double speed = mRightTrigger.getAsDouble() - mLeftTrigger.getAsDouble();

        double left = mLeftStickY.getAsDouble();
        double right = mRightStickY.getAsDouble();

        //To Rotate you use the Right Joystick X Axis
        double rotate = mRightStickX.getAsDouble();

        //Drive the Robot

            if(mConfig == 1)
            {
                mDrivetrain.arDrive(speed, rotate);
            }
            else if(mConfig == 2)
            {
                mDrivetrain.arDrive(-left, rotate*0.7);
            }
            else{
                mDrivetrain.tDrive(-left, -right);
            }

          
            if(!mDrivetrain.getMode() && Math.abs(mDrivetrain.wheelVelocity()) > 1400 && mDrivetrain.isHighGear()){
                mDrivetrain.shiftLow();
            }
            else if(!mDrivetrain.getMode() && Math.abs(mDrivetrain.wheelVelocity()) < 200 && mDrivetrain.isLowGear()){
                mDrivetrain.shiftHigh();
            }

            mDrivetrain.publish();
    }
    
}