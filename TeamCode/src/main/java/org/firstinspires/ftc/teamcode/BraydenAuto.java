package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "BraydenAuto", group = "teamcode")
public class BraydenAuto extends LinearOpMode {

    private ColorSensor colorSensor;
    private DcMotor front_left, front_right, back_left, back_right;
    private Servo extend, wristL, wristR, bucket, side;
    private DcMotor erect;
    private CRServo intakeL, intakeR;

    public void drive(int millis, double power) {
        front_left.setPower(-power);
        front_right.setPower(-power);
        back_left.setPower(-power);
        back_right.setPower(-power);

        sleep(millis);

        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    public void turnLeft(int millis, double power) {
        front_left.setPower(1);
        back_left.setPower(1);
        front_right.setPower(-1);
        back_right.setPower(-1);

        sleep(millis);

        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);
    }

    public void turnRight(int millis, double power) {
        front_left.setPower(-1);
        back_left.setPower(-1);
        front_right.setPower(1);
        back_right.setPower(1);

        sleep(millis);


    }

    @Override
    public void runOpMode() throws InterruptedException {
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        front_left = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.frontLeftMotor);
        front_right = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.frontRightMotor);
        back_left = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.backLeftMotor);
        back_right = hardwareMap.get(DcMotor.class, Constants.MecanumConstants.backRightMotor);
        extend = hardwareMap.get(Servo.class, "extend");
        wristL = hardwareMap.get(Servo.class, "wristL");
        intakeL = hardwareMap.get(CRServo.class, "intakeL");
        intakeR = hardwareMap.get(CRServo.class, "intakeR");
        wristR = hardwareMap.get(Servo.class,"wristR");
        bucket = hardwareMap.get(Servo.class, "bucket");
        side = hardwareMap.get(Servo.class, "side");
        erect = hardwareMap.get(DcMotor.class, "erect");

        front_right.setDirection(Constants.MecanumConstants.invertRight);
        front_left.setDirection(Constants.MecanumConstants.invertLeft);
        back_right.setDirection(Constants.MecanumConstants.invertRight);
        back_left.setDirection(Constants.MecanumConstants.invertLeft);

        waitForStart();

        wristR.setPosition(0.25);
        wristL.setPosition(0.75);

        side.setPosition(0);
    }
}