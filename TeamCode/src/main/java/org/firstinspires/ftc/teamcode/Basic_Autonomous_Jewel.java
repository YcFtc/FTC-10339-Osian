package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.security.KeyStore;


/** This OPMode Was designed to Find the jewel and push off the opposing alliance's jewel.**/
@Autonomous(name="Blue Team Jewel", group="Linear Opmode")

public class Basic_Autonomous_Jewel extends LinearOpMode {

    // Declare controllable variables and Opmode members: variables that affect the program such as teamred and teamblue, and creation of motor, servo, and sensor variables
    int redjewelmin = 0;
    int redjewelmax = 0;
    int bluejewelmin = 0;
    int bluejewelmax = 0;
    int leftservograbberclosedposition = 100; // the position that the left grabber arm will be closed at.
    int rightservograbberclosedposition = 100; // the position that the right grabber arm will be closed at.
    int leftservograbberopenposition = 0; // the position that the left servo grabber will be open at.
    int rightservograbberopenposition = 0; // the position that the right servo grabber will be open at.
    boolean jewelcoloursensorloop = false;
    boolean Matrix12vMotor = true;
    boolean AndymarkNeverest40 = false;
    boolean teamred = false;
    boolean teamblue = true;

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor rightfront = null;
    private DcMotor leftfront = null;
    private DcMotor righthind = null;
    private DcMotor lefthind = null;
    private DcMotor glyphlyft = null;
    private Servo jewelarm = null;
    private Servo glyphl = null;
    private Servo glyphr = null;
    private ColorSensor colorsensor = null;
    @Override
    public void runOpMode() {
        rightfront = hardwareMap.get(DcMotor.class, "rf");
        leftfront = hardwareMap.get(DcMotor.class, "rlf");
        righthind = hardwareMap.get(DcMotor.class, "rh");
        lefthind = hardwareMap.get(DcMotor.class, "lh");
        jewelarm = hardwareMap.get(Servo.class, "jewelarm");
        colorsensor = hardwareMap.get(ColorSensor.class, "jacs");
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);
        righthind.setDirection(DcMotorSimple.Direction.REVERSE);
        ResetAllEncoders();
        rightfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        righthind.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lefthind.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        runtime.reset();
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //Grab glyph
/*glyphl.setPosition(leftservograbberclosedposition);
glyphr.setPosition(rightservograbberclosedposition);
glyphlyft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
glyphlyft.setTargetPosition(840/);
glyphlyft.setPower(.25);*/
        //Puts arm into position
        jewelarm.setPosition(0);
        sleep(300);

        if(teamblue = true){
            //execute code for blue team jewel Here
            while (jewelcoloursensorloop = false){
                if (/*If there is a blue jewel*/ colorsensor.blue()>bluejewelmin && colorsensor.blue()<bluejewelmax/* and there is no red jewel*/ && colorsensor.red()<redjewelmin){
                // Execute Order 66
                DriveFowardPosition(-.5,-1);
                ResetAllEncoders();
                DriveFowardPosition(.5,1);
                ResetAllEncoders();
                jewelcoloursensorloop = true;
                }
                else{
                    if (/*If there is a red jewel*/ colorsensor.red()>redjewelmin && colorsensor.red()<redjewelmax/* and there is no blue jewel*/ && colorsensor.blue()<bluejewelmin) {
                        // Execute Order 66
                        DriveFowardPosition(.5, 1);
                        ResetAllEncoders();
                        DriveFowardPosition(-.5, -1);
                        ResetAllEncoders();
                        jewelcoloursensorloop = true;
                    }
                    }
            }
        }
        else{
            if(teamred = true){
                //execute code for red team jewel here
                while (jewelcoloursensorloop = false){
                    if (/*If there is a blue jewel*/ colorsensor.blue()>bluejewelmin && colorsensor.blue()<bluejewelmax/* and there is no red jewel*/ && colorsensor.red()<redjewelmin){
                        // Execute Order 66
                        DriveFowardPosition(.5,1);
                        ResetAllEncoders();
                        DriveFowardPosition(-.5,-1);
                        ResetAllEncoders();
                        jewelcoloursensorloop = true;
                    }
                    else{
                        if (/*If there is a red jewel*/ colorsensor.red()>redjewelmin && colorsensor.red()<redjewelmax/* and there is no blue jewel*/ && colorsensor.blue()<bluejewelmin) {
                            // Execute Order 66
                            DriveFowardPosition(-.5, -1);
                            ResetAllEncoders();
                            DriveFowardPosition(.5, 1);
                            ResetAllEncoders();
                            jewelcoloursensorloop = true;
                        }
                    }
                }
            }
        }
        //Put our glyph into the Cryptobox
        }
        public void ResetAllEncoders (){
            rightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            righthind.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lefthind.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        }
        public void DriveFowardPosition (double power, double rotations){
        rightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        righthind.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lefthind.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(Matrix12vMotor = true) {
            rightfront.setTargetPosition((int) Math.round(1478.4*rotations));
            leftfront.setTargetPosition((int) Math.round(1478.4*rotations));
            righthind.setTargetPosition((int) Math.round(1478.4*rotations));
            lefthind.setTargetPosition((int) Math.round(1478.4*rotations));
        }
        else {
            if(AndymarkNeverest40 = true){
                rightfront.setTargetPosition((int) Math.round(1120*rotations));
                leftfront.setTargetPosition((int) Math.round(1120*rotations));
                righthind.setTargetPosition((int) Math.round(1120*rotations));
                lefthind.setTargetPosition((int) Math.round(1120*rotations));
            }
            }
            Drivefoward(power);
            while(rightfront.isBusy() && leftfront.isBusy() && righthind.isBusy() && lefthind.isBusy()){
             //Sing "La La La, I killed a man"
            }
    }
       public void Drivefoward (double power){
        rightfront.setPower(power);
        leftfront.setPower(power);
        righthind.setPower(power);
        lefthind.setPower(power);
       }
    }