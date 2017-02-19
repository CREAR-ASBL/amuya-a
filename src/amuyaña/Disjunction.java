
package amuyaña;

import java.util.ArrayList;

public class Disjunction {

    private String name;
    private String abb;
    
    Conjunction conjunction;
    
    private ArrayList<Integer> parents;

    private static int count=1;

    /**
     * Constructor.
     */
    Disjunction() {
        this.name = "Nueva ramificación "+count;
        this.abb = "NR"+count;
        count++;
        
        this.conjunction = new Conjunction();

        this.parents = new ArrayList<>();
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

    ArrayList<Integer> getParents() {
        return parents;
    }

    void setParents(ArrayList<Integer> parents) {
        this.parents = parents;
    }
}