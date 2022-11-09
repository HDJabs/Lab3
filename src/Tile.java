import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class Tile extends Button{
    private char c;
    private boolean flipped; //the tile is face up
    private boolean locked; //the tile is face up and green, having a pair
    private int xCord, yCord;
   


    public Tile(char c, TileController cont) {
        super(Character.toString(c));
        System.out.println("A new Tile has been created with the Character:" + c +"!");
        this.c = c;
        flipped = false;
        locked = false;
        flip();

        

        
        setOnAction(e ->{
            //    System.out.println("Something happened with the button"); // at " + getXcord() + "," + getYcord() + "!"
              
                if(!locked) { //if the tile is unpaired yet
                    cont.update(yCord, xCord);
                }
                
                
                
            });
    }

    

    public void flip(){
        if(locked){
            flipped=true;
            setText(String.valueOf(this.c));
            setStyle("-fx-background-color: #00ff00;");//sets to green

        }

        else if(flipped){
            setText(String.valueOf(this.c));
            setStyle("-fx-background-color: #ff0000;");//red

            //setText("E");
            flipped = false;
            System.out.println("condition else");  
        }
        else{
            setText("?");
            setStyle("-fx-background-color: #0000;");//set to white
            flipped = true;
            System.out.println("condition !");
        }
        
    }

    public void lock(){
        this.locked = true;
        flip();
    }

    public boolean isLocked(){
        return this.locked;
    }

    public void setCords(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }

    public int getXcord(){
        return this.xCord;
    }

    public int getYcord(){
        return this.yCord;
    }

    public boolean isFlipped(){
        return this.flipped;
    }

    public void setFlipped(boolean b){
        this.flipped = b;
    }

    public char getChar(){
        return this.c;
    }
}
