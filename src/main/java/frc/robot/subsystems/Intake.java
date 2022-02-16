package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;


public class Intake extends SubsystemBase{

    CANSparkMax intakeMotor = new CANSparkMax(Constants.CAN_INTAKE_MOTOR, MotorType.kBrushless);
    TalonSRX carriageLow = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    TalonSRX carriageUp = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    TalonSRX carriageShooter = new TalonSRX(Constants.CAN_TALON_SHOOTER_MOTOR);
    
    DoubleSolenoid IntakeJoint = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_INTAKE_UP, Constants.PH_INTAKE_DOWN);

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

    public Intake(){
    }
  
    public void runIntake(final double speed){
      intakeMotor.set(speed);
      carriageLow.set(ControlMode.PercentOutput, speed);
      if(colorSeesRed() || colorSeesBlue())
      {
      carriageUp.set(ControlMode.PercentOutput, 0);
      }
      else{
        carriageUp.set(ControlMode.PercentOutput, speed);
      }
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
      return m_colorSensor.getRed();
    }
  
    public int getBlue(){
      return m_colorSensor.getBlue();
    }
  
    public boolean colorSeesRed(){
      if(m_colorSensor.getRed() > 500)
      {
        return true;
      }
      else{
        return false;
      }
    }

    public boolean colorSeesBlue(){
      if(m_colorSensor.getBlue() > 50000000)
      {
        return true;
      }
      else{
        return false;
      }
    }
  
}