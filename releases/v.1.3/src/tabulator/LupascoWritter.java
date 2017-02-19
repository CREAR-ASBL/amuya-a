
package tabulator;

import amuyaña.Disjunction;
import java.util.ArrayList;
import javax.swing.JLabel;
import ñ.Ñ;
import static ñ.Ñ.amuyaña;

class LupascoWritter {
    
    private final ArrayList<Disjunction> disjunctions;
    private final ArrayList<Integer>  parents;
    
    private static String oConBegSpan;
    private static String oConFinSpan;
    private static final String CSPAN = "</span>";
    private static String oMessSpan="<span id=\"message\">";
    private static String oSubcon;
   
    /*
    This constructor is called from LupascoPanel to obtain titles, postfix 
    references (getConjunction()), and maybe other stuff
    */
    LupascoWritter(){
        settings();
        this.disjunctions = new ArrayList<>();
        this.parents = new ArrayList<>();
    }
    
    /*
    This constructor is called from TreePanel class.
    */
    LupascoWritter(ArrayList<Disjunction> disjunctions, ArrayList<Integer> parents){
        settings();
        this.disjunctions = disjunctions;
        this.parents = parents;
    }
    
    /*
        TITLES
    */
    JLabel getMainTitle() {
        return new JLabel("<html><h1 id=\"main\">" + 
                "Visualizando <i>" + Ñ.getFile() + "</i></h1></html>");
    }
    
    JLabel getTitle(int i){
        switch(i){
            case 0:{
                return new JLabel("<html><h1>Disyunción raiz</h1></html>");
            }
            case 1:{
                return new JLabel("<html><h1>" +"Disyunciones huérfanas"+ "</h1></html>");
            }
            case 2:{
                return new JLabel("<html><h1>" + "Disyunciones de origen común" + "</h1></html>");
            }
            case 3:{
                return new JLabel("<html><h1>" + "Disyunciones con más de un origen" + "</h1></html>");
            }
        }
        return new JLabel("Error");
    }
    
    JLabel getConjunction(Disjunction disjunction, boolean withSign) {

        String f1Abb = amuyaña.getF1Abb(disjunction);
        String f2Abb = amuyaña.getF2Abb(disjunction);
        String f1Name = amuyaña.getF1Name(disjunction);
        String f2Name = amuyaña.getF2Name(disjunction);
        
        JLabel label = new JLabel();
        
        label.setBorder(TreePanel.themedBorder);
        
        // the withSign boolean is true when we want the name of the first
        // disjunction of the tree buing built, it is false when we need the 
        // reference at the end of the branch to another disjunction
        
        if ((LupascoPanel.SIGNS && LupascoPanel.FULL) || (LupascoPanel.SIGNS && !LupascoPanel.FULL)) {
            if (withSign){
                return new JLabel("<html>" + oConBegSpan + "(" + f1Abb + "&middot;" +
                        f2Abb +")&nbsp;" + CSPAN + Implication.oI + "&sup;" + Implication.CI + "</html>");
            } else if (!withSign){
                label.setText("<html>" + oConFinSpan + "&nbsp;("+ f1Abb + "&middot;" +
                        f2Abb +")" + CSPAN + "</html>");
                return label;
            }
            
        } else if ((!LupascoPanel.SIGNS && LupascoPanel.FULL) || (!LupascoPanel.SIGNS && !LupascoPanel.FULL)){
            if (withSign){
                return new JLabel("<html>" + oConBegSpan + "La conjunción entre <i>" + f1Name + "</i><br>y <i>" +
                        f2Name +"</i>, implica:&nbsp;" + CSPAN + "</html>");
            } else if (!withSign){
                label.setText("<html>" + oConFinSpan + "&nbsp;(Continua: "+ f1Name + " Y " +
                        f2Name +")" + CSPAN + "</html>");
                return label;
            }
        }
        return new JLabel("Error");
    }

    /*
        LABELS FOR THE SUBCONJUNCTIONS
    */
    JLabel getSubconjunctionLabel(int subconjunction){
        // if user wants only signs and full format
        if (LupascoPanel.SIGNS && LupascoPanel.FULL){
            return getSFLabel(subconjunction);
        } else if (LupascoPanel.SIGNS && !LupascoPanel.FULL){
            return getSALabel(subconjunction);
        } else if (!LupascoPanel.SIGNS && LupascoPanel.FULL){
            return getWFLabel(subconjunction);
        } else if (!LupascoPanel.SIGNS && !LupascoPanel.FULL){
            return getWALabel(subconjunction);
        }
    return new JLabel("Error");
    }

    JLabel getSFLabel(int subCon) {
        Implication implication;
        
        // if there are no parents in the list it means we are at level 0, so 
        // just add the only item (we dont need the parents list)
        if (parents.isEmpty()){

            implication = new Implication(disjunctions.get(0), subCon);
            
            implication.setLast(disjunctions.get(0), subCon);

            return new JLabel(implication.getImplication());
            
        } else if (!parents.isEmpty()){
            implication = new Implication(disjunctions.get(0), parents.get(0));
            
            int sub=1;
            
            for (Disjunction d : disjunctions){
                
                // root is already done by implication, so skip it
                if (d.equals(disjunctions.get(0))) continue;
                
                // if it is the last disjunction, parents would be empty, so
                // we end the recursion
                if (d.equals(disjunctions.get(disjunctions.size()-1))){
                    implication.addImplication(d, subCon, implication.getLeftTerm(), implication.getRightTerm());
                    implication.setLast(d, subCon);
                    return new JLabel(implication.getImplication());
                }
                
                // if it is neither the first nor the last, build from the
                // previous (maybe the first)
                implication.addImplication(d, parents.get(sub), implication.getLeftTerm(), implication.getRightTerm());
                sub++;
            }
        }
        return new JLabel();
    }
    
    private JLabel getSALabel(int subCon) {
        // I have disjunctions (the last of which is the one that
        // matters for abbreviated format) and parents (not used).
        
        Implication implication;
        
        // Same as get SFLabel() but with some modifications (no iteration)
            implication = new Implication(
                    disjunctions.get(disjunctions.size()-1), subCon);
            implication.setLast(disjunctions.get(disjunctions.size()-1), subCon);
            return new JLabel(implication.getImplication());
    }
    
    private JLabel getWFLabel(int subconjunction) {
        // With words and full -> names
        
        String f1Name=amuyaña.getF1Name(disjunctions.get(disjunctions.size()-1));
        String f2Name=amuyaña.getF2Name(disjunctions.get(disjunctions.size()-1));
        String conName;
        switch(subconjunction){
            case 0:{
                conName=amuyaña.getCon1Name(disjunctions.get(disjunctions.size()-1));
                
                String string = "<html>" + oSubcon + "La actualización de <i>" +
                    f1Name + "</i> implica la "
                    + "potencialización de <i>" + f2Name + "</i>,<br> lo "
                    + "que equivale a <i>" + conName + "</i>, y a su vez implica: ";
                return new JLabel(string);
            } case 1:{
                conName=amuyaña.getCon2Name(disjunctions.get(disjunctions.size()-1));
                
                String string = "<html>" + oSubcon + "La actualización de <i>" +
                        f2Name + "</i> implica la potencialización de <i>" +
                        f1Name + "</i>,<br> lo que equivale a <i>" + conName +
                        "</i>, y a su vez implica: ";
                return new JLabel(string);
            } case 2:{
                conName=amuyaña.getCon3Name(disjunctions.get(disjunctions.size()-1));
                
                String string = "<html>" + oSubcon + "Ni la actualización de <i>"
                        + f1Name + "</i> o de <i>" + f2Name + "</i> implica la "
                        + "potencialización de <i>" + f2Name + "</i> o de <i>"
                        + f1Name + "</i>,<br> lo que equivale a <i>" + conName +
                        "</i>, y a su vez implica: ";
                return new JLabel(string);
            }
        }
        return new JLabel();
    }
    
    private JLabel getWALabel(int subconjunction) {
        // With words and abreviated
        
        String string;
        switch(subconjunction){
            case 0:{
                string = "<html><i>" + oSubcon + amuyaña.getCon1Name(disjunctions.get(disjunctions.size()-1)) + CSPAN + "</i></html>";
                return new JLabel(string);
                
            } case 1:{
                string = "<html><i>" + oSubcon + amuyaña.getCon2Name(disjunctions.get(disjunctions.size()-1)) + CSPAN + "</i></html>";
                return new JLabel(string);
            } case 2:{
                string = "<html><i>" + oSubcon + amuyaña.getCon3Name(disjunctions.get(disjunctions.size()-1)) + CSPAN + "</i></html>";
                return new JLabel(string);
            }
        }
        return new JLabel();
    }    

    static JLabel getEmptyMessage(){
        return new JLabel("<html>"+oMessSpan+"&nbsp;- Empty -&nbsp;"+CSPAN+"</html>");
    }

    private void settings() {
        switch(LupascoPanel.SIZE){
            case(0):{
                oConBegSpan = "<span id=\"conBegSmall\">";
                oConFinSpan = "<span id=\"conFinSmall\">";
                oSubcon = "<span id=\"subconSmall\">";
                break;
            }case(1):{
                oConBegSpan = "<span id=\"conBegMedium\">";
                oConFinSpan = "<span id=\"conFinMedium\">";
                oSubcon = "<span id=\"subconMedium\">";
                break;
            }case(2):{
                oConBegSpan = "<span id=\"conBegLarge\">";
                oConFinSpan = "<span id=\"conFinLarge\">";
                oSubcon = "<span id=\"subconLarge\">";
                break;
            }
        }
    }
}
