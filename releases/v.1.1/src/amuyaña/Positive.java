
package amuyaña;

class Positive {
    private String name;
    private String abb;
    private String des;

    private static int count=1;

    Positive(Phenomenon f1, Phenomenon f2) {
        this.name = "Nueva conjunción positiva " + count;
        this.abb="CP" + count;
        this.des="Ninguna descripción.";
        count++;

        f1.setA(new A());
        f2.setP(new P());
    }

    String getName() {return name;}
    
    void setName(String name) {this.name = name;}
    
    String getAbb() {return abb;}
    
    void setAbb(String abb) {this.abb = abb;}
    
    String getDes() {return des;}
    
    void setDes(String des) {this.des = des;}

    static void setCount(int count){
        Positive.count=count;
    }
}