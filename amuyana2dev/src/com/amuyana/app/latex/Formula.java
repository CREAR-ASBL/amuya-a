/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.latex;

import com.proudapes.jlatexmathfx.Control.LateXMathControl;

/**
 *
 * @author ayar
 */
public abstract class Formula {

    public static LateXMathControl getFormula(String text) {
        
        String f = "\\[\\left\\{ \\begin{array}{l}" +
            "(e_A\\supset\\bar{e}_P) \\\\" +
            "(\\bar{e}_A\\supset e_P) \\\\" +
            " (e_T\\supset\\bar{e}_T)\\end{array} \\right. \\] ";
        
        LateXMathControl l = new LateXMathControl(f);
        
        return l;
    }
    
}
