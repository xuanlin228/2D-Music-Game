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

/**
 * FXML Controller class
 *
 * @author 老林
 */
public class EasymenuController {

    @FXML
    private Button e1_btn;
    @FXML
    private Button e2_btn;

    /**
     * Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    */

    @FXML
    private void e1Pressed() throws IOException {
         Parent e_s1 = FXMLLoader.load(getClass().getResource("Easy.fxml"));
         Scene es1Scene = new Scene(e_s1);
         es1Scene.getRoot().requestFocus();
         Danceing.currentStage.setScene(es1Scene);
    }

    @FXML
    private void e2Pressed() throws IOException {
         Parent e_s2 = FXMLLoader.load(getClass().getResource("Easy2.fxml"));
         Scene es2Scene = new Scene(e_s2);
         es2Scene.getRoot().requestFocus();
         Danceing.currentStage.setScene(es2Scene);
    }
    
}
