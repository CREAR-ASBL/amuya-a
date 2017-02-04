
package tabulator;

import amuyaña.Disjunction;

import static ñ.Ñ.amuyaña;

public class Implication {
    static final String I = "&sup;"; // I stands for "Implication"
    static final String E = "&sup;&#773;"; // E stands for "Exclusion" or negative implication
    
    static String oI; //this one is shared with LupascoWritter
    private static String oE;
    static final String CI="</span>"; //this one too is shared with LupascoWritter
    static final private String CE="</span>";
    
    private String implication;
    
    private String rightTerm;
    private String leftTerm;
    
    static private String oP;
    static final private String CP="</span>";
    
    static private String oSupR;
    static private String oSupL;
    static final private String CSUP="</sup>";
    static private String oSub;
    static final private String CSUB="</sub>";
    
    // Used for color and font family
    static private String oSpan;
    static final private String CSPAN = "</span>";
    
    static private String oState;
    static final private String CSTATE = "</span>";
    
    // The first disjunction is instantiated
    Implication(Disjunction disjunction, int subcon){
        
        settings();
        
        switch(subcon){
            case(0):{
                
                this.leftTerm = oP + "(" + CP + oI + I + CI + oSupR + amuyaña.getF1Abb(disjunction)
                        + CSUP + oSub + oState + "A" + CSTATE + CSUB + oP + ")" + CP;
                
                this.rightTerm = oP + "(" + CP + oE + E + CE + oSupR + amuyaña.getF2Abb(disjunction)
                        + CSUP + oSub + oState + "P" + CSTATE + CSUB + oP + ")" + CP;
                
                break;
            }
            case(1):{
                this.leftTerm = oP + "(" + CP + oE + E + CE + oSupR + amuyaña.getF2Abb(disjunction) + CSUP + 
                        oSub + oState + "A" + CSTATE + CSUB + oP + ")" + CP;
                
                this.rightTerm = oP + "(" + CP + oI + I + CI + oSupR + amuyaña.getF1Abb(disjunction) + CSUP + 
                        oSub + oState + "P" + CSTATE + CSUB + oP + ")" + CP;
                break;
            }
            case(2):{
                this.leftTerm = oP + "(" + CP + oI + I + CI + oSupR + amuyaña.getF1Abb(disjunction) + CSUP + 
                        oSub + oState + "T" + CSTATE + CSUB + oP + ")" + CP;
                
                this.rightTerm = oP + "(" + CP + oE + E + CE + oSupR + amuyaña.getF2Abb(disjunction) + CSUP + 
                        oSub + oState + "T" + CSTATE + CSUB + oP + ")" + CP;
                break;
            }
        }
    }

    public String getRightTerm() {
        return rightTerm;
    }

    public String getLeftTerm() {
        return leftTerm;
    }
    
    void addImplication(Disjunction d, int sub, String leftTerm, String rightTerm) {
        switch(sub){
            case(0):{
                this.leftTerm = oP + "(" + CP + leftTerm + oI + I + CI + oSupR + amuyaña.getF1Abb(d)
                        + CSUP + oSub  + "A"  + CSUB + rightTerm + oP + ")" + CP;
                this.rightTerm = oP + "(" + CP + leftTerm + oE + E + CE + oSupR + amuyaña.getF2Abb(d)
                        + CSUP + oSub  + "P"  + CSUB + rightTerm + oP + ")" + CP;
                break;
            }
            case(1):{
                this.leftTerm = oP + "(" + CP + leftTerm + oE + E + CE + oSupR + amuyaña.getF2Abb(d)
                        + CSUP + oSub  + "A"  + CSUB + rightTerm + oP + ")" + CP;
                this.rightTerm = oP + "(" + CP + leftTerm + oI + I + CI + oSupR + amuyaña.getF1Abb(d)
                        + CSUP + oSub  + "P"  + CSUB + rightTerm + oP + ")" + CP;
                break;
            }
            case(2):{
                this.leftTerm = oP + "(" + CP + leftTerm + oI + I + CI + oSupR + amuyaña.getF1Abb(d)
                        + CSUP + oSub  + "T"  + CSUB + rightTerm + oP + ")" + CP;
                this.rightTerm = oP + "(" + CP + leftTerm + oE + E + CE + oSupR + amuyaña.getF2Abb(d)
                        + CSUP + oSub  + "T"  + CSUB + rightTerm + oP + ")" + CP;
                break;
            }
        }
        
    }

    
    void setLast(Disjunction disjunction, int subCon) {
        String con="";
        
        switch(subCon){
            case (0): con=amuyaña.getCon1Abb(disjunction); break;
            case (1): con=amuyaña.getCon2Abb(disjunction); break;
            case (2): con=amuyaña.getCon3Abb(disjunction); break;
        }
        
        implication = leftTerm + oSupL + amuyaña.getDisjAbb(disjunction) + CSUP + 
                oI + I + CI  + oSupR + con + CSUP + rightTerm;
    }
    
    String getImplication(){
        return "<html>" + oSpan + implication + CSPAN + "</html>";
    }

    private void settings() {
        // From the GUI settings
        switch(LupascoPanel.size){
            // Small size
            case(0): {
                Implication.oSpan = "<span>";
                
                Implication.oState = "<span id=\"stateSmall\">";
                
                Implication.oP = "<span id=\"parenthesisSmall\">";
                
                Implication.oSupR = "<sup id=\"supRSmall\">";
                Implication.oSupL = "<sup id=\"supLSmall\">";
                Implication.oSub = "<sub id=\"subSmall\">";
                
                Implication.oI = "<span id=\"impSmall\">";
                Implication.oE = "<span id=\"excSmall\">";
                break;
            }
            // Medium size
            case(1): {
                Implication.oSpan = "<span>";
                
                Implication.oState = "<span id=\"stateMedium\">";
                
                Implication.oP = "<span id=\"parenthesisMedium\">";
                
                Implication.oSupR = "<sup id=\"supRMedium\">";
                Implication.oSupL = "<sup id=\"supLMedium\">";
                Implication.oSub = "<sub id=\"subMedium\">";
                
                Implication.oI = "<span id=\"impMedium\">";
                Implication.oE = "<span id=\"excMedium\">";
                break;
            }
            // Large size
            case(2): {
                Implication.oSpan = "<span id=\"large\">";
                
                Implication.oState = "<span id=\"stateLarge\">";
                
                Implication.oP = "<span id=\"parenthesisLarge\">";
                
                Implication.oSupR = "<sup id=\"supRLarge\">";
                Implication.oSupL = "<sup id=\"supLLarge\">";
                Implication.oSub = "<sub id=\"subLarge\">";
                
                Implication.oI = "<span id=\"impLarge\">";
                Implication.oE = "<span id=\"excLarge\">";
                break;
            }
        }
    }
}