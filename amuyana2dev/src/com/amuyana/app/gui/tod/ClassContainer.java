
package com.amuyana.app.gui.tod;

import com.amuyana.app.data.Fcc;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class ClassContainer extends Group {
    
    
    
    public ClassContainer(){
        
        
        
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
        
    }
    
    
}
