import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    //boolean flag = true;

    @Override
    public void start(Stage primaryStage){

        
        TileController cont = new TileController();
        MatchingGamePane MGpane = new MatchingGamePane(cont);


        cont.setTiles(MGpane.getTiles());

        Scene scene = new Scene(MGpane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        //
        primaryStage.setResizable(false);

        MGpane.buildTiles();


}

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

}