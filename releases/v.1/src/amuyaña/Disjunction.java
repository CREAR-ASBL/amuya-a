
package amuyaña;

import java.util.ArrayList;

public class Disjunction {

    private String name;
    private String abb;
    
    Conjunction conjunction;
    
    private ArrayList<Conjunction.Positive> pParents;
    private ArrayList<Conjunction.Negative> nParents;
    private ArrayList<Conjunction.Symmetric> sParents;

    private static int count;

    /**
     * Constructor.
     */
    Disjunction() {
        this.name = "Nueva ramificación "+count;
        this.abb = "NR"+count;
        count++;
        
        this.conjunction = new Conjunction();

        pParents = new ArrayList<Conjunction.Positive>();
        nParents = new ArrayList<Conjunction.Negative>();
        sParents = new ArrayList<Conjunction.Symmetric>();
        
    }
    
    void setName(String n){name = n;}
    void setAbb(String n){abb=n;}
    
    String getName(){return this.name;}    
    String getAbb(){return this.abb;}

    public static void setCount(int count) {
        Disjunction.count = count;
    }
    
    Conjunction getConjunction() {return this.conjunction;}
    void setConjunction(Conjunction c) { this.conjunction = c; }
    
    ArrayList<Conjunction.Positive> getpParents() {
        return this.pParents;
    }

    void setpParents(ArrayList<Conjunction.Positive> pParents) {
        this.pParents = pParents;
    }

    ArrayList<Conjunction.Negative> getnParents() {
        return nParents;
    }

    void setnParents(ArrayList<Conjunction.Negative> nParent) {
        this.nParents = nParent;
    }

    ArrayList<Conjunction.Symmetric> getsParents() {
        return sParents;
    }

    void setsParents(ArrayList<Conjunction.Symmetric> sParent) {
        this.sParents = sParent;
    }
    
    /*
    * Otros métodos, derivados de Disjunction y éste a su vez de la interfaz
    * Operations.
    */

    void addPParent(Conjunction.Positive cp) {pParents.add(cp);}
    void addNParent(Conjunction.Negative np) {nParents.add(np);}
    void addSParent(Conjunction.Symmetric sp) {sParents.add(sp);}

}