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

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class LogicSystem{

    
	private IntegerProperty idLogicSystem;
	private StringProperty label;
	private StringProperty description;
	private Timestamp creationDate;

	public LogicSystem(int idLogicSystem, String label, String description, 
                Timestamp creationDate) { 
            this.idLogicSystem = new SimpleIntegerProperty(idLogicSystem);
            this.label = new SimpleStringProperty(label);
            this.description = new SimpleStringProperty(description);
            this.creationDate = creationDate;
	}

	//Metodos atributo: idSystem
	public int getIdSystem() {
		return idLogicSystem.get();
	}
	public void setIdSystem(int idSystem) {
		this.idLogicSystem = new SimpleIntegerProperty(idSystem);
	}
	public IntegerProperty IdSystemProperty() {
		return idLogicSystem;
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
	//Metodos atributo: creationDate
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
        
        // Desde aqui nos conectamos a la base de datos, extraemos toda la 
        // información de las tablas y las enviamos ahí donde se necesiten.
        public static void loadList(Connection connection, ObservableList<LogicSystem> listLogicSystems){
            
            try {
                // MYSQL: vamos a llenar el cobx con los sistemas lógicos
                
                // esta  no se puede instanciar, para usarla creamos un método especial
                Statement statement = connection.createStatement();
                
                // clase para almacenar el resultado del query
                // retorna filas y columnas. 
                ResultSet resultado = statement.executeQuery(
                        "SELECT id_logic_system, label, description, creation_date FROM amuyana.tbl_logic_system");
                
                // el método next hace que se seleccione un registro del 
                // 'resultado', 
                while(resultado.next()){
                    listLogicSystems.add(new LogicSystem(
                            resultado.getInt("id_logic_system"), 
                            resultado.getString("label"), 
                            resultado.getString("description"),
                            resultado.getTimestamp("creation_date")));
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(LogicSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
        public String toString(){
            return this.idLogicSystem.get() + ". " + this.label.get();
        }
        /**
         * TABLE VIEW
private ObservableList<System> informacion;

@FXML private TableView<System> tblInformacion;

@FXML private TableColumn<System,Number> clmnidSystem;
@FXML private TableColumn<System,String> clmnlabel;
@FXML private TableColumn<System,String> clmndescription;
@FXML private TableColumn<System,Date> clmncreationDate;


clmnidSystem.setCellValueFactory(
 new PropertyValueFactory<System,Number>("idSystem")
);
clmnlabel.setCellValueFactory(
 new PropertyValueFactory<System,String>("label")
);
clmndescription.setCellValueFactory(
 new PropertyValueFactory<System,String>("description")
);
clmncreationDate.setCellValueFactory(
 new PropertyValueFactory<System,Date>("creationDate")
);


tblInformacion.setItems(informacion);
         */
}