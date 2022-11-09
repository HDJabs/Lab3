import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//master
public class MatchingGamePane extends Pane{
    int rows = 4;
    int cols = 4;
    int w = 100;
    int h = 100;
    int startX = 100;
    int startY = 100;

    Tile[][] tiles = new Tile[rows][cols];

    public MatchingGamePane(){
        System.out.println("New MatchingGamePane has been made!");
        buildTiles();
    }//end MatchingGamePane

    public void buildTiles(){
        int charIndex =65; //A 
        for(int y=rows-1; y>=0; y--){
            for(int x=0; x<cols; x++){ //       pos x   ,     pos y   , w, h
                
                Rectangle rect = new Rectangle(x*w + startX, y*h + startY, w, h);
                rect.setFill(Color.GREY);
                rect.setStroke(Color.BLACK);
                //getChildren().add(rect);

                Tile t = new Tile((char)charIndex);
                
                t.setMinWidth(w);
                t.setMinHeight(h);
                t.setLayoutX((x*w + startX));//(w/2)-15
                t.setLayoutY((startY+300) - y*h); // + (h/2)-10
                t.setFont(new Font("Comic Sans MS", 25));
                t.setCords(x, y);
                t.setOnAction(e ->{
                //    System.out.println("Something happened with the button"); // at " + getXcord() + "," + getYcord() + "!"
                    System.out.println("Something happened with the button at " + t.getXcord() + "," + t.getYcord() + "!");
                    if(!t.isFlipped()){
                        t.setText("?");
                        t.setFlipped(true);
                    }
                    else{
                        t.setText(Character.toString(t.getChar()));
                        t.setFlipped(false);
                    }
                    
                });
                

                tiles[y][x] = t;
                getChildren().add(tiles[y][x]);

                //before end of nested for loop
                if(charIndex==72)
                    charIndex = 97;
                else    
                    charIndex++;
            }//end 2nd for loop
        }//end 1st for loop
    }//end buildTiles
}//end class
