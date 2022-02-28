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
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;


public class Intake extends SubsystemBase{

    CANSparkMax intakeMotor = new CANSparkMax(Constants.CAN_INTAKE_MOTOR, MotorType.kBrushless);
    TalonSRX carriageBottom = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    TalonSRX carriageTop = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    TalonSRX carriageShooter = new TalonSRX(Constants.CAN_TALON_SHOOTER_MOTOR);
    DoubleSolenoid lift = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_CARRIAGE_UP, Constants.PH_CARRIAGE_DOWN);
    


    DoubleSolenoid IntakeJoint = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_INTAKE_UP, Constants.PH_INTAKE_DOWN);

    //ball detection
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    public int numBalls = 0;

    //
    DigitalInput carriageSwitch = new DigitalInput(Constants.CARRIAGE_LIFT_SWITCH);
    AnalogPotentiometer ultrasonicT = new AnalogPotentiometer(0, 1000, 0);
    AnalogPotentiometer ultrasonicB = new AnalogPotentiometer(1, 1000, 0);

    public Intake(){
    }
      
    public void runIntake(final double speed){
      if (numBalls == 1 || numBalls == 2){
        carriageTop.set(ControlMode.PercentOutput, 0);
      } else {
        carriageTop.set(ControlMode.PercentOutput, speed);
      }
      if (numBalls == 2){
        carriageBottom.set(ControlMode.PercentOutput, 0);
      } else {
        carriageBottom.set(ControlMode.PercentOutput, speed);
      }
      intakeMotor.set(speed);
    }
    
    public void shootIntake(final double speed){
      carriageBottom.set(ControlMode.PercentOutput, speed);
      carriageTop.set(ControlMode.PercentOutput, speed);
      carriageShooter.set(ControlMode.PercentOutput, speed);
      intakeMotor.set(0);
    }
  
    public void stop(){
      intakeMotor.set(0);
      carriageBottom.set(ControlMode.PercentOutput, 0);
      carriageTop.set(ControlMode.PercentOutput, 0);
      carriageShooter.set(ControlMode.PercentOutput, 0);
    }
  
    public void IntakeUp(){
      IntakeJoint.set(Value.kForward);
    }

   public void IntakeDown(){
      IntakeJoint.set(Value.kReverse);
    }

    public void liftUp(){
      lift.set(Value.kForward);
  }

   public void liftDown(){
      lift.set(Value.kReverse);
  }

  public boolean carriageTop(){
    return carriageSwitch.get();
  }

  public int numBalls()
  {
    return numBalls;
  }

  public void addBall()
  {
    numBalls++;
  }
   
  public void resetBalls()
  {
    numBalls = 0;
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

  public void publish(){
    // SmartDashboard.putBoolean("colorTopSeesCargo", colorTopSeesCargo());
    // SmartDashboard.putBoolean("colorBottomSeesCargo", colorBottomSeesCargo());
    SmartDashboard.putBoolean("colorBlueBall", colorSeesBlue());
    SmartDashboard.putBoolean("colorRedBall", colorSeesRed());
    SmartDashboard.putBoolean("carrrriaaaaaagggghhhhaaaaa", carriageTop());
  }
}