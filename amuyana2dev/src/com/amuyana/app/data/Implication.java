/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;

import com.amuyana.app.cls.Value;
import java.sql.Connection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;



public class Implication{

    public static void fillData(Connection connection, ObservableList<Implication> listImplication) {
        
    }

    public static void loadList(Connection connection, ObservableList<Implication> listImplication) {
        
    }
	private IntegerProperty idImplication;
	private Value orientation;
	private IntegerProperty idFcc;

	public Implication(int idImplication, Value orientation, int idFcc) { 
		this.idImplication = new SimpleIntegerProperty(idImplication);
		this.orientation = orientation;
		this.idFcc = new SimpleIntegerProperty(idFcc);
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
	//Metodos atributo: orientation
	public Value getOrientation() {
		return orientation;
	}
	public void setOrientation(Value orientation) {
		this.orientation = orientation;
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
}
