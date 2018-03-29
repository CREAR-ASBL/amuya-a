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



public class Element{

    private IntegerProperty idElement;
    private StringProperty symbol;

    private Boolean polarity;
    private Fcc fcc;

    public Element(int idElement, String description, 
Boolean polarity, Fcc fcc) { 
            this.idElement = new SimpleIntegerProperty(idElement);

            this.polarity = polarity;
            this.fcc = fcc;
    }

    //Metodos atributo: idElement
    public int getIdElement() {
            return idElement.get();
    }
    public void setIdElement(int idElement) {
            this.idElement = new SimpleIntegerProperty(idElement);
    }
    public IntegerProperty IdElementProperty() {
            return idElement;
    }
    //Metodos atributo: symbol
    public String getSymbol() {
            return symbol.get();
    }
    public void setSymbol(String symbol) {
            this.symbol = new SimpleStringProperty(symbol);
    }
    public StringProperty SymbolProperty() {
            return symbol;
    }

    //Metodos atributo: polarity
    public Boolean getPolarity() {
            return polarity;
    }
    public void setPolarity(Boolean polarity) {
            this.polarity = polarity;
    }
    //Metodos atributo: idFcc
    public Fcc getFcc() {
            return this.fcc;
    }
    public void setFcc(Fcc fcc) {
            this.fcc = fcc;
    }
    
    public static void loadList(Connection connection, 
            ObservableList<Element> listElement) {
//        try {
//                // MYSQL: vamos a llenar el cobx con los sistemas lógicos
//                
//                // esta  no se puede instanciar, para usarla creamos un método especial
//                Statement statement = connection.createStatement();
//                
//                // clase para almacenar el resultado del query
//                // retorna filas y columnas. 
//                ResultSet resultado = statement.executeQuery(
//                        "SELECT id_element, "
//                                + "symbol, "
//                                + "polarity, "
//                                + "id_fcc "
//                                + "FROM amuyana.tbl_element"
//                );
//                
//                // el método next hace que se seleccione un registro del 
//                // 'resultado', 
//                while(resultado.next()){
//                    listElement.add(new Element(
//                            resultado.getInt("id_element"), 
//                            resultado.getString("symbol"), 
//                            resultado.getBoolean("polarity"), 
//                            resultado.getInt("id_fcc"))
//                    );
//                }
//                
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(LogicSystem.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }       
}