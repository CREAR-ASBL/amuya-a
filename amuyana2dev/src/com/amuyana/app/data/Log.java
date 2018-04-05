package com.amuyana.app.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class Log{

    private Timestamp date;
	private StringProperty type;
	private StringProperty message;
	private User user;

	public Log(Timestamp date, String type, String message, 
User user) { 
		this.date = date;
		this.type = new SimpleStringProperty(type);
		this.message = new SimpleStringProperty(message);
		this.user = user;
	}

	//Metodos atributo: date
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	//Metodos atributo: type
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}
	public StringProperty TypeProperty() {
		return type;
	}
	//Metodos atributo: message
	public String getMessage() {
		return message.get();
	}
	public void setMessage(String message) {
		this.message = new SimpleStringProperty(message);
	}
	public StringProperty MessageProperty() {
		return message;
	}
	//Metodos atributo: user
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    public static void loadList(Connection connection, ObservableList<Conjunction> listLog) {
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(
//                    "SELECT date, type, user, ");
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}