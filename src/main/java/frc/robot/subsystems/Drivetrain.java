package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{
        
        //Motor Controller Objects based on CAN IDs
    CANSparkMax lfMotor = new CANSparkMax(Constants.CAN_LF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lmMotor = new CANSparkMax(Constants.CAN_LM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lbMotor = new CANSparkMax(Constants.CAN_LB_DRIVE_MOTOR, MotorType.kBrushless);
    
    CANSparkMax rfMotor = new CANSparkMax(Constants.CAN_RF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rmMotor = new CANSparkMax(Constants.CAN_RM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rbMotor = new CANSparkMax(Constants.CAN_RB_DRIVE_MOTOR, MotorType.kBrushless);
    
        //Group the Left and Right Motors together
    public MotorControllerGroup leftWheels = new MotorControllerGroup(lfMotor, lmMotor, lbMotor);
    public MotorControllerGroup rightWheels = new MotorControllerGroup(rfMotor, rmMotor, rbMotor);

        //Create Differential Drive Object allowing us to drive the robot
    DifferentialDrive dd = new DifferentialDrive(leftWheels, rightWheels);

      //Wheel Shifters
    DoubleSolenoid shifters = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_DRIVE_S_OUT, Constants.PH_DRIVE_S_IN);

        //constructor
    public Drivetrain(){
        dd.setSafetyEnabled(false);
        shifters.set(Value.kReverse);
    }

    public void drive(double speed, double rotate){
        leftWheels.setInverted(true);
        dd.arcadeDrive(speed,rotate);
    }

    public void stop(){
        dd.stopMotor();
    }

    public void shiftHigh(){
        shifters.set(Value.kForward);
        //shifters.toggle();
    }

     public void shiftLow(){
        shifters.set(Value.kReverse);
    }

    public boolean isHighGear(){
        return shifters.get() == Value.kForward;
    }

    public boolean isLowGear(){
        return shifters.get() == Value.kReverse;
    }
}