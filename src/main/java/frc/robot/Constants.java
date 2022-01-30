// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //drive motors
    public static int CAN_RF_DRIVE_MOTOR = 7;
    public static int CAN_RM_DRIVE_MOTOR = 5;
    public static int CAN_RB_DRIVE_MOTOR = 6;
    public static int CAN_LF_DRIVE_MOTOR = 4;
    public static int CAN_LM_DRIVE_MOTOR = 3;
    public static int CAN_LB_DRIVE_MOTOR = 2;

    //intake
    public static int CAN_TALON_INTAKE_MOTOR = 14;

    //carriage
    public static int CAN_TALON_BCARRIAGE_MOTOR = 13;
    public static int CAN_TALON_TCARRIAGE_MOTOR = 10;

    //PCM Ports
    public static final int PCM_SLIDE_UP = 0;
    public static final int PCM_SLIDE_DOWN = 1;
}

