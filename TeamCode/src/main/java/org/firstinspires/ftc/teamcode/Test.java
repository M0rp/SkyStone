package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Test extends OpMode
{

    MecanumDriveTrain driveTrain;

    @Override
    public void init ()
    {

        driveTrain = new MecanumDriveTrain();

    }

    @Override
    public void start ()
    {



    }

    @Override
    public void loop ()
    {

        driveTrain.mecanumDriveRightJoystickTurn(gamepad1);

    }

    @Override
    public void stop ()
    {



    }

}