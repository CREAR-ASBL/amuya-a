/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;
import java.sql.Connection;
import java.sql.Timestamp;
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
	private Boolean inUse;
	private LogicSystem logicSystem;

	public Fcc(int idFcc, String label, String description, 
Boolean inUse, LogicSystem logicSystem) { 
		this.idFcc = new SimpleIntegerProperty(idFcc);
		this.label = new SimpleStringProperty(label);
		this.description = new SimpleStringProperty(description);
		this.inUse = inUse;
		this.logicSystem = logicSystem;
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
	//Metodos atributo: inUse
	public Boolean getInUse() {
		return inUse;
	}
	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}
	//Metodos atributo: idSystem
	public LogicSystem getLogicSystem() {
		return logicSystem;
	}
	public void setLogicSystem(LogicSystem logicSystem) {
		this.logicSystem = logicSystem;
	}
        
        public void saveForm(){
            
        }
        
        public void updateForm(){
            
        }
        
        public void clearForm(){
            
        }
        
        public static void loadList(Connection connection, ObservableList<Fcc> listFcc){
            try {
                Statement instruction = connection.createStatement();
                ResultSet result = instruction.executeQuery(
                    "SELECT A.id_fcc, "
                            + "A.label, "
                            + "A.description, "
                            + "A.in_use, "
                            + "A.id_logic_system, "
                            + "B.id_logic_system, "
                            + "B.label, "
                            + "B.description, "
                            + "B.creation_date "
                    + "FROM tbl_fcc A "
                    + "INNER JOIN tbl_logic_system B "
                    + "ON (A.id_logic_system = B.id_logic_system) "
                );
                
                while(result.next()){
                    
                    listFcc.add(
                            new Fcc(
                                    
                                    result.getInt("A.id_fcc"), 
                                    result.getString("A.label"),
                                    result.getString("A.description"), 
                                    result.getBoolean("A.in_use"), 
                                    new LogicSystem(
                                            result.getInt("B.id_logic_system"),
                                            result.getString("B.label"), 
                                            result.getString("B.description"), 
                                            result.getTimestamp("B.creation_date")
                                    )
                            )
                    );
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Fcc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

         
}
