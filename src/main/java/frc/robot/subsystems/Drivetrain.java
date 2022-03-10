package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{
        
        //Motor Controller Objects based on CAN IDs
    CANSparkMax lfMotor = new CANSparkMax(Constants.CAN_LF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lmMotor = new CANSparkMax(Constants.CAN_LM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lbMotor = new CANSparkMax(Constants.CAN_LB_DRIVE_MOTOR, MotorType.kBrushless);
    
    CANSparkMax rfMotor = new CANSparkMax(Constants.CAN_RF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rmMotor = new CANSparkMax(Constants.CAN_RM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rbMotor = new CANSparkMax(Constants.CAN_RB_DRIVE_MOTOR, MotorType.kBrushless);

    private int config = 2;
    public boolean manualOveride;
    
        //Group the Left and Right Motors together
    public MotorControllerGroup leftWheels = new MotorControllerGroup(lfMotor, lmMotor, lbMotor);
    public MotorControllerGroup rightWheels = new MotorControllerGroup(rfMotor, rmMotor, rbMotor);

        //encoders
    RelativeEncoder leftEncoders = lfMotor.getEncoder();
    RelativeEncoder rightEncoders = rfMotor.getEncoder();

    //AHRS gyro = new AHRS();

        //Create Differential Drive Object allowing us to drive the robot
    DifferentialDrive dd = new DifferentialDrive(leftWheels, rightWheels);

      //Wheel Shifters 
      DoubleSolenoid shifters = new DoubleSolenoid(15, PneumaticsModuleType.REVPH, Constants.PH_DRIVE_S_OUT, Constants.PH_DRIVE_S_IN);
   

        //constructor
    public Drivetrain(){
        dd.setSafetyEnabled(false);
        shifters.set(Value.kReverse);
        manualOveride = false;
    }

    public boolean getMode()
    {
        return manualOveride;
    }

    public void changeConfig()
    {
        config++;
        if(config > 3)
        {
            config = 1;
        }
    }

    public int getConfig()
    {
        return config;
    }

    public void arDrive(double speed, double rotate){
       
        leftWheels.setInverted(true);
        dd.arcadeDrive(speed ,rotate);
    }

    public void tDrive(double left, double right)
    {
        leftWheels.setInverted(true);
        dd.tankDrive(left, right);
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

    public double getLeftEncoders(){
        return leftEncoders.getPosition();
    }

    public double getRightEncoders(){
        return rightEncoders.getPosition()* - 1.0;
    }

    public double getEncoders()
    {
        return ((rightEncoders.getPosition()* - 1.0)+leftEncoders.getPosition())/2.0;
    }

    public double wheelVelocity()
    {
        return (leftEncoders.getVelocity() + (rightEncoders.getVelocity()*-1.0))/2.0;
    }

   
    public void resetLeftEncoders()
    {
        leftEncoders.setPosition(0);
    }

    public void resetRightEncoders()
    {
        rightEncoders.setPosition(0);
    }

    /*
    public void gyroCalibrate(){
        gyro.calibrate();
    }  

    public void gyroReset(){
        gyro.reset();
    }

    public double getAngle(){
        return gyro.getAngle() % 360;
    }
*/
    public void publish(){
        /*
        SmartDashboard.putNumber("leftEncoders", getLeftEncoders());
        SmartDashboard.putNumber("rightEncoders", getRightEncoders());
        
        SmartDashboard.putNumber("wheelVelocity", wheelVelocity());
        */
       // SmartDashboard.putNumber("ANGELSinTheOutfield", getAngle());
       SmartDashboard.putBoolean("manualOveride", manualOveride);
    }
}