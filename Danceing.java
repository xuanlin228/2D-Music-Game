
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 老林
 */
public class Danceing extends Application{

    public static Stage currentStage;
    public static Scene menuScene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        menuScene = new Scene(root);
        
        currentStage.setTitle("Dance");
        currentStage.setScene(menuScene);
        currentStage.show();
        
       
    }
    public static void main(String[] args) throws IOException{
        launch(args);
    }
    
}
