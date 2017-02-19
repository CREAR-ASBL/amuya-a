
package ñ;
import tabulator.Tabulator;
import amuyaña.Operations;
import amuyaña.Amuyaña;
import amuyaña.Disjunction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/** Operaciones complementarias de la GUI.
 * Una razón por la cual esta clase es necesaria es que no podemos modificar el
 * código de GUI fuera de los componentes de java.swing (y necesitamos espacio).
 * Genera complejas tablas de deducciones utilizando únicamente texto...
 * @author Ayar Portugal
 */
public abstract class Ñ{
    private static boolean open;
    private static boolean modified;
    private static String file;
    
    public static Operations amuyaña;
    
    static public void newÑ(String[] args) throws IOException {
        GUI.main(args);
//      FOR DEBUGING (comment previous line)
//        newAmuyaña();

//        try {
//            openAmuyañaDebug("/home/ayar/Amuyaña/debug1.ña");
//        } catch (FileNotFoundException ex) {        }
    }
    

    /**
     * Initialize a (new) Amuyaña instance.
     */
    static void newAmuyaña(){
        amuyaña = new Amuyaña();
        isOpen();
    }
    
    static void saveAmuyaña() throws IOException {
        
        // chose your favorite serializer
        switch("GSON"){
            case "GSON":{
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                try (Writer writer = new FileWriter(file)
                ) {
                    gson.toJson(amuyaña, writer);
                } break;
            }
            case "GSON_TREE":{
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                try (Writer writer = new FileWriter(file)
                ) {
                    gson.toJson(amuyaña.getDisjunctions().get(0), writer);
                } break;
            }
            default: System.out.println("Nothing saved: chose serializer");
        }
    }

    static void openAmuyaña() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader(file);
            
        if (amuyaña == null) {
            amuyaña = new Amuyaña();
        } else if (amuyaña != null) {
            amuyaña = null;
            amuyaña = new Amuyaña();
        }
        
        amuyaña = gson.fromJson(reader, Amuyaña.class);
    }
    
    static void openAmuyañaDebug(String s) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader(s);
        Ñ.amuyaña = gson.fromJson(reader, Amuyaña.class);
        setFile(s);
    }
    
    /*
        METHODS FOR THE GUI
    */

    static boolean isOpen() {
        return open;
    }

    static void setOpen(boolean open) {
        Ñ.open = open;
    }

    static boolean isModified() {
        return modified;
    }

    static void setModified(boolean modified) {
        Ñ.modified = modified;
    }

    public static String getFile() {
        return file;
    }

    protected static void setFile(String file) {
        Ñ.file = file;
    }
    
    static String nameInTitle(){
        if(file!=null) { return file+" - "; }
        else if (file == null){ return "";}
        return "";
    }
    
    
    /*
    Conversión de padres int[] -> ArrayList
    */
    static void setParentsIndices(Disjunction d, int[] selectedIndices) {
        ArrayList<Integer> parents = new ArrayList<>();
        for (int i:selectedIndices){
            parents.add(i);
        }
        amuyaña.setParentsIndices(d, parents);
    }
    
    static int[] getParentsIndices(Disjunction disjunction) {
        int[] parentsIndices = new int[amuyaña.getParentsIndices(disjunction).size()];
        int count=0;
        for (int i:amuyaña.getParentsIndices(disjunction)){
            parentsIndices[count] = i;
            count++;
        }
        return parentsIndices;
    }
    
    static ArrayList<String> getParentsNames(Disjunction d) {
        return amuyaña.parentsIndicesToNames(d);
    }
    
    // obtain a subconjunction based on d and int i=0,1,2
    // 
    
    static public ArrayList<String> getAllSubconjunctionsNames() {
        ArrayList<String> l = new ArrayList<>();
        // para cada disyunción, obtener cada conjunción.
        amuyaña.getDisjunctions().stream().map((d) -> {
            l.add(amuyaña.getCon1Name(d));
            return d;
        }).map((d) -> {
            l.add(amuyaña.getCon2Name(d));
            return d;
        }).forEachOrdered((d) -> {
            l.add(amuyaña.getCon3Name(d));
        });
/*        
        Esto último es igual a:
        
        for (Disjunction d : table.getDisjunctions()){
            l.add(table.getCon1Name(d));
            l.add(table.getCon2Name(d));
            l.add(table.getCon3Name(d));
        }
*/
        
        return l;
    }
    
    static public String getRamFormulation(Disjunction d){
        
        String dis = amuyaña.getDisjAbb(d);
        
        String f1 = "<span>" + amuyaña.getF1Abb(d) + "</span>";
        String f2 = "<span>" + amuyaña.getF2Abb(d) + "</span>";
//        String oBP = "<span style=\"font-size:16px\">(</span>";
//        String cBP = "<span style=\"font-size:16px\">)</span>";
//        String oSpan = "<span style=\"font-size:14px; text-align:center;\">";
//        String cSpan = "</span>";
        String dot = "&#183;";
        
        String f1i = "<sup style=\"font-size:90%\">" + amuyaña.getF1Abb(d) + "</sup>";
        String f2i = "<sup style=\"font-size:90%\">" + amuyaña.getF2Abb(d) + "</sup>";
        String PC = "<sup style=\"font-size:90%\">" + amuyaña.getCon1Abb(d) + "</sup>";
        String NC = "<sup style=\"font-size:90%\">" + amuyaña.getCon2Abb(d) + "</sup>";
        String SC = "<sup style=\"font-size:90%\">" + amuyaña.getCon3Abb(d) + "</sup>";
        
        String A = "<sub>A</sub>";
        String P = "<sub>P</sub>";
        String T = "<sub>T</sub>";
        
        String oBP = "<span style=\"font-size:160%\">(</span>";
        String oMP = "<span style=\"font-size:140%\">(</span>";
        String oSP = "<span style=\"font-size:120%\">(</span>";
        String cBP = "<span style=\"font-size:160%\">)</span>";
        String cMP = "<span style=\"font-size:140%\">)</span>";
        String cSP = "<span style=\"font-size:120%\">)</span>";
        
        String or = "&#8744;";
        String equiv= "&nbsp;&#8801;&nbsp;";
        String I = "<span style=\"font-size:150%\">&sup;</span>";
        String E = "<span style=\"font-size:150%\">&sup;&#773</span>";

        String oSpan = "<span style=\"font-size:medium;font-weight: 200;\">";
        String cSpan = "</span>";
        
        return "<html>" + oSpan + dis + equiv + oBP + f1 + dot + f2 + cBP + equiv + oBP + 
            oMP + oSP + I + f1i + A + cSP + I + PC + oSP + E + f2i + P + cSP + cMP + or +
            oMP + oSP + E + f2i + A + cSP + I + NC + oSP + I + f1i + P + cSP + cMP + or +
            oMP + oSP + I + f1i + T + cSP + I + SC + oSP + E + f2i + T + cSP + cMP + cBP +
                cSpan + "</html>";
    }
    
//    static public String getRamFormulation(Disjunction d){
//        String dis = amuyaña.getDisjAbb(d);
//        String f1 = "<sup style=\"font-size:90%\">" + amuyaña.getF1Abb(d) + "</sup>";
//        String f2 = "<sup style=\"font-size:90%\">" + amuyaña.getF2Abb(d) + "</sup>";
//        String PC = "<sup style=\"font-size:90%\">" + amuyaña.getCon1Abb(d) + "</sup>";
//        String NC = "<sup style=\"font-size:90%\">" + amuyaña.getCon2Abb(d) + "</sup>";
//        String SC = "<sup style=\"font-size:90%\">" + amuyaña.getCon3Abb(d) + "</sup>";
//        
//        String A = "<sub>A</sub>";
//        String P = "<sub>P</sub>";
//        String T = "<sub>T</sub>";
//        
//        String oBP = "<span style=\"font-size:160%\">(</span>";
//        String oMP = "<span style=\"font-size:140%\">(</span>";
//        String oSP = "<span style=\"font-size:120%\">(</span>";
//        String cBP = "<span style=\"font-size:160%\">)</span>";
//        String cMP = "<span style=\"font-size:140%\">)</span>";
//        String cSP = "<span style=\"font-size:120%\">)</span>";
//        
//        String or = "&#8744;";
//        String equiv= "&nbsp;&#8801;&nbsp;";
//        String I = "<span style=\"font-size:150%\">&sup;</span>";
//        String E = "<span style=\"font-size:150%\">&sup;&#773</span>";
//
//        String oSpan = "<span style=\"font-size:medium;\">";
//        String cSpan = "</span>";
//        
//        String s = "<html>" + oSpan + dis+ equiv + oBP + 
//            oMP + oSP + I + f1 + A + cSP + I + PC + oSP + E + f2 + P + cSP + cMP + or +
//            oMP + oSP + E + f2 + A + cSP + I + NC + oSP + I + f1 + P + cSP + cMP + or +
//            oMP + oSP + I + f1 + T + cSP + I + SC + oSP + E + f2 + T + cSP + cMP + cBP +
//                cSpan + "</html>";
//        return s;
//    }
//    
//    static public String getConFormulation(Disjunction d){
//        String f1 = "<span>" + amuyaña.getF1Abb(d) + "</span>";
//        String f2 = "<span>" + amuyaña.getF2Abb(d) + "</span>";
//        String oBP = "<span style=\"font-size:16px\">(</span>";
//        String cBP = "<span style=\"font-size:16px\">)</span>";
//        String oSpan = "<span style=\"font-size:14px; text-align:center;\">";
//        String cSpan = "</span>";
//        String dot = "&#183;";
//        
//        return "<html>" + oSpan + oBP + f1 + dot + f2 + cBP + cSpan + "</html>";
//    }

    /*
    METODOS PARA LA PESTAÑA REPRESENTACIONES TABULARES
    */

            
    static void showTime(Tabulator.Style STYLE, boolean signs,
            boolean full, int color, int size) throws IOException{
                
        // the package that generates the content to be shown in the screen
        Tabulator tabulator = new Tabulator();
        
        switch(STYLE){
            case LUPASCO :{
                JPanel lupascoPanel;

                lupascoPanel = tabulator.getLupasco(signs, full, color, size);
                lupascoPanel.setSize(400, 400);

                GUI_Visualize visualizer = new GUI_Visualize(lupascoPanel);
                visualizer.setVisible(true);
                visualizer.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            } case SIERPINSKI :{
                
            } case CHAKANA :{
                
            } case AMUYAÑA :{
                
            }
        }
                
    }
    
    public static void exportLupasco(int d, boolean signs, boolean full,
            int color, int size, String file) throws IOException{
        Disjunction disjunction = amuyaña.getDisjunctions().get(d);
        Tabulator tabulator = new Tabulator();
        ScreenImage.writeImage(ScreenImage.createImage(
                tabulator.getLupascoForExport(disjunction, signs,
                        full, color, size)), file);
    }

    static boolean isParent(int selectedIndex) {
        for (Disjunction d : Ñ.amuyaña.getDisjunctions()){
                    
            if((Ñ.amuyaña.getParentsIndices(d).contains(
                    Ñ.amuyaña.getDisjunctions().indexOf(
                        Ñ.amuyaña.getDisjunctions().get(selectedIndex))*3)) ||
                    
                (Ñ.amuyaña.getParentsIndices(d).contains(
                    Ñ.amuyaña.getDisjunctions().indexOf(
                        Ñ.amuyaña.getDisjunctions().get(selectedIndex))*3+1))||
                (Ñ.amuyaña.getParentsIndices(d).contains(
                    Ñ.amuyaña.getDisjunctions().indexOf(
                        Ñ.amuyaña.getDisjunctions().get(selectedIndex))*3+2))){
                return true;
            }
        }
        return false;
    }
}
