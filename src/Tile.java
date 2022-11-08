import javafx.scene.control.Button;

public class Tile extends Button{
    private char c;
    private boolean flipped;
    private int xCord, yCord;
    public Tile(){
        super("?");
        System.out.println("A new <default> Tile has been created!");
        this.c = '?';
        flipped = false;
        
        setOnAction(e ->{
            //    System.out.println("Something happened with the button"); // at " + getXcord() + "," + getYcord() + "!"
                System.out.println("Something happened with the button at " + getXcord() + "," + getYcord() + "!");
                if(!isFlipped()){
                    setText("?");
                    setFlipped(true);
                }
                else{
                    setText(Character.toString(getChar()));
                    setFlipped(false);
                }
                
            });

    }

    public Tile(char c) {
        super(Character.toString(c));
        System.out.println("A new Tile has been created with the Character:" + c +"!");
        this.c = c;
        flipped = false;
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
