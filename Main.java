import femto.mode.HiRes16Color;
import femto.Game;
import femto.State;
import femto.input.Button;
import femto.palette.Castpixel16;
import femto.font.TIC80;

class Main extends State {

    HiRes16Color screen; 
    int select = 1;
    
    public static void main(String[] args){
        Game.run( TIC80.font(), new Main() );
    }
    
    void init(){
        screen = new HiRes16Color(Castpixel16.palette(), TIC80.font());
    }
    
    void update(){
        screen.clear(0);
        
        if( Button.A.justPressed() ){
            switch(select){
                case 0: Game.changeState( new RoboDesigner(screen) ); break;
                default: Game.changeState( new RoboDesigner(screen) ); break;
            }
        }
        
        if( Button.Up.justPressed() && select > 0 ){
            select--;
        }
        if( Button.Down.justPressed() && select < 1){
            select++;
        }
            

        screen.setTextColor(15);
        
        screen.drawRect(4, 4, 220-8, 32, 8);
        
        screen.setTextPosition(8,8);
        screen.print("Hello, Pet Robo. This is a fancy\n  title graphic");


        screen.setTextPosition(32, 80);
        if(select == 0)screen.print("> ");
        screen.print("New Pet Robo");
        
        screen.setTextPosition(32, 88);
        if(select == 1)screen.print("> ");
        screen.print("Continue");
    
        screen.flush();
    }
    
    void shutdown(){
        screen = null;
    }
    
}
