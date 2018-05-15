
package com.amuyana.app.formulas;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public abstract class Formula {
    
    public static HBox implication(int orientation, String element, String antielement){
        HBox implication = new HBox();
        
        Label op= new Label("(");
        Label e = null;
        Label se = null;
        Label i=new Label("\u2283");
        Label ae = null;
        Label sae = null;
        Label cp=new Label(")");
        
        switch(orientation){
            case(0):{
                e=new Label(element);
                se=new Label("A");
                ae=new Label(antielement);
                sae=new Label("P");
                break;
            }
            case(1):{
                e=new Label(antielement);
                se=new Label("A");
                ae=new Label(element);
                sae=new Label("P");
                break;
            }
            case(2):{
                e=new Label(element);
                se=new Label("T");
                ae=new Label(antielement);
                sae=new Label("T");
                break;
            }
        }
        
        implication.getChildren().addAll(op,e,se,i,ae,sae,cp);
        return implication;
    }
    
    public static HBox conjunction(int orientation, String element, String antielement){
        HBox implication = new HBox();
        
        Label op= new Label("(");
        Label e = null;
        Label se = null;
        Label i=new Label("\u2283");
        Label ae = null;
        Label sae = null;
        Label cp=new Label(")");
        
        switch(orientation){
            case(0):{
                e=new Label(element);
                se=new Label("A");
                ae=new Label(antielement);
                sae=new Label("P");
                break;
            }
            case(1):{
                e=new Label(antielement);
                se=new Label("A");
                ae=new Label(element);
                sae=new Label("P");
                break;
            }
            case(2):{
                e=new Label(element);
                se=new Label("T");
                ae=new Label(antielement);
                sae=new Label("T");
                break;
            }
        }
        
        implication.getChildren().addAll(op,e,se,i,ae,sae,cp);
        return implication;
    }
}
