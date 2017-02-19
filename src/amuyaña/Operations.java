
package amuyaña;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ayar Portugal
 */

public interface Operations {
    
    /*
        METHODS FOR THE TAB "SYSTEM"
    */
    
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
    String getDATE();
    /*
        METHODS FOR THE TAB "RAMIFICATIONS"
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

    ArrayList<Integer> getParentsIndices(Disjunction d);
    
    ArrayList<String> parentsIndicesToNames(Disjunction d);
            
    /**
     * Sets the conjunctions listed by i as parents of disjunctions d. This will 
     * first clear all parents and then set only the selected ones in the array
     * i.
     * TODO: create a addParents() method.
     * @param d The disjunction to which the parents contained in i will be
     * set.
     * @param subconjunctionIndices Array of integers representing the index value where the 
     * subconjunctions are. the index values will always lie in a space where
     * the subconjunctions (PC, NC, SC) are listed by order:
     * - PC of disjunction 1
     * - NC of disjunction 1
     * - SC of disjunction 1
     * - PC of disjunction 2
     * - and so on
     * For example to set NC of d1 as parent of d2, one would invoque:
     * setParents(d2, i); where i=[1], because its second in the list.
     */
    void setParentsIndices(Disjunction d, ArrayList<Integer> subconjunctionIndices);
    
    /*
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
    
    void setF1PA(Disjunction d, double pos);
    void setF1PP(Disjunction d, double pos);
    void setF1PT(Disjunction d, double pos);
    void setF2PA(Disjunction d, double pos);
    void setF2PP(Disjunction d, double pos);
    void setF2PT(Disjunction d, double pos);
    
    void setF1QA(Disjunction d, double pos);
    void setF1QP(Disjunction d, double pos);
    void setF1QT(Disjunction d, double pos);
    void setF2QA(Disjunction d, double pos);
    void setF2QP(Disjunction d, double pos);
    void setF2QT(Disjunction d, double pos);
    
    double getF1PA(Disjunction d);
    double getF1PP(Disjunction d);
    double getF1PT(Disjunction d);
    double getF2PA(Disjunction d);
    double getF2PP(Disjunction d);
    double getF2PT(Disjunction d);
    
    double getF1QA(Disjunction d);
    double getF1QP(Disjunction d);
    double getF1QT(Disjunction d);
    double getF2QA(Disjunction d);
    double getF2QP(Disjunction d);
    double getF2QT(Disjunction d);
    
    /*
        METHODS FOR THE GUI
    */
    
    void resetCounter();
    
    Disjunction getRoot();

    
    /*
        METHODS FOR LUPASCO TABULATOR
    */
    
    int[] howManyChildren(Disjunction d, boolean rootIncluded); //returns array of int of children for each subconjunction

    boolean isChild(Disjunction disjunction, int subconjunction, Disjunction child);

    boolean isUniqueChild(Disjunction disjunction, int subconjunction, Disjunction child);
    
    boolean isTerminal(Disjunction d, boolean rootIncluded);
    
    boolean hasParent(Disjunction d);
    
    ArrayList<Disjunction> getWop();
    
    ArrayList<Disjunction> getMultiply();
    
    ArrayList<Disjunction> getUnite();
    
    
}
