package RobotCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Mecanum Drive 3", group="Iterative Opmode")
public class MecanumTele3 extends OpMode {
    
    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;
    private double power = 0.0;
    private boolean slow = false;
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime slowCooldown = new ElapsedTime();
    
    @Override
    public void init() {
        slow = false;
        
        front_left = hardwareMap.get(DcMotor.class, "fLeft");
        front_right = hardwareMap.get(DcMotor.class, "fRight");
        back_left = hardwareMap.get(DcMotor.class, "bLeft");
        back_right = hardwareMap.get(DcMotor.class, "bRight");
        back_left.setDirection(DcMotor.Direction.REVERSE);
        front_left.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    //WHILE LOOP
    public void loop() {
        
        
        
        //wheel power = power variable
        front_left.setPower(power);
        front_right.setPower(power);
        back_left.setPower(power);
        back_right.setPower(power);
        power = -gamepad1.left_stick_y;

        
        
        //cooldown + set power
        if((runtime-slowCooldown) >= 0.2){
            if(gamepad1.a && slow == false) {
                slow = true;
                slowCooldown = runtime;
            } else {
                slow = false;
                slowCooldown = runtime;
            }
        }
        
        if(slow == true){
            power/=2;
        }
        
    }
}
