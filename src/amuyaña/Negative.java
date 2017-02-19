
package amuyaña;

class Negative {
    private String name;
    private String abb;
    private String des;

    private static int count=1;

    Negative(Phenomenon f1, Phenomenon f2) {
        this.name = "Nueva conjunción negativa " + count;
        this.abb="CN" + count;
        this.des="Esta orientación corresponde/equivale/es ...\n" +
                "Es la orientación heterogeneizante porque...";
        count++;
        
        f1.setP(new P());
        f2.setA(new A());
    }

    String getName() {return name;}
    
    void setName(String name) {this.name = name;}
    
    String getAbb() {return abb;}
    
    void setAbb(String abb) {this.abb = abb;}
    
    String getDes() {return des;}
    
    void setDes(String des) {this.des = des;}
    
    static void setCount(int count){
        Negative.count=count;
    }
}