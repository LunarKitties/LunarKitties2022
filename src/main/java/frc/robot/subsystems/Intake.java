package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.revrobotics.AnalogInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;


public class Intake extends SubsystemBase{

    CANSparkMax intakeMotor = new CANSparkMax(Constants.CAN_INTAKE_MOTOR, MotorType.kBrushless);
    TalonSRX carriageLow = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    TalonSRX carriageUp = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    TalonSRX carriageShooter = new TalonSRX(Constants.CAN_TALON_SHOOTER_MOTOR);
    DoubleSolenoid lift = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_CARRIAGE_UP, Constants.PH_CARRIAGE_DOWN);
    
    DoubleSolenoid IntakeJoint = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_INTAKE_UP, Constants.PH_INTAKE_DOWN);

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorTop = new ColorSensorV3(i2cPort);
    private final ColorSensorV3 m_colorBottom = new ColorSensorV3(i2cPort);

    DigitalInput carriageSwitch = new DigitalInput(Constants.CARRIAGE_LIFT_SWITCH);
    AnalogPotentiometer ultrasonic = new AnalogPotentiometer(0, 1000, 50);

    public Intake(){
    }
  
    public void runIntake(final double speed){
      if (colorTopSeesCargo()){
        carriageUp.set(ControlMode.PercentOutput, 0);
      } else {
        carriageUp.set(ControlMode.PercentOutput, speed);
      }
      if (colorBottomSeesCargo() && colorTopSeesCargo()){
        carriageLow.set(ControlMode.PercentOutput, 0);
      } else {
        carriageLow.set(ControlMode.PercentOutput, speed);
      }
      intakeMotor.set(speed);
    }
    
    public void shootIntake(final double speed){
      carriageLow.set(ControlMode.PercentOutput, speed);
      carriageUp.set(ControlMode.PercentOutput, speed);
      carriageShooter.set(ControlMode.PercentOutput, speed);
      intakeMotor.set(0);
    }
  
    public void stop(){
      intakeMotor.set(0);
      carriageLow.set(ControlMode.PercentOutput, 0);
      carriageUp.set(ControlMode.PercentOutput, 0);
      carriageShooter.set(ControlMode.PercentOutput, 0);
    }
  
    public void IntakeUp(){
      IntakeJoint.set(Value.kForward);
    }

   public void IntakeDown(){
      IntakeJoint.set(Value.kReverse);
    }

    public int getRed(){
      return m_colorTop.getRed();
    }
  
    public int getBlue(){
      return m_colorTop.getBlue();
    }
  
    public boolean colorTopSeesCargo(){
      if(m_colorTop.getRed() > 500 || m_colorTop.getBlue() > 50000000)
      {
        return true;
      }
      else{
        return false;
      }
    }

    public boolean colorBottomSeesCargo(){
      if(m_colorBottom.getRed() > 500 || m_colorBottom.getBlue() > 50000000)
      {
        return true;
      }
      else{
        return false;
      }
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

  public boolean carriageUp(){
    return carriageSwitch.get();
  }

  public double test(){
    return ultrasonic.get();
  }

  public void publish(){
    // SmartDashboard.putBoolean("colorTopSeesCargo", colorTopSeesCargo());
    // SmartDashboard.putBoolean("colorBottomSeesCargo", colorBottomSeesCargo());
    SmartDashboard.putNumber("ultrasonic", test());
    SmartDashboard.putBoolean("carrrriaaaaaagggghhhhaaaaa", carriageUp());
  }
}