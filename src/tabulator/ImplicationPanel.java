
package tabulator;

import amuyaña.Disjunction;

import static ñ.Ñ.amuyaña;

public class ImplicationPanel {
    static final String I = "&sup;"; // I stands for "Implication"
    static final String E = "&sup;&#773;"; // E stands for "Exclusion" or negative implication
    
    static String oI; //this one is shared with LupascoWritter
    private static String oE;
    static final String CI="</span>"; //this one too is shared with LupascoWritter
    static final private String CE="</span>";
    
    private String implication;
    
    private String rightTerm;
    private String leftTerm;
    
    static private String oP; // opening parenthesis tag
    static final private String CP="</span>"; // close parenthesis tag
    
    static private String oSupR; // open top right index tag
    static private String oSupL; // open top left index tag
    static final private String CSUP="</sup>"; // close top index tags
    static private String oSub; // open bottom index
    static final private String CSUB="</sub>"; // close bottom index
    
    // Used for color and font family
    static private String oSpan; // open span tag
    static final private String CSPAN = "</span>"; //close span tag
    
    static private String oState;
    static final private String CSTATE = "</span>";
    
    // The first disjunction is instantiated
    ImplicationPanel(Disjunction disjunction, int subcon){
        
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
        switch(LupascoPanel.SIZE){
            // Small size
            case(0): {
                ImplicationPanel.oSpan = "<span>";
                
                ImplicationPanel.oState = "<span id=\"stateSmall\">";
                
                ImplicationPanel.oP = "<span id=\"parenthesisSmall\">";
                
                ImplicationPanel.oSupR = "<sup id=\"supRSmall\">";
                ImplicationPanel.oSupL = "<sup id=\"supLSmall\">";
                ImplicationPanel.oSub = "<sub id=\"subSmall\">";
                
                ImplicationPanel.oI = "<span id=\"impSmall\">";
                ImplicationPanel.oE = "<span id=\"excSmall\">";
                break;
            }
            // Medium size
            case(1): {
                ImplicationPanel.oSpan = "<span>";
                
                ImplicationPanel.oState = "<span id=\"stateMedium\">";
                
                ImplicationPanel.oP = "<span id=\"parenthesisMedium\">";
                
                ImplicationPanel.oSupR = "<sup id=\"supRMedium\">";
                ImplicationPanel.oSupL = "<sup id=\"supLMedium\">";
                ImplicationPanel.oSub = "<sub id=\"subMedium\">";
                
                ImplicationPanel.oI = "<span id=\"impMedium\">";
                ImplicationPanel.oE = "<span id=\"excMedium\">";
                break;
            }
            // Large size
            case(2): {
                ImplicationPanel.oSpan = "<span id=\"large\">";
                
                ImplicationPanel.oState = "<span id=\"stateLarge\">";
                
                ImplicationPanel.oP = "<span id=\"parenthesisLarge\">";
                
                ImplicationPanel.oSupR = "<sup id=\"supRLarge\">";
                ImplicationPanel.oSupL = "<sup id=\"supLLarge\">";
                ImplicationPanel.oSub = "<sub id=\"subLarge\">";
                
                ImplicationPanel.oI = "<span id=\"impLarge\">";
                ImplicationPanel.oE = "<span id=\"excLarge\">";
                break;
            }
        }
    }
}