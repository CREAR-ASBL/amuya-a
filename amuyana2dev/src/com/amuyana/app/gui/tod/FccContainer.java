
package com.amuyana.app.gui.tod;

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
    
    public FccContainer(Fcc fcc){
        Label f1 = new Label("Formula 1");
        Label f2 = new Label("Formula 2");
        Label f3 = new Label("Formula 3");
        
        VBox formulasContainer = new VBox(f1,f2,f3);
        super.setContent(formulasContainer);
        
        super.setText("TitledPane");
        
        super.getChildren().add(formulasContainer);
        
        format();
        
        // debug area
        
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
