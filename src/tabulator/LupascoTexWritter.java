
package tabulator;

import amuyaña.Disjunction;
import java.util.ArrayList;
import ñ.Ñ;

public class LupascoTexWritter {
    private static final amuyaña.Operations amuyaña = Ñ.amuyaña;
    private static final String FONTSIZE = LupascoTex.fontSize;
    private static final String BASECOLOR = LupascoTex.baseColor;
    private String label="";
    
    private String topPostFix="";
    private String midPostFix="";
    private String botPostFix="";
    
    private ArrayList<Disjunction> disjunctions;
    private ArrayList<Integer> parentsSequence;

    LupascoTexWritter(ArrayList<Disjunction> tempList, ArrayList<Integer> tempParents) {
        this.disjunctions=tempList;
        this.parentsSequence=tempParents;
    }

    void addLabel(Disjunction d) {
        // FULL parameter does not matter for the label, only 'signs' or 'words'
        if(LupascoTex.SIGNS){
            label = "$\\hspace{10pt}(" + amuyaña.getF1Abb(d) + "\\cdot " +
                amuyaña.getF2Abb(d) + ")\\hspace{10pt}$";
        } else if(!LupascoTex.SIGNS){
            String f1N = amuyaña.getF1Name(d);
            String f2N = amuyaña.getF2Name(d);
            String f1A = amuyaña.getF1Abb(d);
            String f2A = amuyaña.getF2Abb(d);
            
            String size="";
            
            switch(LupascoTex.SIZE){
                case 0:{
                    size = "\\tiny ";
                    break;
                }
                case 1:{
                    size = "\\scriptsize ";
                    break;
                }
                case 2:{
                    size = "\\footnotesize ";
                    break;
                }
            }
            
            label = "\\hspace{10pt}\\text{\\hspace{10pt}\\parbox[t]{5cm}{\\vspace{-15pt}" + size + "La conjunción entre \\textbf{\\textit{" + f1N + " (" + f1A + ")}} y " +
                    "\\textbf{\\textit{" + f2N + " (" + f2A + ")}} implica:}\\hspace{10pt}}";
        }
    }
    
    void addPostfix(Disjunction d, int con) {
        String string="";
        String f1 = amuyaña.getF1Abb(d);
        String f2 = amuyaña.getF2Abb(d);
        
        switch(con){
            case 0:{
                if (topPostFix.isEmpty()){
                    string = "\\,\\big\\{\\," + "(" + f1 + "\\cdot " +
                    f2 + ")";
                } else if (!topPostFix.isEmpty()){
                    string = ",(" + f1 + "\\cdot " +
                    f2 + ")";
                }
                topPostFix += string;
                break;
            }
            case 1:{
                if (midPostFix.isEmpty()){
                    string = "\\,\\big\\{\\," + "(" + f1 + "\\cdot " +
                    f2 + ")";
                } else if (!midPostFix.isEmpty()){
                    string = ",(" + f1 + "\\cdot " +
                    f2 + ")";
                }
                midPostFix += string;
                break;
            }
            case 2:{
                if (botPostFix.isEmpty()){
                    string = "\\,\\big\\{\\," + "(" + f1 + "\\cdot " +
                    f2 + ")";
                } else if (!botPostFix.isEmpty()){
                    string = ",(" + f1 + "\\cdot " +
                    f2 + ")";
                }
                botPostFix += string;
                break;
            }
        }
    }

    void embed(String buildTex, int i) {
        switch (i){
            case 0:{ topPostFix = "\n\\text{" + buildTex + "}\n";
                break;
            }
            case 1:{ midPostFix = "\n\\text{" + buildTex + "}\n";
                break;
            }
            case 2:{ botPostFix = "\n\\text{" + buildTex + "}\n";
                break;
            }
        }
    }

    String getTexString() {
        String string;
       
        string = "\\hspace{10pt}" + colorAdjusted() + "\n" +
        FONTSIZE + "\\colorbox{backgroundColor}{\n" +
        "\\hspace{-10pt}" + label + "$\\left\\{\\begin{array}{l}\n" +
        getFormulation(0) + topPostFix + "\\\\ \n" +
        getFormulation(1) + midPostFix + "\\\\ \n" +
        getFormulation(2) + botPostFix + "\\end{array}\\right.$}";
        return string;
    }

    private String colorAdjusted() {
        String colorAdjusted=BASECOLOR;
        // if it is empty it means it is the first level.
        if(parentsSequence.isEmpty()){
            return colorAdjusted;
        }
        // if the parser jumps here it means this is a level above 1.
        
        // The definition below is low-cost. Each line of code specifying the color
        // in tex format ends by 'x.xx}' (without quotes) by luck, where x.xx
        // is a double specifying the darkness parameter of the cmyk-type color.
        String value = BASECOLOR.substring(BASECOLOR.length()-5, BASECOLOR.length()-1);
        
        double firstValue = Double.parseDouble(value);
        
        double newValue = firstValue + parentsSequence.size()*0.09;
        
        colorAdjusted = BASECOLOR.replace(value, String.valueOf(newValue));
        
        return colorAdjusted;
    }

    private String getFormulation(int subCon) {
        String formulation="";
        if (LupascoTex.FULL && LupascoTex.SIGNS){
            formulation = getFormulationFS(subCon);
        } else if (LupascoTex.FULL && !LupascoTex.SIGNS){
            formulation = getFormulationFW(subCon);
        } else if (!LupascoTex.FULL && LupascoTex.SIGNS){
            formulation = getFormulationAS(subCon);
        } else if (!LupascoTex.FULL && !LupascoTex.SIGNS){
            formulation = getFormulationAW(subCon);
        }
        return formulation;
    }
    
    private String getFormulationFS(int subCon) {
        //Options: words/signs full/abbreviated, in ImplicationTex?
        
        ImplicationTex implication;
        
        // if there are no parents in the list it means we are at level 0, so 
        // just add the only item (we dont need the parents list)
        if (parentsSequence.isEmpty()){

            implication = new ImplicationTex(disjunctions.get(0), subCon);
            
            implication.setLast(disjunctions.get(0), subCon);

            return implication.getImplication();
            
        } else if (!parentsSequence.isEmpty()){
            implication = new ImplicationTex(disjunctions.get(0), parentsSequence.get(0));
            
            int sub=1;
            
            for (Disjunction d : disjunctions){
                
                // root is already done by implication, so skip it
                if (d.equals(disjunctions.get(0))) continue;
                
                // if it is the last disjunction, parentsSequence would be out
                // of index, so we end the recursion
                if (d.equals(disjunctions.get(disjunctions.size()-1))){
                    implication.addLevel(d, subCon, implication.getLeftTerm(), implication.getRightTerm());
                    implication.setLast(d, subCon);
                    return implication.getImplication();
                }
                
                // if it is neither the first nor the last, build from the
                // previous (maybe the first)
                implication.addLevel(d, parentsSequence.get(sub), implication.getLeftTerm(), implication.getRightTerm());
                sub++;
            }
        }
        return "error";
    }
    
    private String getFormulationFW(int subCon) {
        
        Disjunction d = disjunctions.get(disjunctions.size()-1);
        
        String formulation="";
        
        final String OS = "\\textbf{\\textit{"; // OS=Open style
        final String CS = "}}"; // CS=Close style
        
        String f1N = amuyaña.getF1Name(d);
        String f1A = " (" + amuyaña.getF1Abb(d) + ")";
        String f2N = amuyaña.getF2Name(d);
        String f2A = " (" + amuyaña.getF2Abb(d) + ")";
        
        String m1 = "La actualización de ";
        String m2 = " implica la potencialización de ";
        String m3 = ", lo que equivale a ";
        
        String m4 = "La ni actualización ni potencialización de ";
        String m5 = " implica la ni potencialización ni actualización de ";
        String m6 = " (e inversamente), lo que equivale a ";
                
        String conN;
        String conA;
        
        String size="";
            
            switch(LupascoTex.SIZE){
                case 0:{
                    size = "\\tiny ";
                    break;
                }
                case 1:{
                    size = "\\scriptsize ";
                    break;
                }
                case 2:{
                    size = "\\footnotesize ";
                    break;
                }
            }
        
        switch (subCon){
            case 0:{
                conN=amuyaña.getCon1Name(d);
                conA= " (" + amuyaña.getCon1Abb(d) + ")";
                formulation = "\\parbox[t]{6cm}{" + size + m1 + OS + f1N + f1A + CS + 
                        m2 + OS + f2N + f2A + CS + m3 + OS + conN + conA + CS + "}\n";
                break;
            }
            case 1:{
                conN=amuyaña.getCon2Name(d);
                conA= " (" + amuyaña.getCon2Abb(d) + ")";
                formulation = "\\parbox[t]{6cm}{" + size + m1 + OS + f2N + f2A + CS + 
                        m2 + OS + f1N + f1A + CS + m3 + OS + conN + conA + CS + "}\n";
                break;
            }
            case 2:{
                conN=amuyaña.getCon3Name(d);
                conA= " (" + amuyaña.getCon3Abb(d) + ")";
                formulation = "\\parbox[t]{6cm}{" + size + m4 + OS + f1N + f1A + CS + 
                        m5 + OS + f2N + f2A + CS + m6 + OS + conN + conA + CS + "}\n";
                break;
            }
        }
        
        return "\\text{" + formulation + "}";
    }

    private String getFormulationAS(int subCon) {
        Disjunction d = disjunctions.get(disjunctions.size()-1);
        
        ImplicationTex implication = new ImplicationTex(d, subCon);
        implication.setLast(d, subCon);
        return implication.getImplication();        
    }

    private String getFormulationAW(int subCon) {
        
        Disjunction d = disjunctions.get(disjunctions.size()-1);
        
        String formulation="";
        
        final String OS = "\\textbf{\\textit{"; // OS=Open style
        final String CS = "}}"; // CS=Close style
                
        String conN;
        String conA;
        
        String size="";
            
            switch(LupascoTex.SIZE){
                case 0:{
                    size = "\\tiny ";
                    break;
                }
                case 1:{
                    size = "\\scriptsize ";
                    break;
                }
                case 2:{
                    size = "\\footnotesize ";
                    break;
                }
            }
        
        switch (subCon){
            case 0:{
                conN = amuyaña.getCon1Name(d);
                conA= " (" + amuyaña.getCon1Abb(d) + ")";
                formulation = "\\parbox[t]{5cm}{" + size + OS + conN + conA + CS + "}\n";
                break;
            }
            case 1:{
                conN=amuyaña.getCon2Name(d);
                conA= " (" + amuyaña.getCon2Abb(d) + ")";
                formulation = "\\parbox[t]{5cm}{" + size + OS + conN + conA + CS + "}\n";
                break;
            }
            case 2:{
                conN=amuyaña.getCon3Name(d);
                conA= " (" + amuyaña.getCon3Abb(d) + ")";
                formulation = "\\parbox[t]{5cm}{" + size + OS + conN + conA + CS + "}\n";
                break;
            }
        }
        
        return "\\text{" + formulation + "}";
    }
    
    
}
