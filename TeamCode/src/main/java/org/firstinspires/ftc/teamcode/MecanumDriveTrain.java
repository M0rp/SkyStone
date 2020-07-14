package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Arrays;
import java.util.List;

/* This is a class for Mecanum Wheel Drive Trains.
 * It includes TeleOp Control and Encoder and Time Control for autonomous.
 * It uses the Robot Config class for the hardware mapping.
 *
 *
 */

public class MecanumDriveTrain {

    RobotConfig robCong = new RobotConfig();
    ElapsedTime elapsedTime = new ElapsedTime();

    DcMotor rightFront = robCong.assignMotorRightFrontWheel();
    DcMotor leftFront = robCong.assignMotorLeftFrontWheel();
    DcMotor rightBack = robCong.assignMotorRightBackWheel();
    DcMotor leftBack = robCong.assignMotorLeftBackWheel();

    public List<DcMotor> motors = Arrays.asList(leftFront, leftBack, rightBack, rightFront);

    public double driveSpeedDivider = 2;

    public MecanumDriveTrain() {



    }

    public void mecanumDriveRightJoystickTurn(Gamepad gamepad1) {

        leftFront.setPower(((gamepad1.left_stick_y)-(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        rightFront.setPower(((-(gamepad1.left_stick_y))-(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        leftBack.setPower(((gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);
        rightBack.setPower(((-(gamepad1.left_stick_y))+(gamepad1.left_stick_x)-(gamepad1.right_stick_x))/driveSpeedDivider);

        if (gamepad1.b) {
            driveSpeedDivider = 4;
        } else if (gamepad1.a) {
            driveSpeedDivider = 2;
        } else if (gamepad1.x) {
            driveSpeedDivider = 1.5;
        } else if (gamepad1.y) {
            driveSpeedDivider = 1;
        }

    }

    public void mecanumDriveTriggerTurn (Gamepad gamepad1) {

        leftFront.setPower(((gamepad1.left_stick_y)-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightFront.setPower(((-(gamepad1.left_stick_y))-(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        leftBack.setPower(((gamepad1.left_stick_y)+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);
        rightBack.setPower(((-(gamepad1.left_stick_y))+(gamepad1.left_stick_x)-(gamepad1.right_trigger)+(gamepad1.left_trigger))/driveSpeedDivider);

    }

    public void moveForwardsUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveBackwardsUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveRightUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(-tick);
        leftBack.setTargetPosition(tick);
        rightBack.setTargetPosition(tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveLeftUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(-tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void turnRightUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(-tick);
        rightFront.setTargetPosition(-tick);
        leftBack.setTargetPosition(-tick);
        rightBack.setTargetPosition(-tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void turnLeftUsingEncoders (int tick, double power, boolean deceleration) {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setTargetPosition(tick);
        rightFront.setTargetPosition(tick);
        leftBack.setTargetPosition(tick);
        rightBack.setTargetPosition(tick);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (deceleration == true) {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                leftFront.setPower(decelerate(tick, leftFront.getCurrentPosition()));
                rightFront.setPower(decelerate(tick, rightFront.getCurrentPosition()));
                leftBack.setPower(decelerate(tick, leftBack.getCurrentPosition()));
                rightBack.setPower(decelerate(tick, rightBack.getCurrentPosition()));

            }

        } else {

            while (!leftFront.isBusy() && !rightFront.isBusy() && !leftBack.isBusy() && !rightBack.isBusy()) {

                setPower(power);

            }

        }

        setPower(0);

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveForwardsUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(power);
        leftBack.setPower(-power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }

    public void moveBackwardsUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(-power);
        leftBack.setPower(power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }

    public void moveRightUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }

    public void moveLeftUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(-power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }

    public void turnRightUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(-power);
        rightBack.setPower(-power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }

    public void turnLeftUsingTime (int milliseconds, double power) {

        elapsedTime.reset();

        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while (elapsedTime.milliseconds() < milliseconds);

        setPower(0);

    }


    public void setMode(DcMotor.RunMode runMode) {

        for (DcMotor motor : motors) {
            motor.setMode(runMode);
        }

    }

    public void setTargetPostition (int ticks) {

        for (DcMotor motor : motors) {
            motor.setTargetPosition(ticks);
        }

    }

    public void setPower (double power) {

        for (DcMotor motor : motors) {
            motor.setPower(power);
        }

    }

    public double decelerate (int tick, int currentTick) {

        return (((tick - currentTick) * .0005) + .04);

    }

}