/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.security.KeyStore;


/** This OPMode Was designed to Find the jewel and push off the opposing alliance's jewel.**/


@TeleOp(name="Screw you Red Jewel", group="Linear Opmode")

public class Basic_Autonomous_Jewel extends LinearOpMode {

    // Declare OpMode members.
    boolean Matrix12vMotor = true;
    boolean AndymarkNeverest40 = false;
    boolean teamred = false;
    boolean teamblue = true;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor rightfront = null;
    private DcMotor leftfront = null;
    private DcMotor righthind = null;
    private DcMotor lefthind = null;
    private Servo jewelarm = null;
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
        //Puts arm into position
        jewelarm.setPosition(0);
        sleep(400);

        if(teamblue = true){
            //execute code for blue team jewel Here

        }
        else{
            if(teamred = true){
                //execute code for red team jewel here

            }
        }
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
                rightfront.setTargetPosition((int) Math.round(280*rotations));
                leftfront.setTargetPosition((int) Math.round(280*rotations));
                righthind.setTargetPosition((int) Math.round(280*rotations));
                lefthind.setTargetPosition((int) Math.round(280*rotations));
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




