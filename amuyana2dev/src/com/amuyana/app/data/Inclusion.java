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

public class Inclusion{
    private IntegerProperty idInclusion;
    private Conjunction conjunction;
    
    public static int currentAutoIncrement;

    public Inclusion(int idInclusion, Conjunction conjunction) { 
        this.idInclusion = new SimpleIntegerProperty(idInclusion);
        this.conjunction = conjunction;
    }

    //Metodos atributo: idInclusion
    public int getIdInclusion() {
        return idInclusion.get();
    }
    public void setIdInclusion(int idInclusion) {
        this.idInclusion = new SimpleIntegerProperty(idInclusion);
    }
    public IntegerProperty IdInclusionProperty() {
        return idInclusion;
    }
    //Metodos atributo: conjunction
    public Conjunction getConjunction() {
        return conjunction;
    }
    public void setConjunction(Conjunction conjunction) {
        this.conjunction = conjunction;
    }

    public static void loadList(Connection connection,
            ObservableList<Inclusion> listInclusion, 
            ObservableList<Conjunction> listConjunction 
            ) {
        
        String sql = "SELECT id_inclusion, id_conjunction FROM amuyana.tbl_inclusion";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                
                for(Conjunction c:listConjunction){
                    if(c.getIdConjunction()==result.getInt("id_conjunction")){
                        listInclusion.add(new Inclusion(result.getInt("id_inclusion"),c));
                    }
                }
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(Inclusion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int saveData(Connection connection){
        String sql="INSERT INTO amuyana.tbl_inclusion (id_inclusion, id_conjunction) "
                    + "VALUES (?,?)";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
            
            instruction.setInt(1,this.idInclusion.get());
            instruction.setInt(2,this.conjunction.getIdConjunction());
            
            int returnInt = instruction.executeUpdate();
            ResultSet rs = instruction.getGeneratedKeys();
            if(rs.next()){
                Inclusion.currentAutoIncrement = rs.getInt(1);
            }
            return returnInt;
            
        } catch (SQLException ex) {
            Logger.getLogger(FccHasLogicSystem.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int deleteData(Connection connection){
        String sql = "DELETE FROM amuyana.tbl_inclusion " +
                        "WHERE id_inclusion = ? and id_conjunction = ? ";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql);
            instruction.setInt(1, this.idInclusion.get());
            instruction.setInt(2, this.conjunction.getIdConjunction());
            return instruction.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Inclusion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    @Override
    public String toString(){
        return "Inclusion: " + this.getIdInclusion();
    }
}