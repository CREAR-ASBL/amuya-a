/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;

import java.sql.Connection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class Conjunction{

    public static void loadList(Connection connection, ObservableList<Conjunction> listConjunction) {
        
    }

	private IntegerProperty idConjunction;
	private IntegerProperty orientation;
	private StringProperty propFormulation;
	private StringProperty description;
	private Fcc idFcc;

	public Conjunction(int idConjunction, int orientation, String propFormulation, 
String description, Fcc idFcc) { 
		this.idConjunction = new SimpleIntegerProperty(idConjunction);
		this.orientation = new SimpleIntegerProperty(orientation);
		this.propFormulation = new SimpleStringProperty(propFormulation);
		this.description = new SimpleStringProperty(description);
		this.idFcc = idFcc;
                
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
	public Fcc getIdFcc() {
		return idFcc;
	}
	public void setIdFcc(Fcc idFcc) {
		this.idFcc = idFcc;
	}
        
        public static void fillData(Connection connection, ObservableList<Conjunction> listConjunctions) {
//            try {
//                Statement instruction = connection.createStatement();
//                ResultSet resultado = instruction.executeQuery(
//                        "SELECT A.id_conjunction,"
//                                + "A.orientation,"
//                                + "A.prop_formulation,"
//                                + "A.description,"
//                                + "A.id_fcc"
//                                + "FROM conjunction A"
//                                + "INNER JOIN tbl_fcc B"
//                                + "ON (A.id_fcc = B.id_fcc"
//                );
//                while(resultado.next()){
//                    listConjunctions.add(
//                            new Conjunction(
//                                    resultado.getInt("id_conjunction"),
//                                    resultado.getInt("orientation"), 
//                                    resultado.getString("prop_formulation"), 
//                                    resultado.getString("description"), 
//                                    new Fcc(0, label, description, Boolean.TRUE, idSystem, idDialectic))
//                            )
//                    )
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Conjunction.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
        }
}