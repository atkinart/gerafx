package ru.gera.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SizePane extends HBox {
    
    private Pane parent;
    
    private String id;
    private int value;
    
    private Label idLabel;
    private TextField valueField;
    private Button removeButton;
    
    public SizePane(Pane parent, String id) {
        
        super(4);
        this.setAlignment(Pos.CENTER);
        
        this.parent = parent;
        
        this.id = id;
        this.value = 0;
        
        this.setPrefWidth(200);
        this.setPrefHeight(34);
        
        this.idLabel = new Label(" № " + id);
        idLabel.setPrefWidth(50);
        
        this.valueField = new TextField();
        this.valueField.setPrefHeight(32);
        this.valueField.setPrefWidth(100);
        
        this.removeButton = new Button("-");
        this.removeButton.setPrefHeight(32);
        this.removeButton.setPrefWidth(32);
        
        this.getChildren().add(this.idLabel);
        this.getChildren().add(this.valueField);
        this.getChildren().add(this.removeButton);
        
        this.valueField.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            try {
                int v = Integer.parseInt(valueField.getText());
                value = v;
            } catch (Exception e) {
                valueField.setText(valueField.getText(0, valueField.getText().length() - 2));
            }
        });
        
        this.removeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> parent.getChildren().remove(this));
    }
}
