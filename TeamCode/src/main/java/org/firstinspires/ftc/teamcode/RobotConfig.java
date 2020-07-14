package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotConfig {

    // If the drive uses only two wheels the front wheels will be used
    /*
     *    Fill out the config and it will be applied to the class that you choose to use
     */
    public static final String leftFrontWheel = "";
    public static final String rightFrontWheel = "";
    public static final String leftBackWheel = "";
    public static final String rightBackWheel = "";

    public static final String extraMotorOne = "";
    public static final String extraMotorTwo = "";
    public static final String extraMotorThree = "";
    public static final String extraMotorFour = "";

    HardwareMap hwMap;

    //public static final String

    public RobotConfig () {}

    DcMotor assignMotorLeftFrontWheel () {
        return hwMap.dcMotor.get(leftFrontWheel);
    }

    DcMotor assignMotorRightFrontWheel () {
        return hwMap.dcMotor.get(rightFrontWheel);
    }

    DcMotor assignMotorLeftBackWheel () {
        return hwMap.dcMotor.get(leftBackWheel);
    }

    DcMotor assignMotorRightBackWheel () {
        return hwMap.dcMotor.get(rightBackWheel);
    }

    DcMotor assignMotorExtraMotorOne () {
        return hwMap.dcMotor.get(extraMotorOne);
    }

    DcMotor assignMotorExtraMotorTwo () {
        return hwMap.dcMotor.get(extraMotorTwo);
    }

    DcMotor assignMotorExtraMotorThree () {
        return hwMap.dcMotor.get(extraMotorThree);
    }

    DcMotor assignMotorExtraMotorFour () {
        return hwMap.dcMotor.get(extraMotorFour);
    }

}
