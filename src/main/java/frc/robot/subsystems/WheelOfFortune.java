package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class WheelOfFortune extends SubsystemBase{

        //hub wheels
    CANSparkMax leftWheel = new CANSparkMax(Constants.CAN_LEFT_WHEEL, MotorType.kBrushless);
    CANSparkMax rightWheel = new CANSparkMax(Constants.CAN_RIGHT_WHEEL, MotorType.kBrushless);

        //first arm deployment motors
    TalonSRX hangarArm = new TalonSRX(Constants.CAN_TALON_HANGAR_ARM);

        //switches for second arm hooks
    //here

        //second arm hook motors
   // TalonSRX hangarHook = new TalonSRX(Constants.CAN_TALON_HANGAR_HOOK);

    public WheelOfFortune()
    {
    }
    
    public void deployArms(){
        hangarArm.set(ControlMode.PercentOutput, 0.5);
    }
    public void retractArms(){
        hangarArm.set(ControlMode.PercentOutput, -0.5);
    }
    public void stopArms(){
        hangarArm.set(ControlMode.PercentOutput, 0);
    }
/*
    public void closeHooks(){
        hangarHook.set(ControlMode.PercentOutput, 0.5);
    }
    public void openHooks(){
        hangarHook.set(ControlMode.PercentOutput, -0.5);
    }
    public void stopHooks(){
        hangarHook.set(ControlMode.PercentOutput, 0);
    }
    */
    public void spinWheel(double speed)
    {
        leftWheel.set(-speed*0.75);
        rightWheel.set(speed*0.75);
    }



    public void stop(){
        leftWheel.set(0);
        rightWheel.set(0);
    }
}
