package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WheelOfFortune extends SubsystemBase{

    CANSparkMax leftWheel = new CANSparkMax(Constants.CAN_LEFT_WHEEL, MotorType.kBrushless);
    CANSparkMax rightWheel = new CANSparkMax(Constants.CAN_RIGHT_WHEEL, MotorType.kBrushless);

    public WheelOfFortune()
    {
    }
    public void climb(double speed)
    {
        leftWheel.set(-speed);
        rightWheel.set(speed);
    }

    public void stop(){
        leftWheel.set(0);
        rightWheel.set(0);
    }
}
