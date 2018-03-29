/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;

import java.sql.Connection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;



public class Deduction{

    public static void fillData(Connection connection, ObservableList<Deduction> listDeduction) {
        
    }

    public static void loadList(Connection connection, ObservableList<Deduction> listDeduction) {
        
    }
	private IntegerProperty idDeduction;
	private IntegerProperty idFcc;
	private IntegerProperty idImplication;

	public Deduction(int idDeduction, int idFcc, int idImplication) { 
		this.idDeduction = new SimpleIntegerProperty(idDeduction);
		this.idFcc = new SimpleIntegerProperty(idFcc);
		this.idImplication = new SimpleIntegerProperty(idImplication);
	}

	//Metodos atributo: idDeduction
	public int getIdDeduction() {
		return idDeduction.get();
	}
	public void setIdDeduction(int idDeduction) {
		this.idDeduction = new SimpleIntegerProperty(idDeduction);
	}
	public IntegerProperty IdDeductionProperty() {
		return idDeduction;
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
	//Metodos atributo: idImplication
	public int getIdImplication() {
		return idImplication.get();
	}
	public void setIdImplication(int idImplication) {
		this.idImplication = new SimpleIntegerProperty(idImplication);
	}
	public IntegerProperty IdImplicationProperty() {
		return idImplication;
	}
        /**
         * private ObservableList<Deduction> informacion;

@FXML private TableView<Deduction> tblInformacion;

@FXML private TableColumn<Deduction,Number> clmnidDeduction;
@FXML private TableColumn<Deduction,Number> clmnidFcc;
@FXML private TableColumn<Deduction,Number> clmnidImplication;


clmnidDeduction.setCellValueFactory(
 new PropertyValueFactory<Deduction,Number>("idDeduction")
);
clmnidFcc.setCellValueFactory(
 new PropertyValueFactory<Deduction,Number>("idFcc")
);
clmnidImplication.setCellValueFactory(
 new PropertyValueFactory<Deduction,Number>("idImplication")
);


tblInformacion.setItems(informacion);
         */
}