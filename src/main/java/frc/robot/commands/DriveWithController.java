package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;

import javax.lang.model.util.ElementScanner6;

public class DriveWithController extends CommandBase{
    private final Drivetrain mDrivetrain;
    private final DoubleSupplier mLeftTrigger;
    private final DoubleSupplier mRightTrigger;
    private final DoubleSupplier mRightStickX;
    private final DoubleSupplier mLeftStickY;
    private final DoubleSupplier mRightStickY;
    private int mConfig;

    public DriveWithController( Drivetrain subsystem, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rightStickX, DoubleSupplier leftStickY, DoubleSupplier rightStickY, int config){
        mDrivetrain = subsystem;
        mLeftTrigger = leftTrigger;
        mRightTrigger = rightTrigger;
        mRightStickX = rightStickX;
        mLeftStickY = leftStickY;
        mRightStickY = rightStickY;
        mConfig = config;
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
                mDrivetrain.arDrive(-left, rotate);
            }
            else{
                mDrivetrain.tDrive(-left, -right);
            }
/*
            if(mDrivetrain.wheelVelocity() > 6.0 && mDrivetrain.isLowGear()){
                mDrivetrain.shiftHigh();
            }
            else if(mDrivetrain.wheelVelocity() < 6.0 && mDrivetrain.isHighGear()){
                mDrivetrain.shiftLow();
            }
*/
            mDrivetrain.publish();
    }
    
}