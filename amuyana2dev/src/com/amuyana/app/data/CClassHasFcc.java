package com.amuyana.app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class CClassHasFcc{
    private CClass cClass;
    private Fcc fcc;

    public CClassHasFcc(CClass cClass, Fcc fcc) { 
            this.cClass = cClass;
            this.fcc = fcc;
    }

    //Metodos atributo: cClass
    public CClass getCClass() {
            return cClass;
    }
    public void setCClass(CClass cClass) {
            this.cClass = cClass;
    }
    //Metodos atributo: fcc
    public Fcc getFcc() {
            return fcc;
    }
    public void setFcc(Fcc fcc) {
            this.fcc = fcc;
    }
    
    public static void loadList(Connection connection, 
            ObservableList<CClassHasFcc> listCClassHasFcc,
            ObservableList<CClass> listCClass,
            ObservableList<Fcc> listFcc){
        String sql = "SELECT id_c_class, id_fcc "
                + "FROM amuyana.tbl_c_class_has_tbl_fcc";
        
        try {
            Statement instruction = connection.createStatement();
            ResultSet result = instruction.executeQuery(sql);
            
            while(result.next()){
                for(CClass c:listCClass){
                    if(c.getIdCClass()==result.getInt("id_c_class")){
                        for(Fcc f : listFcc){
                            if(f.getIdFcc()==result.getInt("id_fcc")){
                                listCClassHasFcc.add(new CClassHasFcc(c, f));
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FccHasLogicSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int saveData(Connection connection){
        String sql="INSERT INTO amuyana.tbl_c_class_has_tbl_fcc (id_c_class, id_fcc) "
                    + "VALUES (?,?)";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql);
            
            instruction.setInt(1,this.cClass.getIdCClass());
            instruction.setInt(2,this.fcc.getIdFcc());
            
            int returnInt = instruction.executeUpdate();
            return returnInt;
            
        } catch (SQLException ex) {
            Logger.getLogger(FccHasLogicSystem.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int deleteData(Connection connection){
        try {
            PreparedStatement instruccion = connection.prepareStatement(
                                            "DELETE FROM amuyana.tbl_c_class_has_tbl_fcc "+
                                            "WHERE id_c_class = ? and id_fcc = ?"
            );
            instruccion.setInt(1, this.cClass.getIdCClass());
            instruccion.setInt(2, this.fcc.getIdFcc());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}