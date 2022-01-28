package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Carriage extends SubsystemBase{
    TalonSRX bCarriage = new TalonSRX(Constants.CAN_TALON_BCARRIAGE_MOTOR);
    TalonSRX tCarriage = new TalonSRX(Constants.CAN_TALON_TCARRIAGE_MOTOR);
    

    public Carriage(){
    }
  
    public void runCarriage(final double speed){
      bCarriage.set(ControlMode.PercentOutput, speed);
      tCarriage.set(ControlMode.PercentOutput, 0);
    }
  
    public void stop(){
        tCarriage.set(ControlMode.PercentOutput, 0);
        bCarriage.set(ControlMode.PercentOutput, 0);
    }
  
}
