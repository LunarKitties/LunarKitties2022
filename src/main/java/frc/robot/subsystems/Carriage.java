package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DigitalInput;



public class Carriage extends SubsystemBase{
    TalonSRX bCarriage = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    TalonSRX tCarriage = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    DigitalInput carriageSwitch = new DigitalInput(Constants.CARRIAGE_LIFT_SWITCH);
    TalonSRX carriageShooter = new TalonSRX(Constants.CAN_TALON_SHOOTER_MOTOR);

    
    

    DoubleSolenoid lift = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_CARRIAGE_UP, Constants.PH_CARRIAGE_DOWN);

    public Carriage(){
    }
  
    public void runCarriage(final double speed){
      bCarriage.set(ControlMode.PercentOutput, speed);
      tCarriage.set(ControlMode.PercentOutput, speed);
      carriageShooter.set(ControlMode.PercentOutput, speed);

    }
  
    public void stop(){
        tCarriage.set(ControlMode.PercentOutput, 0);
        bCarriage.set(ControlMode.PercentOutput, 0);
        carriageShooter.set(ControlMode.PercentOutput, 0);
    }

    public void liftUp(){
      lift.set(Value.kForward);
  }

   public void liftDown(){
      lift.set(Value.kReverse);
  }

  public boolean liftIsUp(){
    return lift.get() == Value.kForward;
  }

  public boolean limitSwitchState(){
    return carriageSwitch.get();
  }

  
  
}
