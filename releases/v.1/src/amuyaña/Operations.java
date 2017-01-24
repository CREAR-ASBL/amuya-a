/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amuyaña;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ayar Portugal
 */

public interface Operations {

    // METHODS FOR THE TAB "SYSTEM"
    // METHODS FOR THE TAB "SYSTEM"
    // METHODS FOR THE TAB "SYSTEM"
    
    void setTableName(String name);
    void setTableAbb(String abb);
    void setTableDes(String des);
    void setTableAuthor(String eoa);
    void setTableDate(LocalDate date);
    
    String getTableName();
    String getTableAbb();
    String getTableDes();
    String getTableAuthor();
    String getTableDate();
    
    /*
    * METHODS FOR THE TAB "RAMIFICATIONS"
    */ 
    
    void setDisjName(Disjunction d, String n);
    void setDisjAbb(Disjunction d, String n);
    
    String getDisjName(Disjunction d);
    String getDisjAbb(Disjunction d);
    
    ArrayList<Disjunction> getDisjunctions();
    
    void setCon1Name(Disjunction d, String n);
    void setCon2Name(Disjunction d, String n);
    void setCon3Name(Disjunction d, String n);
    
    String getCon1Name(Disjunction d);
    String getCon2Name(Disjunction d);
    String getCon3Name(Disjunction d);
    
    void setCon1Abb(Disjunction d, String n);
    void setCon2Abb(Disjunction d, String n);
    void setCon3Abb(Disjunction d, String n);
    
    String getCon1Abb(Disjunction d);
    String getCon2Abb(Disjunction d);
    String getCon3Abb(Disjunction d);
    
    void setCon1Des(Disjunction d, String n);
    void setCon2Des(Disjunction d, String n);
    void setCon3Des(Disjunction d, String n);
    
    String getCon1Des(Disjunction d);
    String getCon2Des(Disjunction d);
    String getCon3Des(Disjunction d);
    
    void deleteRamification(Disjunction d);
    
    Disjunction createRamification();
    
    Disjunction cloneRamification(Disjunction d);
    
    ArrayList<String> getAllParentsNames(Disjunction d);
    
    // Supposes that all conjunctions are listed continously starting from the
    // first disjunction
    int[] getParentsIndices(Disjunction d);
    
    /**
     * Sets the conjunctions listed by i as parents of disjunctions d. This will 
     * first clear all parents and then set only the selected ones in the array
     * i.
     * TODO: create a addParents() method.
     * @param d The disjunction to which the parents contained in i will be
     * set.
     * @param i Array of integers representing the index value where the 
     * subconjunctions are. the index values will always lie in a space where
     * the subconjunctions (PC, NC, SC) are listed by order:
     * - PC of disjunction 1
     * - NC of disjunction 1
     * - SC of disjunction 1
     * - PC of disjunction 2
     * - and so on
     * For example to set NC of d1 as parent of d2, one would invoque:
     * setParents(d, i); where i=[1], because its index is 1.
     */
    void setParents(Disjunction d, int[] i);
    
//    ArrayList<String> getPParentsNames(Disjunction d);
//    ArrayList<String> getPParentsAbbs(Disjunction d);
//    ArrayList<String> getPParentsDes(Disjunction d);
//    
//    ArrayList<String> getNParentsNames(Disjunction d);
//    ArrayList<String> getNParentsAbbs(Disjunction d);
//    ArrayList<String> getNParentsDes(Disjunction d);
//    
//    ArrayList<String> getSParentsNames(Disjunction d);
//    ArrayList<String> getSParentsAbbs(Disjunction d);
//    ArrayList<String> getSParentsDes(Disjunction d);
    
    /**
     * 
//     * @param d La disyunción de la cual se va a establecer su padre.
//     * @param dp La disyunción cuya conjunción contradiccional positiva es la
     * conjunción de la cual surge la disyunción d.
     */
//    void setPParent(Disjunction d, Disjunction dp);
//    void setNParent(Disjunction d, Disjunction dp);
//    void setSParent(Disjunction d, Disjunction dp);
    
        
//    ArrayList getDisjPParents(Disjunction d);
//    ArrayList getDisjNParents(Disjunction d);
//    ArrayList getDisjSParents(Disjunction d);
    
    /*
     * METHODS FOR THE TAB "IMPLICATIONS"
     * METHODS FOR THE TAB "IMPLICATIONS"
     * METHODS FOR THE TAB "IMPLICATIONS"
     */

    void setF1Name(Disjunction d, String n);
    void setF2Name(Disjunction d, String n);
    
    String getF1Name(Disjunction d);
    String getF2Name(Disjunction d);
    
    void setF1Abb(Disjunction d, String n);
    void setF2Abb(Disjunction d, String n);
    
    String getF1Abb(Disjunction d);
    String getF2Abb(Disjunction d);
    
    void setF1Des(Disjunction d, String n);
    void setF2Des(Disjunction d, String n);
    
    String getF1Des(Disjunction d);
    String getF2Des(Disjunction d);

    // OTHER METHODS
    
    Disjunction root();
    void resetCounter();
}
