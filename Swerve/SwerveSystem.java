/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SwerveSubsystem extends Subsystem {
  // initialize variables
	private SwerveWheel m_wheel; 
	private Gyro m_gyro; 
	private double m_driveCoefficient; 
	private double m_turnCoefficient;
	
  public SwerveSubsystem(SwerveWheel wheel, Gyro gyro, double driveCoeff, double turnCoeff){
	//pass in variables
	this.m_wheel = wheel; 
	this.m_gyro = gyro; 
	this.m_driveCoefficient = driveCoeff; 
	this.m_turnCoefficient = turnCoeff; 
  }
  
  void drive(double transX, double transY, double rot){
	// Doing math with each of the vectors for the SwerveWheels
	// Calculating the rotation vector, then adding that to the translation vector
	// Converting them to polar vectors
	double[] vectors = new double[2];
	vectors[0] = m_wheel.getRotationVector()[0] * (1 / this.m_wheel.getDistance())
			* (rotation * driveCoefficient) + (transX * driveCoefficient);
	vectors[i][1] = m_wheels[i].getRotationVector()[1] * (1 / this.m_wheel.getDistance())
			* (rotation * driveCoefficient) + (transY * driveCoefficient);
	vectors = AngleUtilities.cartesianToPolar(vectors);
	setHeadingAndVelocity(double vectors[0], double vectors[1]); 
	}
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
