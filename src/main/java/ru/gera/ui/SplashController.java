package ru.gera.ui;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SplashController implements Initializable {
    
    List<RotateTransition> rotateTransitions = new ArrayList<>(3);
    @FXML
    private AnchorPane root;
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        glow(c1);
        glow(c2);
        glow(c3);
        
        new SplashScreen().start();
        
        setRotate(c1, true, 360, 15);
        setRotate(c2, true, 180, 18);
        setRotate(c3, true, 145, 24);
        
    }
    
    private void glow(Circle c1) {
        Glow glow = new Glow();
        BoxBlur blur = new BoxBlur();
        blur.setHeight(0.2);
        blur.setWidth(0.2);
        glow.setLevel(0.2);
        blur.setInput(glow);
        c1.setEffect(blur);
    }
    
    private void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransitions.add(rotateTransition);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setDelay(Duration.seconds(0));
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(2);
        rotateTransition.play();
    }
    
    class SplashScreen extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                
                Platform.runLater(() -> {
                    try {
                        Parent rootMain = FXMLLoader.load(getClass().getResource("main.fxml"));
                        Scene scene = new Scene(rootMain);
                        
                        scene.getStylesheets().add(getClass().getResource("main.css").getPath());
                        
                        Stage stage = new Stage();
                        
                        stage.setScene(scene);
                        stage.show();
                        
                        root.getScene().getWindow().hide();
                        rotateTransitions.forEach(Animation::stop);
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                });
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
