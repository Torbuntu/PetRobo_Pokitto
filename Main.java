import femto.mode.HiRes16Color;
import femto.Game;
import femto.State;
import femto.input.Button;
import femto.palette.Psygnosia;
import femto.font.TIC80;

class Main extends State {

    HiRes16Color screen; // the screenmode we want to draw with

    // start the game using Main as the initial state
    // and TIC80 as the menu's font
    public static void main(String[] args){
        Game.run( TIC80.font(), new Main() );
    }
    
    // Avoid allocation in a State's constructor.
    // Allocate on init instead.
    void init(){
        screen = new HiRes16Color(Psygnosia.palette(), TIC80.font());
    }
    
    // update is called by femto.Game every frame
    void update(){
        screen.clear(0);
        // Change to a new state when A is pressed
        if( Button.A.justPressed() )
            Game.changeState( new RoboDesigner(screen) );

        screen.setTextColor(5);
        screen.setTextPosition(0,0);
        screen.print("Hello, Pet Robo");
        // Update the screen with everything that was drawn
        screen.flush();
    }
    
    // Might help in certain situations
    void shutdown(){
        screen = null;
    }
    
}
