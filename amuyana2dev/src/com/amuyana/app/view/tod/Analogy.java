/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.view.tod;

import com.amuyana.app.data.Fcc;
import java.util.ArrayList;

/**
 *
 * @author ayar
 */
public class Analogy extends ArrayList<Fcc> {

    public enum Type {
        CCLASS, INCLUSION, MIXED, NONE
    };
    
    private Type type;
    
    public Analogy() {
        
    }
    
    public void setType(Type type){
        this.type=type;
    }
    
}
