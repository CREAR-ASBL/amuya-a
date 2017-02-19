
package amuyaña;

class Symmetric {
    private String name;
    private String abb;
    private String des;

    private static int count=1;

    Symmetric(Phenomenon f1, Phenomenon f2) {
        this.name = "Nueva conjunción simétrica " + count;
        this.abb="CS" + count;
        this.des="Esta orientación corresponde/equivale/es ...\n" +
                "Es la orientación de contradicción porque...";
        count++;

        f1.setT(new T());
        f2.setT(new T());
    }

    String getName() {return name;}
    
    void setName(String name) {this.name = name;}
    
    String getAbb() {return abb;}
    
    void setAbb(String abb) {this.abb = abb;}
    
    String getDes() {return des;}
    
    void setDes(String des) {this.des = des;}
    
    static void setCount(int count){
        Symmetric.count=count;
    }
}