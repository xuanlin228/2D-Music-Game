/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author 老林
 */
public class MenuController  {

    @FXML
    private Button e_btn;
    @FXML
    private Button h_btn;

    /**
     * Initializes the controller class.
     */
   // @Override
 /*   public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    */

    @FXML
    private void e_btnPressed() throws IOException {
        Parent Easy = FXMLLoader.load(getClass().getResource("Easymenu.fxml"));
         Scene easyScene = new Scene(Easy);
         easyScene.getRoot().requestFocus();
         Danceing.currentStage.setScene(easyScene);
    }

    @FXML
    private void h_btnPressed() throws IOException {
        Parent Hard = FXMLLoader.load(getClass().getResource("Hardmenu.fxml"));
         Scene hardScene = new Scene(Hard);
         hardScene.getRoot().requestFocus();
         Danceing.currentStage.setScene(hardScene);
    }
    
}
