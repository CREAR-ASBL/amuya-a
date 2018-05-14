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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Conjunction{

    public static int currentAutoIncrement;

    private IntegerProperty idConjunction;
    private IntegerProperty orientation;
    private StringProperty propFormulation;
    private StringProperty description;
    private Fcc fcc;

    public Conjunction(int idConjunction, int orientation, String propFormulation, 
String description, Fcc fcc) { 
            this.idConjunction = new SimpleIntegerProperty(idConjunction);
            this.orientation = new SimpleIntegerProperty(orientation);
            this.propFormulation = new SimpleStringProperty(propFormulation);
            this.description = new SimpleStringProperty(description);
            this.fcc = fcc;
            
    }

    //Metodos atributo: idConjunction
    public int getIdConjunction() {
            return idConjunction.get();
    }
    public void setIdConjunction(int idConjunction) {
            this.idConjunction = new SimpleIntegerProperty(idConjunction);
    }
    public IntegerProperty IdConjunctionProperty() {
            return idConjunction;
    }
    //Metodos atributo: orientation
    public int getOrientation() {
            return orientation.get();
    }
    public void setOrientation(int orientation) {
            this.orientation = new SimpleIntegerProperty(orientation);
    }
    public IntegerProperty orientation(){
        return orientation;
    }
    //Metodos atributo: propFormulation
    public String getPropFormulation() {
            return propFormulation.get();
    }
    public void setPropFormulation(String propFormulation) {
            this.propFormulation = new SimpleStringProperty(propFormulation);
    }
    public StringProperty PropFormulationProperty() {
            return propFormulation;
    }
    //Metodos atributo: description
    public String getDescription() {
            return description.get();
    }
    public void setDescription(String description) {
            this.description = new SimpleStringProperty(description);
    }
    public StringProperty DescriptionProperty() {
            return description;
    }
    //Metodos atributo: idFcc
    public Fcc getFcc() {
            return this.fcc;
    }
    public void setFcc(Fcc idFcc) {
            this.fcc = idFcc;
    }

    public static void loadData(Connection connection, 
            ObservableList<Conjunction> listConjunctions, 
            ObservableList<Fcc> listFcc) {
        String sql = "SELECT id_conjunction, "
                            + "orientation, "
                            + "prop_formulation, "
                            + "description, "
                            + "id_fcc "
                            + "FROM amuyana.tbl_conjunction";
        try {
            Statement instruction = connection.createStatement();
            ResultSet resultado = instruction.executeQuery(sql);

            while(resultado.next()){
                for(Fcc f:listFcc){
                    if(f.getIdFcc()==resultado.getInt("id_fcc")){
                        listConjunctions.add(new Conjunction(
                            resultado.getInt("id_conjunction"),
                            resultado.getInt("orientation"), 
                            resultado.getString("prop_formulation"), 
                            resultado.getString("description"), 
                            f)
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conjunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public String toString(){
        return this.getPropFormulation();
    }
    
    public int saveData(Connection connection){
        String sql="INSERT INTO amuyana.tbl_conjunction (id_conjunction, orientation, prop_formulation, description, id_fcc)"
                    + "VALUES (?,?,?,?,?)";
        try {
            // Cual es la instruction sql para insertar datos?
            PreparedStatement instruction = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            
            instruction.setInt(1,this.getIdConjunction());
            instruction.setInt(2,this.getOrientation());
            instruction.setString(3,this.getPropFormulation());
            instruction.setString(4,this.getDescription());
            instruction.setInt(5,this.getFcc().getIdFcc());
            
            int result = instruction.executeUpdate();
            
            ResultSet rs = instruction.getGeneratedKeys();
            while(rs.next()){
                Conjunction.currentAutoIncrement = rs.getInt(1);
            }
            
            return result;
            
        } catch (SQLException ex) {
            Logger.getLogger(LogicSystem.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
                
    }
    
    public int updateData(Connection connection){
        String sql = "UPDATE amuyana.tbl_conjunction SET prop_formulation = ?,  "+
            " description = ? WHERE id_conjunction = ?";
        try {
            PreparedStatement instruccion =
                            connection.prepareStatement(sql);
            instruccion.setString(1, propFormulation.get());
            instruccion.setString(2, description.get());
            instruccion.setInt(3, idConjunction.get());
            
            return instruccion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteData(Connection connection){
        String sql="DELETE FROM amuyana.tbl_conjunction WHERE id_conjunction = ?";
        try {
            PreparedStatement instruccion = connection.prepareStatement(sql);
            instruccion.setInt(1, this.idConjunction.get());
            int response = instruccion.executeUpdate();
            return response;
        } catch (SQLException ex) {
            Logger.getLogger(Conjunction.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}