/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


public class HardmenuController {

    @FXML
    private Button s1_btn;
    @FXML
    private Button s2_btn;

    /**
     * Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    */

    @FXML
    private void s1Pressed() throws IOException{
    
         Parent h_s1 = FXMLLoader.load(getClass().getResource("Hard.fxml"));
         Scene hs1Scene = new Scene(h_s1);
         hs1Scene.getRoot().requestFocus();
         Danceing.currentStage.setScene(hs1Scene);
    }

    @FXML
    private void s2Pressed() throws IOException{
         Parent h_s2 = FXMLLoader.load(getClass().getResource("Hard2.fxml"));
         Scene hs2Scene = new Scene(h_s2);
         hs2Scene.getRoot().requestFocus();
         Danceing.currentStage.setScene(hs2Scene);
    }
    
}
