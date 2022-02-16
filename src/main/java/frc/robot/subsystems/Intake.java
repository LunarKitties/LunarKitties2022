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


public class Intake extends SubsystemBase{

    CANSparkMax intakeMotor = new CANSparkMax(Constants.CAN_INTAKE_MOTOR, MotorType.kBrushless);
    TalonSRX carriageLow = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    TalonSRX carriageUp = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    TalonSRX carriageShooter = new TalonSRX(Constants.CAN_TALON_SHOOTER_MOTOR);
    
    DoubleSolenoid IntakeJoint = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_INTAKE_UP, Constants.PH_INTAKE_DOWN);

    public Intake(){
    }
  
    public void runIntake(final double speed){
      intakeMotor.set(speed);
      carriageLow.set(ControlMode.PercentOutput, speed);
      carriageUp.set(ControlMode.PercentOutput, -speed);
    }
    
    public void runCarriage(final double speed) 
    {
      carriageLow.set(ControlMode.PercentOutput, -speed);
      carriageUp.set(ControlMode.PercentOutput, -speed);
      carriageShooter.set(ControlMode.PercentOutput, -speed);
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
  
}