/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ñ;
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


/** Operaciones complementarias de la GUI.
 * Una razón por la cual esta clase es necesaria es que no podemos modificar el
 * código de GUI fuera de los componentes de java.swing (y necesitamos espacio).
 * Genera complejas tablas de deducciones utilizando únicamente texto...
 * @author Ayar Portugal
 */
public abstract class Ñ {
    private static boolean open;
    private static boolean modified;
    private static String file;
    
    static Operations table;
    
    static public void newÑ(String[] args) {
        GUI.main(args);
    }

    /**
     * Instanciates an Amuyaña instance.
     */
    static public void newAmuyaña(){
        table = new Amuyaña();
        isOpen();
    }

    static public void saveAmuyaña() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(file)
        ) {
            gson.toJson(table, writer);
        }
    }

    /**
     * TODO
     */
    static public void openAmuyaña() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader(file);
            
        if (table == null) {
            table = new Amuyaña(true);
        } else if (table != null) {
            table = null;
            table = new Amuyaña(true);
        }
        
        table = gson.fromJson(reader, Amuyaña.class);
        setOpen(true);
        
    }

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

    public static void setFile(String file) {
        Ñ.file = file;
    }

    static ArrayList<String> getAllParents(){
        ArrayList<String> l = new ArrayList<>();
        // para cada disyunción, obtener cada conjunción.

        for (Disjunction d : table.getDisjunctions()){
            l.add(table.getCon1Name(d));
            l.add(table.getCon2Name(d));
            l.add(table.getCon3Name(d));
        }
        return l;
    }
    
    static String nameInTitle(){
        if(file!=null) { return file+" - "; }
        else if (file == null){ return "";}
        return "";
    }
}
