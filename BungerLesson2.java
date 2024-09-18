package RobotCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Bunger Lesson 2", group="Iterative Opmode")
public class BungerLesson2 extends OpMode {
    
    private DcMotor armPower;
    private int armState = 0;
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime AStoggleCooldown = new ElapsedTime();
    
    @Override
    public void init() {
        armState = 3;
        AStoggleCooldown = 0;
        

        armPower = hardwareMap.get(DcMotor.class, "arm");
    }
    @Override
    //WHILE LOOP
    public void loop() {
        runtime = 0;
        
        
        

        
        
        //cooldown + set power
        if((runtime-AStoggleCooldown) >= 0.2){
            if(gamepad1.x) {
                if(armState == 1) {
                    armPower.setPower(0.5);
                    armState++;
                } else if(armState == 2) {
                    armPower.setPower(1.0);
                    armState++;
                } else if(armState == 3)
                    armPower.setPower(0.0);
                    armState = 1;
                }
            }
        }
        
        }
        
    }
}
