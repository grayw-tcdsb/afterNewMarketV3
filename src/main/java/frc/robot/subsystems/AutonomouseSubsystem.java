// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class AutonomouseSubsystem extends SubsystemBase {
  PWMSparkMax frontRight = new PWMSparkMax(RobotMap.frontRightChannle);
  PWMSparkMax middleRight = new PWMSparkMax(RobotMap.middleRightChannle);
  PWMSparkMax backRight = new PWMSparkMax(RobotMap.backRightChannle);
  MotorControllerGroup rightAuto = new MotorControllerGroup(frontRight, middleRight, backRight);

  PWMSparkMax frontLeft = new PWMSparkMax(RobotMap.frontLeftChannle);
  PWMSparkMax middleLeft = new PWMSparkMax(RobotMap.middleLeftChannle);
  PWMSparkMax backLeft = new PWMSparkMax(RobotMap.backLeftChannle);
  MotorControllerGroup leftAuto = new MotorControllerGroup(frontLeft, middleLeft, backLeft);

  DifferentialDrive autoDrive;



  /** Creates a new AutonomouseSubsystem. */
  public AutonomouseSubsystem() {
    leftAuto.setInverted(true);
    rightAuto.setInverted(false);
    autoDrive = new DifferentialDrive(rightAuto, leftAuto);
  }

  public void autoDrive(double xSpeed, double zRotation, boolean squareInputs) {
    autoDrive.arcadeDrive(xSpeed, zRotation, squareInputs);
  }

  public void stopAuto() {
    autoDrive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
