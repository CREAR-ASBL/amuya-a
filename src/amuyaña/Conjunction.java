
package amuyaña;

import java.util.ArrayList;

class Conjunction {
    
    private ArrayList<Phenomenon> phenomena;
    
    private Positive positive;
    private Negative negative;
    private Symmetric symmetric;
    
    /*
     * Constructor Conjunction.
     */
    Conjunction() {
        Phenomenon f1;
        Phenomenon f2;
        
        f1 = new Phenomenon();
        f2 = new Phenomenon();
        
        phenomena = new ArrayList<>();
        phenomena.add(f1);
        phenomena.add(f2);
        
        this.positive = new Positive(f1, f2);
        this.negative = new Negative(f1, f2);
        this.symmetric = new Symmetric(f1, f2);
    }

    ArrayList<Phenomenon> getPhenomena() { return phenomena; }

    void setPhenomena(ArrayList<Phenomenon> phenomena) {
        this.phenomena = phenomena;
    }

    Positive getPositive() { return positive; }

    void setPositive(Positive positive) {
        this.positive = positive;
    }

    Negative getNegative() { return negative; }

    void setNegative(Negative negative) {
        this.negative = negative;
    }

    Symmetric getSymmetric() { return symmetric; }

    void setSymmetric(Symmetric symmetric) {
        this.symmetric = symmetric;
    }

}


