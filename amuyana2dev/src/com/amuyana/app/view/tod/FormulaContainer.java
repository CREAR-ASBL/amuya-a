/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.view.tod;

import com.amuyana.app.controllers.AppController;
import com.amuyana.app.data.Dynamism;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.styles.FormulaStyles;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author ayar
 */
public class FormulaContainer extends HBox {

    private static AppController appController;
    private Fcc fcc;
    
    private ArrayList<Dynamism> listDynamisms;
    
    private static FormulaStyles style;
    
    /**
     * Attention. The order of the listDynamisms items are from most general 
     * notions to the most particular, i.e. from left to right in the Table 
     * of Deductions.
     * 
     * @param appController
     * @param listDynamisms 
     */
    public FormulaContainer(ArrayList<Dynamism> listDynamisms) {
        //        signT.setStyle("-fx-padding: 10;" + 
//                      "-fx-border-style: solid inside;" + 
//                      "-fx-border-width: 2;" +
//                      "-fx-border-insets: 5;" + 
//                      "-fx-border-radius: 5;" + 
//                      "-fx-border-color: blue;");
        this.listDynamisms = listDynamisms;
        
        
        style = FormulaStyles.SIMPLE;
        
    }
    
    public static void setAppController(AppController appController){
        
    }

    public static void setStyle(FormulaStyles formulaStyle) {
        style = formulaStyle;
        
        // for all formula containers redraw them!
    }

    private void draw(ArrayList<Dynamism> listDynamisms) {
        switch(style){
            case SIMPLE:{
                drawSimple(listDynamisms);
                break;
            }
            case NO_LABELS:{
                break;
            }
            case DEFAULT:{
                break;
            }
            case DEFAULT_REDUCED:{
                break;
            }
            case PHRASES:{
                break;
            }
            default :{
                break;
            }
        }
    }

    private void drawSimple(ArrayList<Dynamism> listDynamisms) {
        ArrayList<String> listSymbols = new ArrayList<>();
        listSymbols.add(new String());
        
        for(Dynamism d:listDynamisms){
            Element element = appController.elementOf(0, d.getFcc());
            String e = element.getSymbol();
            
            Element antiElement = appController.elementOf(1, d.getFcc());
            String aE = antiElement.getSymbol();
            
            int middlePosition = (listSymbols.size()-1)/2;
            
            ArrayList<String> left = new ArrayList<>();
            ArrayList<String> right = new ArrayList<>();
            
            left.addAll(listSymbols);
            right.addAll(listSymbols);
            
            switch (d.getOrientation()) {
                case 0:
                    left.set(middlePosition, e);
                    left.add(middlePosition+1,"A");
                    right.set(middlePosition, aE);
                    right.add(middlePosition+1,"P");
                    break;
                case 1:
                    left.set(middlePosition, aE);
                    left.add(middlePosition+1,"A");
                    right.set(middlePosition, e);
                    right.add(middlePosition+1,"P");
                    break;
                case 2:
                    left.set(middlePosition, e);
                    left.add(middlePosition+1,"T");
                    right.set(middlePosition, aE);
                    right.add(middlePosition+1,"T");
                    break;
                default:
                    break;
            }
            
            listSymbols.clear();
            listSymbols.add("(");
            listSymbols.addAll(left);
            listSymbols.add(")");
            listSymbols.add("\u2283");
            listSymbols.add("(");
            listSymbols.addAll(right);
            listSymbols.add(")");
        
        }
        System.out.println(listSymbols.size());
        
        
        for(String s:listSymbols){
            Label label = new Label(s);
            
            label.setId("implication");
            super.getChildren().add(label);
            
        }
    }
    
}
