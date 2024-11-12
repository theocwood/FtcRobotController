package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Vision {

    HuskyLens huskyLens;

    ElapsedTime elapsedTime;

    public Vision(HardwareMap hardwareMap, Telemetry telemetry) {
        huskyLens = hardwareMap.get(HuskyLens.class, "vision");
        elapsedTime = new ElapsedTime();

        telemetry.addData(">>", huskyLens.knock() ? "Touch start to continue" : "Problem communicating with HuskyLens");
        telemetry.update();
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.OBJECT_RECOGNITION);
    }

    public void update(Telemetry telemetry) {
        if(elapsedTime.seconds() >=  1) {
            elapsedTime.reset();
            HuskyLens.Block[] blocks = getBlocks();
            telemetry.addData("Block Count", blocks.length);
            for (HuskyLens.Block block : blocks) {
                telemetry.addData("Block", "id: " + block.id + " " + "size: " + block.height + "," + block.width + " " + "position: " + block.x + "," + block.y);
            }
            telemetry.update();
        }

//        telemetry.addData("X", getX());
//        telemetry.addData("Y", getY());
//        telemetry.addData("Has Block", hasBlock());
//        telemetry.addData("Piece Position", getPiecePosition());
        telemetry.update();
    }

    public HuskyLens.Block[] getBlocks() {
        return huskyLens.blocks();
    }

    public boolean hasBlock() {
        return getBlocks().length > 0;
    }

//    public int getX() {
//        return hasBlock() ? getBlocks()[0].x : 0;
//    }

//    public int getY() {
//        return hasBlock() ? getBlocks()[0].y : 0;
//    }

//    public Position getPiecePosition() {
//        double segment = 240 / 7.0;
//        if(getX() < segment) {
//          return Position.LEFT;
//        } else if(getX() > (segment * 7)) {
//            return Position.RIGHT;
//        } else {
//            return Position.MIDDLE;
//        }
//    }

    public enum Position {
        LEFT,
        MIDDLE,
        RIGHT;
    }
}
