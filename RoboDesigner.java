import femto.mode.HiRes16Color;
import femto.Game;
import femto.State;
import femto.input.Button;
import femto.palette.Psygnosia;
import femto.font.TIC80;

import entities.Robo;

class RoboDesigner extends State {
    HiRes16Color screen;
    Robo robo;
    
    int select = 0;
    int hc = 9, bc = 9, lc = 9;
    int blink = 50;
    int pwr = 1, stg = 4, spd = 1;
    RoboDesigner(HiRes16Color screen){
        this.screen = screen;
    }
    void init(){
        robo = new Robo(spd,stg,pwr,0);
    }
    
    void update() {
        blink--;
        if(blink == 0)blink = 50;
        robo.update();
        
        if(Button.Down.justPressed()){
            if(select < 2)select++;
        }
        if(Button.Up.justPressed()){
            if(select > 0)select--;
        }
        
        if(Button.Left.justPressed()){
            switch(select){
                case 0: 
                    if(hc == 9)hc = 7;
                    else if(hc == 7) hc = 2;
                    break;
                case 1:
                    if(bc == 9)bc = 7;
                    else if(bc == 7) bc = 2;
                    break;
                case 2:
                    if(lc == 9)lc = 7;
                    else if(lc == 7) lc = 2;
                    break;
            }
            pwr = 1;
            stg = 1;
            spd = 1;
            switch(hc){
                case 9:pwr++;robo.setHead(0);break;
                case 7:stg++;robo.setHead(2);break;
                case 2:spd++;robo.setHead(1);break;
            }
            switch(bc){
                case 9:pwr++;robo.setBody(0);break;
                case 7:stg++;robo.setBody(2);break;
                case 2:spd++;robo.setBody(1);break;
            }
            switch(lc){
                case 9:pwr++;robo.setLimbs(0);break;
                case 7:stg++;robo.setLimbs(2);break;
                case 2:spd++;robo.setLimbs(1);break;
            }
        }
        
        if(Button.Right.justPressed()){
            switch(select){
                case 0: 
                    if(hc == 2)hc = 7;
                    else if(hc == 7) hc = 9;
                    break;
                case 1: 
                    if(bc == 2)bc = 7;
                    else if(bc == 7) bc = 9;
                    break;
                case 2: 
                    if(lc == 2)lc = 7;
                    else if(lc == 7) lc = 9;
                    break;
            }
            pwr = 1;
            stg = 1;
            spd = 1;
            switch(hc){
                case 9:pwr++;robo.setHead(0);break;
                case 7:stg++;robo.setHead(2);break;
                case 2:spd++;robo.setHead(1);break;
            }
            switch(bc){
                case 9:pwr++;robo.setBody(0);break;
                case 7:stg++;robo.setBody(2);break;
                case 2:spd++;robo.setBody(1);break;
            }
            switch(lc){
                case 9:pwr++;robo.setLimbs(0);break;
                case 7:stg++;robo.setLimbs(2);break;
                case 2:spd++;robo.setLimbs(1);break;
            }
            
        }
        
        screen.clear(6);
        
        screen.fillRect(4, 4, 100, 168, 0);
        screen.drawRect(4, 4, 100, 168, 8);
        screen.setTextPosition(5, 6);
        screen.setTextColor(12);
        screen.print("class ");
        screen.setTextColor(7);
        screen.print("Robo ");
        screen.setTextColor(15);
        screen.print("{");
        
        screen.setTextPosition(12, 12);
        screen.setTextColor(12);
        screen.print("int ");
        screen.setTextColor(15);
        screen.print("pwr = ");
        screen.print(pwr + ";");
        
        screen.setTextPosition(12, 20);
        screen.setTextColor(12);
        screen.print("int ");
        screen.setTextColor(15);
        screen.print("stg = ");
        screen.print(stg + ";");
        
        screen.setTextPosition(12, 28);
        screen.setTextColor(12);
        screen.print("int ");
        screen.setTextColor(15);
        screen.print("spd = ");
        screen.print(spd + ";");
        
        // initialize power
        screen.setTextColor(12);
        screen.setTextPosition(12, 36);
        screen.print("void ");
        screen.setTextColor(15);
        screen.print("init() {");
        
        screen.fillRect(20, 42, 30, 4, hc);
        screen.fillRect(56, 42, 12, 4, hc);
        
        screen.fillRect(20, 47, 10, 4, hc);
        screen.fillRect(35, 47, 45, 4, hc);
        
        screen.fillRect(20, 52, 20, 4, hc);
        
        
        if(select == 0){
            if(blink < 25){
                screen.fillRect(20, 42, 4, 4, 15);
            }else{
                screen.drawRect(20, 42, 4, 4, 15);
            }
        }
        
        screen.setTextPosition(12, 60);
        screen.print("}");
        
        
        // initialize strength
        screen.setTextColor(12);
        screen.setTextPosition(12, 66);
        screen.print("void ");
        screen.setTextColor(15);
        screen.print("update() {");
        
        screen.fillRect(20, 72, 18, 4, bc);
        screen.fillRect(44, 72, 24, 4, bc);
        
        screen.fillRect(20, 77, 36, 4, bc);
        screen.fillRect(60, 77, 12, 4, bc);
        
        screen.fillRect(20, 82, 45, 4, bc);
        screen.fillRect(70, 82, 20, 4, bc);
        
        
        if(select == 1){
            if(blink < 25){
                screen.fillRect(20, 72, 4, 4, 15);
            }else{
                screen.drawRect(20, 72, 4, 4, 15);
            }
        }
        
        screen.setTextPosition(12, 90);
        screen.print("}");
        
        
        // initialize speed
        screen.setTextColor(12);
        screen.setTextPosition(12, 96);
        screen.print("void ");
        screen.setTextColor(15);
        screen.print("action() {");
        
        screen.fillRect(20, 102, 18, 4, lc);
        screen.fillRect(44, 102, 12, 4, lc);
        screen.fillRect(62, 102, 24, 4, lc);
        
        screen.fillRect(20, 107, 8, 4, lc);
        screen.fillRect(33, 107, 35, 4, lc);
        
        screen.fillRect(20, 112, 28, 4, lc);
        
        
        if(select == 2){
            if(blink < 25){
                screen.fillRect(20, 102, 4, 4, 15);
            }else{
                screen.drawRect(20, 102, 4, 4, 15);
            }
        }
        
        screen.setTextPosition(12, 120);
        screen.print("}");
        
        
        
        screen.setTextPosition(5, 166);
        screen.print("}");
        
        screen.fillCircle(165, 30, 20, hc);
        // robo.drawHead(screen, 140, 40);
        screen.fillRect(140, 56, 50, 35, bc);
        // robo.drawBody(screen, 140, 74);
        screen.fillRect(120, 60, 10, 30, lc);
        screen.fillRect(200, 60, 10, 30, lc);
        
        screen.fillRect(150, 100, 10, 25, lc);
        screen.fillRect(170, 100, 10, 25, lc);
        
        // robo.drawArm(screen, 132, 74);
        // robo.drawLeg(screen, 138, 130);
        
        for(int i = 0; i < 4; i++){
            screen.fillRect(130 + (i * 18), 150, 16, 16, 3);
        }
        
        screen.flush();
    }
    
    void shutdown() {
        screen = null;
    }
}