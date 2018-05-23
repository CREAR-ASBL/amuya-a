
package com.amuyana.app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class General{

    
    private Conjunction conjunction;
    private Inclusion inclusion;

    public General(Conjunction conjunction, Inclusion inclusion) { 
            this.conjunction = conjunction;
            this.inclusion = inclusion;
    }

    //Metodos atributo: idConjunction
    public Conjunction getConjunction() {
            return conjunction;
    }
    public void setConjunction(Conjunction conjunction) {
            this.conjunction = conjunction;
    }
    //Metodos atributo: idInclusion
    public Inclusion getInclusion() {
            return inclusion;
    }
    public void setInclusion(Inclusion inclusion) {
            this.inclusion = inclusion;
    }
 
    public static void loadList(Connection connection,
        ObservableList<General> listGeneral, 
        ObservableList<Conjunction> listConjunction,
        ObservableList<Inclusion> listInclusions) {

        String sql = "SELECT id_conjunction, id_inclusion FROM amuyana.tbl_general";

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                for(Inclusion i:listInclusions){
                    if(i.getIdInclusion()==result.getInt("id_inclusion")){
                        for(Conjunction c:listConjunction){
                            if(c.getIdConjunction()==result.getInt("id_conjunction")){
                                listGeneral.add(new General(c,i));
                            }
                        }
                    }
                }
                
            }
        } catch (SQLException ex) {

            Logger.getLogger(Inclusion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int saveData(Connection connection){
        String sql = "INSERT INTO amuyana.tbl_general (id_conjunction, id_inclusion)"
                    + "VALUES (?,?)";
        try {            
            PreparedStatement statement = connection.prepareStatement(sql, 
                    Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, this.getConjunction().getIdConjunction());
            statement.setInt(2, this.getInclusion().getIdInclusion());
            int returnInt = statement.executeUpdate();
            
//            ResultSet rs = statement.getGeneratedKeys();
//            if(rs.next()){
//                General.currentAutoIncrement = rs.getInt(1);
//            }
            return returnInt;
            
        } catch (SQLException ex) {
            Logger.getLogger(Fcc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public int deleteData(Connection connection){
        try {
            PreparedStatement instruccion = connection.prepareStatement(
                                            "DELETE FROM amuyana.tbl_general "+
                                            "WHERE id_conjunction = ? and id_inclusion = ?"
            );
            instruccion.setInt(1, this.conjunction.getIdConjunction());
            instruccion.setInt(2, this.inclusion.getIdInclusion());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int dropData(Connection connection, int idInclusion) {
        String sql = "DELETE FROM amuyana.tbl_general " +
                     "WHERE id_inclusion = ? ";
        try {
            PreparedStatement instruction = connection.prepareStatement(sql);
            
            instruction.setInt(1, idInclusion);

            return instruction.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
     
    public int updateData(Connection connection){
        return saveData(connection);
    }
}