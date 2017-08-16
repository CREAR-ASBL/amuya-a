    
package tabulator;

import amuyaña.Disjunction;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Tabulator {

//    private static Style style;
    
    public Tabulator() {
        
    }
    
    public enum Style {
        LUPASCO, SIERPINSKI, AMUYAÑA, CHAKANA
    }
    
    public enum LupascoFormat {
        IMAGE, TEX, HTML, OPENDOCUMENT
    }
    
    /*
    IMPLEMENTACIONES DE LUPASCO
    */
    public JPanel getLupasco(boolean signs, boolean full, int color, int size){
        try {
            return LupascoPanel.getPanel(signs, full, color, size);
        } catch (IOException ex) {
            Logger.getLogger(Tabulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JPanel();
    }
    
    public Object getLupascoForExport(Tabulator.LupascoFormat format, Disjunction d, boolean signs, boolean full, int color, int size) {
        switch (format){
            case IMAGE:{
                return  LupascoPanel.getTreeForExport(d, signs, full, color, size);
            }
            case TEX:{
                return LupascoTex.getTreeForExport(d, signs, full, color, size);
            }
            case HTML:{
                break;
            }
            case OPENDOCUMENT:{
                break;
            }
        }
        return null;
    }

    public String getLupascoHTML() {
        // return Lupasco.getLatexFile();
        return new String();
    }
    
    public String getLupascoLATEX() {
        //return Lupasco.getLatexFile();
        return new String();
    }
    
    public String getLupascoOPENDOCUMENT() {
        // return Lupasco.getODFFile();
        return new String();
    }

    
    /*
    IMPLEMENTACIONES DE SIERPINSKI
    */
    
    // TO-DO
    
    /*
    IMPLEMENTACIONES DE AMUYAÑA
    */
    
    // TO-DO
    
    /*
    IMPLEMENTACIONES DE CHACANA
    */
    
    // TO-DO
    
    
}
