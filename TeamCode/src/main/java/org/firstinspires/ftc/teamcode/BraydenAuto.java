package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "BraydenAuto", group = "teamcode")
public class BraydenAuto extends LinearOpMode {

    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;
    private DcMotor erect;
    private Servo extend;
    private CRServo intake;
    private Servo bucket;
    private Servo wrist;

    private Vision vision;

    // public boolean isAtPosition() {
    //  return front_right.getCurrentPosition() >= front_left.getTargetPosition() &&
    //        front_left.getCurrentPosition() >= front_left.getTargetPosition() &&
    //        back_left.getCurrentPosition() >= back_left.getTargetPosition() &&
    //        back_right.getCurrentPosition() >= back_left.getTargetPosition();
    // }

    public void drive(int millis) {
        front_left.setPower(0.5);
        front_right.setPower(0.5);
        back_left.setPower(0.5);
        back_right.setPower(0.5);

        sleep(millis);

        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    public void turnLeft(int millis) {
        front_left.setPower(0.5);
        back_left.setPower(0.5);
        front_right.setPower(0.5);
        back_right.setPower(0.5);

        sleep(millis);

        front_left.setPower(0);
        back_left.setPower(0);
        front_right.setPower(0);
        back_right.setPower(0);
    }

//    public void driveWithEncoders() {
//        back_left.setPower(0.7);
//        back_right.setPower(0.7);
//
//        back_left.setTargetPosition(4500);
//        back_right.setTargetPosition(4500);
//
//        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }

    public void turnRight(int millis) {
        front_left.setPower(0.5);
        back_left.setPower(0.5);
        front_right.setPower(-0.5);
        back_right.setPower(-0.5);

        sleep(millis);

        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    //public void auto() {
    // vision = new Vision(hardwareMap, telemetry);
    // drive(600);
    // }

    @Override
    public void runOpMode() throws InterruptedException {
        front_left = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.frontLeftMotor);
        front_right = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.frontRightMotor);
        back_left = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.backLeftMotor);
        back_right = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.backRightMotor);
        extend = hardwareMap.get(Servo.class, "extend");
        wrist = hardwareMap.get(Servo.class, "wrist");
        erect = hardwareMap.get(DcMotor.class, "erect");
        bucket = hardwareMap.get(Servo.class, "bucket");


        //  front_left.setDirection(DcMotor.Direction.REVERSE);
        //  back_left.setDirection(DcMotor.Direction.REVERSE);

        //back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        vision = new Vision(hardwareMap, telemetry);

        waitForStart();



        while (opModeIsActive()) {
            vision.update(telemetry);
//            telemetry.addData("back_left current position", back_left.getCurrentPosition());
//            telemetry.addData("back_right current position", back_right.getCurrentPosition());
//
//            bucket.setPosition(0.75);
//            extend.setPosition(0.35);
//            front_left.setPower(-0.5);
//            front_right.setPower(0.5);
//            back_left.setPower(-0.5);
//            back_right.setPower(0.5);
//
//            sleep(1000);
//
//            front_left.setPower(0);
//            front_right.setPower(0);
//            back_left.setPower(0);
//            back_right.setPower(0);
//
//            sleep(500);
//
//            turnLeft(1000);
//
//            sleep(500);
//
//            extend.setPosition(0);
//
//            erect.setTargetPosition(2500);
//            erect.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            if (erect.getCurrentPosition() < 2600 && erect.getCurrentPosition() > 2300) {
//                erect.setPower(0);
//            } else {
//                erect.setPower(1);
//            }
//
//            sleep(1000);
//
//            bucket.setPosition(0);
//
//            telemetry.addData("Raised", true);
//            telemetry.update();
//
//            sleep(1000);
//            bucket.setPosition(0.75);
//            extend.setPosition(0.35);
//
//            sleep(500);
//            wrist.setPosition(0);
//            turnLeft(250);
//            extend.setPosition(0);
//            drive(100);
//
//            sleep(1000);
//
//            wrist.setPosition(0.4);
//            extend.setPosition(0.35);
//
//            sleep(500000);
//           // intake.setPower(0);
        }
    }
}