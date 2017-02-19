
package tabulator;

import amuyaña.Disjunction;
import ñ.Ñ;

public class ImplicationTex {
    static amuyaña.Operations amuyaña=Ñ.amuyaña;
    static final String PIMP="\\PIMP"; //this is a newcommand set in LupascoTex
    static final String NIMP ="\\NIMP"; //this is a newcommand set in LupascoTex

    private String implication;

    private String rightTerm;
    private String leftTerm;

    public ImplicationTex(Disjunction d, int sub) {
        String f1 = amuyaña.getF1Abb(d);
        String f2 = amuyaña.getF2Abb(d);
        
        switch(sub){
            case 0:{
                this.leftTerm = "(" + imp(f1,"A", 0) + ")";
                this.rightTerm = "(" + imp(f2,"P", 1) + ")";
                break;
            }
            case 1: {
                this.leftTerm = "(" + imp(f2,"A",1) + ")";
                this.rightTerm = "(" + imp(f1,"P",0) + ")";
                break;
            }
            case 2: {
                this.leftTerm = "(" + imp(f1,"T",0) + ")";
                this.rightTerm = "(" + imp(f2,"T",1) + ")";
                break;                
            }
        }
    }

    String getRightTerm() {
        return rightTerm;
    }

    String getLeftTerm() {
        return leftTerm;
    }
    
    
    private String imp(String tri, String tli){
        return "\\prescript{" + tli + "}{}{" + PIMP + "}^{" + tri + "}";
    }
    
    private String imp(String tri, String bi, int impSign){
        String string="";
        switch (bi){
            case "A":{
                bi="\\AC";break;
            }
            case "P":{
                bi="\\PO";break;
            }
            case "T":{
                bi="\\TE";break;
            }
        }
        if (impSign == 0){
            string = PIMP + "^{" + tri + "}_{" + bi + "}";
        } else if (impSign == 1){
            string = NIMP + "^{" + tri + "}_{" + bi + "}";
        }
        return string;
    }
    
    void addLevel(Disjunction d, int subCon, String leftTerm, String rightTerm) {
        String newImplication;
        String f1 = amuyaña.getF1Abb(d);
        String f2 = amuyaña.getF2Abb(d);
        
        switch(subCon){
            case 0:{
                this.leftTerm = "(" + leftTerm + imp(f1,"A",0) + rightTerm + ")";
                this.rightTerm = "(" + leftTerm + imp(f2,"P",1) + rightTerm + ")";
                break;
            }
            case 1:{
                this.leftTerm = "(" + leftTerm + imp(f2,"A",1) + rightTerm + ")";
                this.rightTerm = "(" + leftTerm + imp(f1,"P",0) + rightTerm + ")";
                break;
            }
            case 2:{
                this.leftTerm = "(" + leftTerm + imp(f1,"T",0) + rightTerm + ")";
                this.rightTerm = "(" + leftTerm + imp(f2,"T",1) + rightTerm + ")";
                break;
            }
        }
    }
    
    void setLast(Disjunction d, int i) {
        String dis=amuyaña.getDisjAbb(d);
        String con="";
        
        switch (i){
            case 0:{
                con = amuyaña.getCon1Abb(d);
                break;
            }
            case 1:{
                con = amuyaña.getCon2Abb(d);
                break;
            }
            case 2:{
                con = amuyaña.getCon3Abb(d);
                break;
            }
        }
        implication = leftTerm + imp(con, dis) + rightTerm;
    }

    String getImplication() {
        return implication;
    }


    
    

}
