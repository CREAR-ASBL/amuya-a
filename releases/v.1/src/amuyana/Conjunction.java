
package amuyana;

import java.util.ArrayList;

class Conjunction {
    
    private ArrayList<Phenomenon> phenomena;
    
    private Positive positive;
    private Negative negative;
    private Symmetric symmetric;

    private static int count;
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
        
        this.positive = new Positive();
        this.negative = new Negative();
        this.symmetric = new Symmetric();
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

    public static void setCount(int count) {
        Conjunction.count = count;
    }

    
    /** 
     * Inner-clase de conjunciones positivas.
     * PASOS:
     * 1. ajustar los counters.
     * 2. ajustar los f1, f2... 
     *  2a. crear sub-clases de phenomenon, no inner clases
     *  2b. instanciar esos fenomena en ...?
     */

    class Positive {
        private String name;
        private String abb;
        private String des;

        private Phenomenon.A f1A;
        private Phenomenon.P f2P;

        
    /**
    * Constructor.
    */
        Positive() {
            this.name = "Nueva conjunción positiva " + count;
            this.abb="CP" + count;
            this.des="Ninguna descripción.";
            
            
            this.f1A = phenomena.get(0).new A();
            this.f2P = phenomena.get(1).new P();
        }

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getAbb() {return abb;}
        public void setAbb(String abb) {this.abb = abb;}
        public String getDes() {return des;}
        public void setDes(String des) {this.des = des;}

        public Phenomenon.A getF1A() {return f1A;}
        public void setF1A(Phenomenon.A f1A) {this.f1A = f1A;}
        public Phenomenon.P getF2P() {return f2P;}
        public void setF2P(Phenomenon.P f2P) {this.f2P = f2P;}

    }

    /** 
     * Sub-clase de conjunciones negativas.
     */

    class Negative{
        String name;
        String abb;
        String des;
        
        Phenomenon.P f1P;
        Phenomenon.A f2A;

        public Negative() {
            this.name = "Nueva conjunción negative " + count;
            this.abb="CN" + count;
            this.des="Ninguna descripción.";
            
            this.f1P = phenomena.get(0).new P();
            this.f2A = phenomena.get(1).new A();
        }

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getAbb() {return abb;}
        public void setAbb(String abb) {this.abb = abb;}
        public String getDes() {return des;}
        public void setDes(String des) {this.des = des;}

        public Phenomenon.P getF1P() {return f1P;}
        public void setF1P(Phenomenon.P f1P) {this.f1P = f1P;}
        public Phenomenon.A getF2A() {return f2A;}
        public void setF2A(Phenomenon.A f2A) {this.f2A = f2A;}
    }
    
    /** 
     * Sub-clase de conjunciones simétricas.
     */
    class Symmetric{
        String name;
        String abb;
        String des;
        
        Phenomenon.T f1T;
        Phenomenon.T f2T;

        public Symmetric() {
            this.name = "Nueva conjunción simétrica " + count;
            this.abb="CS" + count;
            this.des="Ninguna descripción.";
            count++;
            
            this.f1T = phenomena.get(0).new T();
            this.f2T = phenomena.get(1).new T();
        }

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getAbb() {return abb;}
        public void setAbb(String abb) {this.abb = abb;}
        public String getDes() {return des;}
        public void setDes(String des) {this.des = des;}

        public Phenomenon.T getF1T() {return f1T;}
        public void setF1P(Phenomenon.T f1T) {this.f1T = f1T;}
        public Phenomenon.T getF2T() {return f2T;}
        public void setF2T(Phenomenon.T f2T) {this.f2T = f2T;}
    }

}


