//i entend to redesign the entry patterns on THIS BRANCH
public class TileController {

    public int ax, bx, ay, by;
    Tile currentTile,previousTile, teriaryTile;
    private int entry =1;
    private Tile[][] tiles;

    public TileController(){
        entry = 1;
        
    }

    public void update(int x, int y){ //f=first t=second   
            currentTile = getTile(x, y);
            currentTile.flip();//always, thats why its clicked.

            if(entry == 1){//the first move. nothing is selected
                System.out.println("appears to be 1st move");
                try{
                    if(currentTile==previousTile){
                        System.out.println("should be clear of red now?");
                        entry =1;
                    }
                    else{
                        entry =2;
                    }
                }
                catch (Exception e){
                    entry++;
                }
                //return true;
            }
            else if(entry ==2){
                System.out.println("appears to be 2nd move");

                if(previousTile==currentTile){//if the same tile is picked, the tile has already been flipped back, so its done
                    try{
                        if(teriaryTile.isFlipped())
                            entry=1;
                        else
                            entry=2;
                    }
                    catch(Exception e){
                        
                    }
                    previousTile=null;
                    teriaryTile=null;
                    
                }
                else if(currentTile==teriaryTile){
                    entry =2;
                    currentTile=previousTile;
                    previousTile=null;
                    teriaryTile=null;
                }
                else if(Character.toUpperCase(currentTile.getChar())==Character.toUpperCase(previousTile.getChar())){//if the tiles match
                    currentTile.lock();//both tiles have been locked face up
                    previousTile.lock();// and green. they shouldnt be able to be interacted with
                    System.out.println("Match!");
                    entry=1;//back to picking a new first tile
                    
                    //return true;
                }
                else{
                    //previousTile.flip();
                    System.out.println("elsey");
                    
                }
            }//end else if tree
            
            //finally
            //teriaryTile.flip();
            try{
                if(!teriaryTile.isFlipped())
                    teriaryTile.flip();
            }
            catch(Exception e){
                System.out.println();
            }
            teriaryTile = previousTile;
            previousTile = currentTile;

            
            
        
        //return true;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public void setTiles(Tile[][] tiles){
        this.tiles = tiles;
    }
    
}