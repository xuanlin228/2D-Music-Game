/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author 老林
 */
public class Hard2Controller implements Initializable,EventHandler<KeyEvent> {

    
    
    public int[][] beat =null;
    public ArrayList<String> list = new ArrayList<String>();
    
    LinkedList<Rectangle> _2beats0=new LinkedList<Rectangle>();
    LinkedList<Rectangle> _2beats1=new LinkedList<Rectangle>();
    LinkedList<Rectangle> _2beats2=new LinkedList<Rectangle>();
    LinkedList<Rectangle> _2beats3=new LinkedList<Rectangle>();
    
   // private AnchorPane _feild;
  //  private Text score;
    @FXML
    private Pane h_up;
    @FXML
    private Pane h_down;
    @FXML
    private Pane h_left;
    @FXML
    private Pane h_right;
    
    
    public MediaPlayer mediaplayer;
    @FXML
    private AnchorPane _h2feild;
    @FXML
    private Text h2score;
    @FXML
    private Pane h2end;
    @FXML
    private Text h2sc;
    @FXML
    private Button h2backbtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        music();
        try {
            song();
        } catch (IOException ex) {
            Logger.getLogger(HardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //set beat
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<4;j++)
            {
                if(beat[i][j]==1&&j==0)
                {
                    Rectangle newbeat = new Rectangle();
                    newbeat.setLayoutX(150);
                    newbeat.setLayoutY(i*(-50));
                    newbeat.setWidth(124);
                    newbeat.setHeight(50);
                    newbeat.setFill(Color.WHITE);
                    _2beats0.add(newbeat);
                    _h2feild.getChildren().add(newbeat);
                }
                
                if(beat[i][j]==1&&j==1)
                {
                    Rectangle newbeat = new Rectangle();
                    newbeat.setLayoutX(275);
                    newbeat.setLayoutY(i*(-50));
                    newbeat.setWidth(124);
                    newbeat.setHeight(50);
                    newbeat.setFill(Color.WHITE);
                    _2beats1.add(newbeat);
                    _h2feild.getChildren().add(newbeat);
                }
                
                if(beat[i][j]==1&&j==2)
                {
                    Rectangle newbeat = new Rectangle();
                    newbeat.setLayoutX(400);
                    newbeat.setLayoutY(i*(-50));
                    newbeat.setWidth(124);
                    newbeat.setHeight(50);
                    newbeat.setFill(Color.WHITE);
                    _2beats2.add(newbeat);
                    _h2feild.getChildren().add(newbeat);
                }
                
                if(beat[i][j]==1&&j==3)
                {
                    Rectangle newbeat = new Rectangle();
                    newbeat.setLayoutX(525);
                    newbeat.setLayoutY(i*(-50));
                    newbeat.setWidth(124);
                    newbeat.setHeight(50);
                    newbeat.setFill(Color.WHITE);
                    _2beats3.add(newbeat);
                    _h2feild.getChildren().add(newbeat);
                }
               
            }
            
        }
        
        //run beat
        Timeline fps=new Timeline(new KeyFrame(Duration.millis(1000/2),(e)->{
            
            ArrayList<Rectangle> tbeats0 = new ArrayList<Rectangle>(_2beats0);
            ArrayList<Rectangle> tbeats1 = new ArrayList<Rectangle>(_2beats1);
            ArrayList<Rectangle> tbeats2 = new ArrayList<Rectangle>(_2beats2);
            ArrayList<Rectangle> tbeats3 = new ArrayList<Rectangle>(_2beats3);
            for(var b:tbeats0)
            {
                b.setLayoutY(b.getLayoutY()+50);
                if(b.getLayoutY()>470)
                {
                    _2beats0.remove(b);
                    _h2feild.getChildren().remove(b);
                    
                }
            }
            for(var b:tbeats1)
            {
                b.setLayoutY(b.getLayoutY()+50);
                if(b.getLayoutY()>470)
                {
                    _2beats1.remove(b);
                    _h2feild.getChildren().remove(b);
                    
                }
            }
            
            for(var b:tbeats2)
            {
                b.setLayoutY(b.getLayoutY()+50);
                if(b.getLayoutY()>470)
                {
                    _2beats2.remove(b);
                    _h2feild.getChildren().remove(b);
                    
                }
            }
            
            for(var b:tbeats3)
            {
                b.setLayoutY(b.getLayoutY()+50);
                if(b.getLayoutY()>470)
                {
                    _2beats3.remove(b);
                    _h2feild.getChildren().remove(b);
                    
                }
            }
           
        }));
         fps.setCycleCount(Timeline.INDEFINITE);
         fps.play();
         
         mediaplayer.setOnEndOfMedia(()->{
            h2end.setVisible(true);
         });
         
    }    
    public int[][] song() throws IOException{
        // ArrayList<String> list = new ArrayList<String>();
        //public int[][] beat =null;
        //inputstream
        FileInputStream fis = new FileInputStream("src/hardsong2.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        //read data by line
        String value =br.readLine();
        while(value!=null){
            //add data into list
            list.add(value);
            value=br.readLine();
        }
        br.close();
        //obtain columns and rows
        int row = list.size();
        int column = 0;
        for(int i=0;i<1;i++){
            String str = list.get(i);
            String[] values = str.split(" ");
            column=values.length;
        }
        beat = new int[row][column];
        //String to int
        for(int i=0;i<list.size();i++)
        {
            String str = list.get(i);
            String[] values = str.split(" ");
            for(int j=0;j<values.length;j++)
            {
                beat[i][j]=Integer.valueOf(values[j]);
            }
        }
        
        return beat;
    }
    
    //playmusic
    public void music(){
           String s = "hardsong2.mp3";
           Media h = new Media(Paths.get(s).toUri().toString());
           mediaplayer = new MediaPlayer(h);
           mediaplayer.play();
    }

    @FXML
    public void handle(KeyEvent e) {
        String sc;
        String final_sc;
        int sco;
        sc=h2score.getText();
        sco=Integer.valueOf(sc);
       
       
        for(int i=0;i<_2beats0.size();i++)
        {
            Rectangle b=_2beats0.get(i);
            if(e.getCode()==KeyCode.D)
            {
                if(b.getLayoutY()==400&&b.getLayoutX()==150)
                {
                    sco+=1000;
                     _2beats0.remove(b);
                    _h2feild.getChildren().remove(b);
                    break;
                    
                }
                else if((b.getLayoutY()>=350&&b.getLayoutX()==150&&b.getLayoutY()<400))
                {
                    sco+=500;
                    _2beats0.remove(b);
                    _h2feild.getChildren().remove(b);
                    break;
                }
                else if((b.getLayoutX()==150&&b.getLayoutY()>400&&b.getLayoutY()<=470))
                {
                    sco+=500;
                    _2beats0.remove(b);
                    _h2feild.getChildren().remove(b);
                    break;
                }
                else if(b.getLayoutY()>=0&&b.getLayoutX()==150&&b.getLayoutY()<350)
                {
                    _2beats0.remove(b);
                    _h2feild.getChildren().remove(b);
                    break;
                }
                
            }
        }
       
        for(int j=0;j<_2beats1.size();j++){
            Rectangle b1 = _2beats1.get(j);
            if(e.getCode()==KeyCode.F)
            {
                if(b1.getLayoutY()==400&&b1.getLayoutX()==275)
                {
                    sco+=1000;
                    _2beats1.remove(b1);
                    _h2feild.getChildren().remove(b1);
                    break;
                }
                else if((b1.getLayoutY()>=350&&b1.getLayoutX()==275)||(b1.getLayoutX()==275&&b1.getLayoutY()>400))
                {
                    sco+=500;
                    _2beats1.remove(b1);
                    _h2feild.getChildren().remove(b1);
                    break;
                }
                else if(b1.getLayoutY()>=0&&b1.getLayoutX()==275)
                {
                    _2beats1.remove(b1);
                    _h2feild.getChildren().remove(b1);
                    break;
                }
            }
        }
        
        for(int m=0;m<_2beats2.size();m++){
            
            Rectangle b2=_2beats2.get(m);
            if(e.getCode()==KeyCode.J)
            {
                if(b2.getLayoutY()==400&&b2.getLayoutX()==400)
                {
                    sco+=1000;
                    _2beats2.remove(b2);
                    _h2feild.getChildren().remove(b2);
                    break;
                }
                else if((b2.getLayoutY()>=350&&b2.getLayoutX()==400)||(b2.getLayoutX()==400&&b2.getLayoutY()>400))
                {
                    sco+=500;
                    _2beats2.remove(b2);
                    _h2feild.getChildren().remove(b2);
                    break;
                }
                else if(b2.getLayoutY()>=0&&b2.getLayoutX()==400)
                {
                    _2beats2.remove(b2);
                    _h2feild.getChildren().remove(b2);
                    break;
                }
                
            }
        }
        
        for(int n=0;n<_2beats3.size();n++){
            
            Rectangle b3=_2beats3.get(n);
            if(e.getCode()==KeyCode.K)
            {
                if(b3.getLayoutY()==400&&b3.getLayoutX()==525)
                {
                    sco+=1000;
                    _2beats3.remove(b3);
                    _h2feild.getChildren().remove(b3);
                    break;
                }
                else if((b3.getLayoutY()>=350&&b3.getLayoutX()==525&&b3.getLayoutY()<400)||(b3.getLayoutX()==525&&b3.getLayoutY()>400&&b3.getLayoutY()<=470))
                {
                    sco+=500;
                    _2beats3.remove(b3);
                    _h2feild.getChildren().remove(b3);
                    break;
                }
                else if(b3.getLayoutY()>=0&&b3.getLayoutX()==525&&b3.getLayoutY()<350)
                {
                    _2beats3.remove(b3);
                    _h2feild.getChildren().remove(b3);
                    break;
                }
                
            }
        }
       
        final_sc=Integer.toString(sco);
        h2score.setText(final_sc);
        h2sc.setText(final_sc);
    }

    @FXML
    private void h2backtomenu() throws IOException {
         Parent h2back = FXMLLoader.load(getClass().getResource("menu.fxml"));
         Scene h2backScene = new Scene(h2back);
         h2backScene.getRoot().requestFocus();
         Danceing.currentStage.setScene(h2backScene);
    }
 
}

