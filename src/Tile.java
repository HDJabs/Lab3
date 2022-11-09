import javafx.scene.control.Button;

public class Tile extends Button{
    private char c;
    private boolean flipped, locked; //
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
              
                if(!locked) {
                    if(cont.update(yCord, xCord))
                        flip();
                }
                
                
                
            });
    }

    

    public void flip(){
        if(!locked && !flipped){
            
            setText("?");
            flipped = true;
            System.out.println("condition !");
        }
        else{
            setText(String.valueOf(this.c));
            //setText("E");
            flipped = false;
            System.out.println("condition else");  
        }
    }

    public void lock(){
        this.locked = true;
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
