package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.teamcode.drive;

import org.firstinspires.ftc.onbotjava.handlers.objbuild.WaitForBuild;
//
@TeleOp(name = "basicteliop", group = "teamcode")
public class bruh extends OpMode {

    drive driver ;
    DcMotor erect;
    Servo extend, wristL, wristR, bucket, side;
    CRServo intakeL, intakeR;
    TouchSensor bottom;

    public bruh() {
        super();
    }

    @Override
    public void init() {
        driver = new drive(hardwareMap);

        extend = hardwareMap.get(Servo.class, "extend");
        wristL = hardwareMap.get(Servo.class, "wristL");
        intakeL = hardwareMap.get(CRServo.class, "intakeL");
        intakeR = hardwareMap.get(CRServo.class, "intakeR");
        bottom = hardwareMap.get(TouchSensor.class, "bottom");
        erect = hardwareMap.get(DcMotor.class, "erect");
        bucket = hardwareMap.get(Servo.class, "bucket");
        side = hardwareMap.get(Servo.class, "side");
        wristR = hardwareMap.get(Servo.class,"wristR");

        telemetry.addData("WristL Position", wristL.getPosition());
        telemetry.addData("WristR Position", wristR.getPosition());
        telemetry.update();
    }


    @Override
    public void loop() {

        driver.teleop(gamepad1,false);
       driver.periodic(telemetry);

        telemetry.addData("Current Position", erect.getCurrentPosition());
        //erect.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //erect.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        if (gamepad2.right_bumper) {
            erect.setTargetPosition(2500);
            erect.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            if (erect.getCurrentPosition() < 2600 && erect.getCurrentPosition() > 2300) {
                erect.setPower(0);
                  } else {
                 erect.setPower(1);

                }


            } else if (gamepad2.left_bumper) {

                erect.setTargetPosition(100);
                erect.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if (erect.getCurrentPosition() < 200 && erect.getCurrentPosition() > 50) {
                    erect.setPower(0);
                } else {
                    erect.setPower(-1);
                    //erect.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                }
                telemetry.addData("Status", "Motor Running");

            } else if (gamepad2.x) {
            erect.setTargetPosition(1000);
            erect.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            if (erect.getCurrentPosition() < 1050 && erect.getCurrentPosition() > 950) {
                erect.setPower(0);

            } else {
                erect.setPower(-1);


            }

            }

            if (bottom.isPressed()) {
                erect.setPower(0);

            } else {

            }


            if (gamepad2.a) {
                side.setPosition(0.25);
            } else {
                side.setPosition(0);
            }





            if (gamepad1.dpad_down) {
                bucket.setPosition(0);

            } else {
                bucket.setPosition(0.75);
            }


            if (gamepad1.b) {

                wristL.setPosition(0.05);
                wristR.setPosition(0.95);
                intakeL.setPower(-1);
                intakeR.setPower(1);
            } else if (gamepad1.y) {
                intakeL.setPower(1);
                intakeR.setPower(-1);
            } else {
                wristR.setPosition(0.25);
                wristL.setPosition(0.75);
                intakeR.setPower(0);
                intakeL.setPower(0);
            }


            if (gamepad1.a) {


                extend.setPosition(0);


            } else {

                extend.setPosition(0.25);
            }
        }
    }










 //   public void setBottom(TouchSensor bottom) {
   //     this.bottom = bottom;


   // public TouchSensor getBottom() {
       // return bottom;



//}

    //private Object stop(DcMotor erect)


