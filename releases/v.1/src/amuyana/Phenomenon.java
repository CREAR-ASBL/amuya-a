
package amuyana;

class Phenomenon {
    private String name;
    private String abb;
    private String des;
    
    private static int count;
    private static int count2;
    
    Phenomenon() {
        if (count2==2) {count2=0; count++;}
        name = "Nuevo elemento " + count+" "+count2;
        abb = "e"+count+count2;
        des = "Sin descripción.";
        count2++;
        
    }
    
    String getName() {return name;}
    void setName(String name) {this.name = name;}
    String getAbb() {return abb;}
    void setAbb(String abb) {this.abb = abb;}
    String getDes() {return des;}
    void setDes(String des) {this.des = des;}

    public static void setCount(int count) {
        Phenomenon.count = count;
    }

    public static void setCount2(int count2) {
        Phenomenon.count2 = count2;
    }


    class A{
        double P;
        double Q;

        public double getP() {return P;}
        public void setP(double P) {this.P = P;}
        public double getQ() {return Q;}
        public void setQ(double Q) {this.Q = Q;}

        public A() {
            this.P = 0;
            this.Q = 0;

        }
    }

    class P {
        double P;
        double Q;

        public double getP() {return P;}
        public void setP(double P) {this.P = P;}
        public double getQ() {return Q;}
        public void setQ(double Q) {this.Q = Q;}

        public P() {
            this.P = 0;
            this.Q = 0;
        }
    }

    class T {
        double P;
        double Q;

        public double getP() {return P;}
        public void setP(double P) {this.P = P;}
        public double getQ() {return Q;}
        public void setQ(double Q) {this.Q = Q;}

        public T() {
            this.P = 0;
            this.Q = 0;
        }
    }
}

