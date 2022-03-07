package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;



public class WheelOfFortune extends SubsystemBase{

    //hub wheels
    CANSparkMax leftWheel = new CANSparkMax(Constants.CAN_LEFT_WHEEL, MotorType.kBrushless);
    CANSparkMax rightWheel = new CANSparkMax(Constants.CAN_RIGHT_WHEEL, MotorType.kBrushless);

    //first arm deployment motors
    TalonSRX hangarArm = new TalonSRX(Constants.CAN_TALON_HANGAR_ARM);

    //hooks
    DoubleSolenoid mArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH,Constants.PH_MARM_HOOK_CLAMP, Constants.PH_MARM_HOOK_UNCLAMP);
    TalonSRX hArmHook = new TalonSRX(Constants.CAN_TALON_HARM_HOOK);

    //DoubleSolenoid hArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_HARM_HOOK_CLAMP, Constants.PH_HARM_HOOK_UNCLAMP);
    //DoubleSolenoid tArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_TARM_HOOK_CLAMP, Constants.PH_TARM_HOOK_UNCLAMP);
    
    //hookswitchs
    
    DigitalInput harmLSwitch = new DigitalInput(Constants.HARM_LEFT_CLAMP);
    DigitalInput harmRSwitch = new DigitalInput(Constants.HARM_RIGHT_CLAMP);
    DigitalInput marmLSwitch = new DigitalInput(Constants.MARM_LEFT_CLAMP);
    DigitalInput marmRSwitch = new DigitalInput(Constants.MARM_RIGHT_CLAMP);
    DigitalInput tarmLSwitch = new DigitalInput(Constants.TARM_LEFT_CLAMP);
    DigitalInput tarmRSwitch = new DigitalInput(Constants.TARM_RIGHT_CLAMP);
    DigitalInput hangarArmLSwitch = new DigitalInput(Constants.HANGARARM_LEFT_SWITCH);
    DigitalInput hangarArmRSwitch = new DigitalInput(Constants.HANGARARM_RIGHT_SWITCH);
    
    public boolean active;
    public int step;

    public WheelOfFortune()
    {
        step = 0;
        active = false;
    } 

    public void activate()
    {
        active = true;
    }
    
    public void nextStep()
    {
        step++;
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

    //clamps
    public void clampMid()
    {
        mArmHook.set(Value.kForward);
    }
    public void unclampMid()
    {
        mArmHook.set(Value.kReverse);
    }

    public boolean harmSwitches()
    {
        if(harmLSwitch.get() && harmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    public boolean marmSwitches()
    {
        if(marmLSwitch.get() && marmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    public boolean tarmSwitches(){
    if(tarmLSwitch.get() && tarmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    public boolean hangarArmSwitches()
    {
        if(hangarArmLSwitch.get() && hangarArmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    public void clampHigh()
    {
        hArmHook.set(ControlMode.PercentOutput, 0.5);
    }
    public void unClampHigh()
    {
        hArmHook.set(ControlMode.PercentOutput, -0.5);
    }
    public void stopHigh()
    {
        hArmHook.set(ControlMode.PercentOutput, 0);
    }
    
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
