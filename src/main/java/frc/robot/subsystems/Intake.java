package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


public class Intake extends SubsystemBase{

    TalonSRX intakeMotor = new TalonSRX(Constants.CAN_TALON_INTAKE_MOTOR);
    TalonSRX carriageLow = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    
    DoubleSolenoid IntakeJoint = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_INTAKE_UP, Constants.PH_INTAKE_DOWN);

    public Intake(){
    }
  
    public void runIntake(final double speed){
      intakeMotor.set(ControlMode.PercentOutput, -speed);
      carriageLow.set(ControlMode.PercentOutput, speed);
    }
  
    public void stop(){
      intakeMotor.set(ControlMode.PercentOutput, 0);
      carriageLow.set(ControlMode.PercentOutput, 0);
    }
  
    public void IntakeUp(){
      IntakeJoint.set(Value.kForward);
    }

   public void IntakeDown(){
      IntakeJoint.set(Value.kReverse);
    }
  
}