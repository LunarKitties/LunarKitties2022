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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class WheelOfFortune extends SubsystemBase{

    //hub wheels
    CANSparkMax leftWheel = new CANSparkMax(Constants.CAN_LEFT_WHEEL, MotorType.kBrushless);
    CANSparkMax rightWheel = new CANSparkMax(Constants.CAN_RIGHT_WHEEL, MotorType.kBrushless);

    //first arm deployment motors
    TalonSRX hangarArm = new TalonSRX(Constants.CAN_TALON_HANGAR_ARM);

    //hooks
   
    DoubleSolenoid mArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH,Constants.PH_MARM_HOOK_CLAMP, Constants.PH_MARM_HOOK_UNCLAMP);
    DoubleSolenoid hArmHook = new DoubleSolenoid(22, PneumaticsModuleType.CTREPCM,Constants.PH_HARM_HOOK_CLAMP, Constants.PH_HARM_HOOK_UNCLAMP);

    //DoubleSolenoid hArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_HARM_HOOK_CLAMP, Constants.PH_HARM_HOOK_UNCLAMP);
    //DoubleSolenoid tArmHook = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_TARM_HOOK_CLAMP, Constants.PH_TARM_HOOK_UNCLAMP);
    
    //hookswitchs
    
    public DigitalInput harmLSwitch = new DigitalInput(Constants.HARM_LEFT_CLAMP);
    public DigitalInput harmRSwitch = new DigitalInput(Constants.HARM_RIGHT_CLAMP);
    public DigitalInput marmLSwitch = new DigitalInput(Constants.MARM_LEFT_CLAMP);
    public DigitalInput marmRSwitch = new DigitalInput(Constants.MARM_RIGHT_CLAMP);
    public DigitalInput tarmLSwitch = new DigitalInput(Constants.TARM_LEFT_CLAMP);
    public DigitalInput tarmRSwitch = new DigitalInput(Constants.TARM_RIGHT_CLAMP);
    DigitalInput hangarArmLSwitch = new DigitalInput(Constants.HANGARARM_LEFT_SWITCH);
    DigitalInput hangarArmRSwitch = new DigitalInput(Constants.HANGARARM_RIGHT_SWITCH);
    
    public boolean active;
    public int step;
    public boolean midPressed;
    public boolean midUnclamped;

    public WheelOfFortune()
    {
        step = 0;
        active = false;
        midPressed = false;
        midUnclamped = false;
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
        hangarArm.set(ControlMode.PercentOutput, -0.5);
    }
    public void retractArms(){
        hangarArm.set(ControlMode.PercentOutput, 0.5);
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

    public void clampHigh()
    {
        hArmHook.set(Value.kForward);
    }
    public void unclampHigh()
    {
        hArmHook.set(Value.kReverse);
    }


    //switch returns
    public boolean hArmSwitches()
    {
        if(!harmLSwitch.get() && !harmRSwitch.get())
        {
            return true;
        }
        return false;
    }
    public boolean marmSwitches()
    {
        if(!marmLSwitch.get() && !marmRSwitch.get())
        {
            return true;
        }
        return false;
    }
    public boolean tarmSwitches(){
    if(!tarmLSwitch.get() && !tarmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    public boolean hangarArmSwitches()
    {
        if(!hangarArmLSwitch.get() && !hangarArmRSwitch.get())
        {
            return true;
        }
        return false;
    }

    
    //wheel methods
    public void spinWheel(double speed)
    {
        if(Math.abs(speed)> 0.1){
        leftWheel.set(-speed*0.75);
        rightWheel.set(speed*0.75);
        }
    }
    public void stop(){
        leftWheel.set(0);
        rightWheel.set(0);
    }  
    
    //smart dashboard
    public void publish(){
        SmartDashboard.putBoolean("harmLSwitches", harmLSwitch.get());
        SmartDashboard.putBoolean("marmLSwitches", marmLSwitch.get());
        SmartDashboard.putBoolean("tarmLSwitches", tarmLSwitch.get());
        SmartDashboard.putBoolean("HangarArmLeft", hangarArmLSwitch.get());
        SmartDashboard.putBoolean("harmRSwitches", harmRSwitch.get());
        SmartDashboard.putBoolean("marmRSwitches", marmRSwitch.get());
        SmartDashboard.putBoolean("tarmRSwitches", tarmRSwitch.get());
        SmartDashboard.putBoolean("HangarArmRight", hangarArmRSwitch.get());
       // SmartDashboard.putNumber("ANGELSinTheOutfield", getAngle());
    }
}
