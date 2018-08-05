
package com.amuyana.app.gui.tod;

import com.amuyana.app.data.Fcc;
import com.amuyana.app.gui.AppController;
import javafx.geometry.Insets;
import javafx.scene.DepthTest;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class TodContainer extends ScrollPane {

    private final AppController appController;
    
    public TodContainer(Fcc initialFcc, AppController aThis){
        this.appController = aThis;
        
        LevelsContainer levelsContainer = new LevelsContainer();
        NotionsContainer notionsContainer = new NotionsContainer();
        ClassContainer classContainer = new ClassContainer();
        //FccContainer fccContainer = new FccContainer(initialFcc, this.appController);
        
        super.setContent(levelsContainer);
        levelsContainer.getChildren().add(notionsContainer);
        //notionsContainer.getChildren().addAll(classContainer, new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController),new FccContainer(initialFcc, this.appController));
        //classContainer.getChildren().add(fccContainer);
        
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
    }
    
    
}
