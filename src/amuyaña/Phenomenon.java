
package amuyaña;

class Phenomenon {
    private String name;
    private String abb;
    private String des;
    
    private A a;
    private P p;
    private T t;

    private static int count=1;
    private static int count2=1;
    
    Phenomenon() {
        if (count2==3) {count2=1; count++;}
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

    public A getA() { return a; }

    public void setA(A a) { this.a = a; }

    public P getP() { return p; }

    public void setP(P p) { this.p = p; }

    public T getT() { return t; }

    public void setT(T t) { this.t = t; }

    public static void setCount(int count) { Phenomenon.count = count; }

    public static void setCount2(int count2) { Phenomenon.count2 = count2; }

}

