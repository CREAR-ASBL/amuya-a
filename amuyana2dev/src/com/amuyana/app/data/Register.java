/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amuyana.app.data;

import java.sql.Timestamp;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class Register{
	private IntegerProperty idRegister;
	private Timestamp date;
	private DoubleProperty value;
	private Conjunction conjunction;

	public Register(int idRegister, Timestamp date, Double value, 
Conjunction conjunction) { 
		this.idRegister = new SimpleIntegerProperty(idRegister);
		this.date = date;
		this.value = new SimpleDoubleProperty(value);
		this.conjunction = conjunction;
	}

	//Metodos atributo: idRegister
	public int getIdRegister() {
		return idRegister.get();
	}
	public void setIdRegister(int idRegister) {
		this.idRegister = new SimpleIntegerProperty(idRegister);
	}
	public IntegerProperty IdRegisterProperty() {
		return idRegister;
	}
	//Metodos atributo: date
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	//Metodos atributo: value
	public Double getValue() {
		return value.get();
	}
	public void setValue(Double value) {
		this.value = new SimpleDoubleProperty(value);
	}
	public DoubleProperty ValueProperty() {
		return value;
	}
	//Metodos atributo: conjunction
	public Conjunction getConjunction() {
		return conjunction;
	}
	public void setConjunction(Conjunction conjunction) {
		this.conjunction = conjunction;
	}
}