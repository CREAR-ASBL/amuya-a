
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;
import java.sql.Connection;
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

public class Fcc{
    private IntegerProperty idFcc;
    private StringProperty label;
    private StringProperty description;

    public Fcc(int idFcc, String label, String description) { 
            this.idFcc = new SimpleIntegerProperty(idFcc);
            this.label = new SimpleStringProperty(label);
            this.description = new SimpleStringProperty(description);
    }

    //Metodos atributo: idFcc
    public int getIdFcc() {
            return idFcc.get();
    }
    public void setIdFcc(int idFcc) {
            this.idFcc = new SimpleIntegerProperty(idFcc);
    }
    public IntegerProperty IdFccProperty() {
            return idFcc;
    }
    //Metodos atributo: label
    public String getLabel() {
            return label.get();
    }
    public void setLabel(String label) {
            this.label = new SimpleStringProperty(label);
    }
    public StringProperty LabelProperty() {
            return label;
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


    public void saveData(){

    }

    public void updateData(){

    }

    public void deleteData(){

    }

    public static void loadList(Connection connection, 
            ObservableList<Fcc> listFcc){
        try {
            Statement instruction = connection.createStatement();
            ResultSet result = instruction.executeQuery(
                "SELECT id_fcc, "
                        + "label, "
                        + "description "
                + "FROM amuyana.tbl_fcc"
            );

            while(result.next()){

                listFcc.add(
                        new Fcc(
                                result.getInt("id_fcc"), 
                                result.getString("label"),
                                result.getString("description")
                        )
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(Fcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
