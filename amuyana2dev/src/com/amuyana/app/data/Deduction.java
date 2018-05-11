/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;



public class Deduction{

    private Fcc fcc;
    private Implication implication;

    public Deduction(Fcc fcc, Implication implication) { 
            this.fcc = fcc;
            this.implication = implication;
    }

    //Metodos atributo: idFcc
    public Fcc getFcc() {
            return this.fcc;
    }
    public void setFcc(Fcc fcc) {
            this.fcc = fcc;
    }

    //Metodos atributo: idImplication
    public Implication getImplication() {
            return this.implication;
    }
    public void setImplication(Implication implication) {
            this.implication = implication;
    }

    public static void loadList(Connection connection, 
            ObservableList<Deduction> listDeduction,
            ObservableList<Fcc> listFcc,
            ObservableList<Implication> listImplication) {
        
        String sql = "SELECT id_fcc, id_implication FROM amuyana.tbl_deduction";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                for(Fcc f:listFcc){
                    if(f.getIdFcc()==result.getInt("id_fcc")){
                        for(Implication i:listImplication){
                            if(i.getIdImplication()==result.getInt("id_implication")){
                                listDeduction.add(new Deduction(f,i));
                            }
                        }
                    }
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Deduction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int saveData(Connection connection){
        String sql="INSERT INTO amuyana.tbl_deduction (id_fcc, id_implication) "
                    + "VALUES (?,?)";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql);
            
            instruction.setInt(1,this.fcc.getIdFcc());
            instruction.setInt(2,this.implication.getIdImplication());
            
            int returnInt = instruction.executeUpdate();
            return returnInt;
            
        } catch (SQLException ex) {
            Logger.getLogger(FccHasLogicSystem.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int deleteData(Connection connection){
        String sql = "DELETE FROM amuyana.tbl_deduction " +
                        "WHERE id_fcc = ? and id_implication = ?";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql);
            instruction.setInt(1, this.fcc.getIdFcc());
            instruction.setInt(2, this.implication.getIdImplication());
            return instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Deduction.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
}