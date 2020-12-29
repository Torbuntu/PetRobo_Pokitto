import femto.mode.HiRes16Color;
import femto.Game;
import femto.State;
import femto.input.Button;
import femto.palette.Psygnosia;
import femto.font.TIC80;

class RoboDesigner extends State {
    HiRes16Color screen;
    RoboDesigner(HiRes16Color screen){
        this.screen = screen;
    }
    void init(){
    }
    
    void update() {
        screen.clear(0);
        screen.setTextPosition(0,0);
        
        screen.print("We are on the Robo Designer page.");
        
        screen.flush();
    }
    
    void shutdown() {
        screen = null;
    }
}