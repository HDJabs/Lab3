import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
//master
public class MatchingGamePane extends Pane{
    int rows = 4;
    int cols = 4;
    int w = 100;
    int h = 100;
    int startX = 100;
    int startY = 100;
    TileController cont;
    char[][] list = new char[][]{{'a','b','c','d','e','f','g','h','A','B','C','D','E','F','G','H'}, //list[0][3]=char at index 3
    {'y','y','y','y','y','y','y','y','y','y','y','y','y','y','y','y'}};                             //list[1][3]=can this character been used? 'y' or 'n'


    Tile[][] tiles = new Tile[rows][cols];

    public MatchingGamePane(TileController cont){
        System.out.println("New MatchingGamePane has been made!");
        buildTiles();
        this.cont = cont;
        
    }//end MatchingGamePane

    public void buildTiles(){
        for (int i=0; i<16; i++) {
            int indA = (int)(Math.random()*16);
            int indB = (int)(Math.random()*16);
			char charA = list[0][indA];
            char charB = list[0][indB];
            list[0][indA]=charB;
            list[0][indB]=charA;
		}
		
        int index =0;
        for(int y=rows-1; y>=0; y--){
            for(int x=0; x<cols; x++){ //       pos x   ,     pos y   , w, 
                
                
                Tile t = new Tile(list[0][index], cont);
               
                System.out.println("this is the " + index + "th Tile created");
                
                //t.setText("?");
                
                t.setMinWidth(w);
                t.setMinHeight(h);
                t.setLayoutX((x*w + startX));//(w/2)-15
                t.setLayoutY((startY+300) - y*h); // + (h/2)-10
                t.setFont(new Font("Comic Sans MS", 25));
                t.setCords(x, y);
                /*t.setOnAction(e ->{
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
                */

                tiles[y][x] = t;
                getChildren().add(tiles[y][x]);

                //before end of nested for loop

                index++;
                
            }//end 2nd for loop
        }//end 1st for loop
    }//end buildTiles

    public char randomCharPile(){
        System.out.println("awfly radnom init");
        int r =0;
        while(list[0][1] == 'y' || list[1][1] == 'y' || list[1][2] == 'y' || list[1][3] == 'y' || list[1][4] == 'y' || list[1][5] == 'y' || list[1][6] == 'y' || list[1][7] == 'y' || list[1][8] == 'y' || list[1][9] == 'y' || list[1][10] == 'y' || list[1][11] == 'y' || list[1][12] == 'y' || list[1][13] == 'y' || list[1][14] == 'y' || list[1][15] == 'y'){
            r = rand();
            //System.out.println("r=" + r + ".");
            //System.out.println("list[1][" + r + "] = " + list[1][r]);
            //System.out.println("list[0][" + r + "] = " + list[0][r]);
            if(list[1][r]=='y'){
                list[1][r]='n';
                System.out.println("y");
                return list[0][r];
            }
            else{
                System.out.println("n");
            }
        }
        return list[0][r];
        
    }

    public Tile[][] getTiles(){
        return this.tiles;
    }
    public int rand(){
        int r = (int)(Math.random()*16);
        System.out.println(r);
        return r;
    }
}//end class
