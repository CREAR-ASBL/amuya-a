
package com.amuyana.app.view.containers;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Fcc;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;


/**
 *
 * @author ayar
 */
public class FccContainer extends TitledPane {
    
    Fcc fcc;
    
    public FccContainer(AppController appController, Fcc fcc){
        this.fcc=fcc;
        
        Label f1 = new Label();
        Label f2 = new Label();
        Label f3 = new Label("Formula 3");
        
        VBox formulasContainer = new VBox();
        super.setContent(formulasContainer);
        
        super.setText(fcc.getLabel());
        
        
        format();
        
    }
    
    public VBox getInfo(){
        
        String fccBoundsInLocal = "super.getBoundsInLocal().toString(): " + super.getBoundsInLocal().toString();
        String fccBoundsInParent = "super.getBoundsInParent().toString(): " +  super.getBoundsInParent().toString();
        
        VBox info = new VBox(
                new Label(fccBoundsInLocal), 
                new Label(fccBoundsInParent)
        );
        
        info.setBackground(new Background(new BackgroundFill(Paint.valueOf("yellow"), CornerRadii.EMPTY, Insets.EMPTY)));
                
        return info;
    }

    private void format() {
        //super.setPrefWidth(200);
        //super.setPrefHeight(200);
        super.setCollapsible(false);
    }
    
    
}
