import femto.mode.HiRes16Color;

import sprites.Head;
import sprites.Body;
import sprites.Arm;
import sprites.Leg;

/**
 * Robo manages state and stats of the pet APP
 * Artificial Player Program
 */
class Robo {
    Head head;
    Body body;
    Arm arm;
    Leg leg;
    
    /**
     * Speed: how quickly the pet can move 
     * Strength: How strong the pet is. For lifting and breaking contest
     * Power: The current level of charge. If too low, needs to be recharged
     * State: Level of maintenance required
     * 
     */
    int speed = 1, strength = 1, power = 1, state = 0;
    
    /**
     * ht: head type
     * bt: body type
     * at: arm type
     * lt: leg type
     */
    int ht, bt, at, lt;
    
    Robo(int spd, int stg, int pwr, int stt) {
        head = new Head();
        body = new Body();
        arm = new Arm();
        leg = new Leg();
        
        
        speed = spd;
        strength = stg;
        power = pwr;
        state = stt;
    }
    
    void setHead(int t){
        ht = t;
    }
    void setBody(int t){
        bt = t;
    }
    void setLimbs(int t){
        at = t;
        lt = t;
    }
    void setArm(int t){
        at = t;
    }
    void setLeg(int t){
        lt = t;
    }
    
    
    void update(){
        switch(ht){
            case 0: head.red(); break;
            case 1: head.blue(); break;
            case 2: head.green(); break;
        }
        switch(bt){
            case 0: body.red(); break;
            case 1: body.blue(); break;
            case 2: body.green(); break;
        }
        switch(at){
            case 0: arm.red(); break;
            case 1: arm.blue(); break;
            case 2: arm.green(); break;
        }
        switch(lt){
            case 0: leg.red(); break;
            case 1: leg.blue(); break;
            case 2: leg.green(); break;
        }
    }
    
    void drawHead(HiRes16Color screen, float x, float y){
        head.draw(screen, x, y);
    }
    void drawBody(HiRes16Color screen, float x, float y){
        body.draw(screen, x, y);
    }
    void drawArm(HiRes16Color screen, float x, float y){
        arm.setMirrored(false);
        arm.draw(screen, x, y);
        arm.setMirrored(true);
        arm.draw(screen, x+24, y);
    }
    void drawLeg(HiRes16Color screen, float x, float y){
        leg.setMirrored(false);
        leg.draw(screen, x, y);
        leg.setMirrored(true);
        leg.draw(screen, x+12, y);
    }

    
    void draw(HiRes16Color screen){
        //draw head
        head.draw(screen);
        //draw body
        body.draw(screen, head.x, head.y+16);
        //draw limbs
        arm.draw(screen);
        leg.draw(screen);
    }
}