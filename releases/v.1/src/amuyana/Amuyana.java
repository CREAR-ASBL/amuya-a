/**
 * JLeo - "Tutorial de Programacion Java - 50 - JFileChooser" - https://www.youtube.com/watch?v=PIOP3VHJdLg
 * ismailzd - "Java Tutorial | File Filter in JFileChooser" - https://www.youtube.com/watch?v=vlFC-UyNgLg
 * Aruna Karunarathna - "How to build a fat jar using Netbeans" - http://arunasujith.blogspot.be/2011/08/how-to-build-fat-jar-using-netbeans.html
 * 
 * 
 */
package amuyana;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Amuyana implements Operations{
    
    public static void main(String[] args) {
        n.N.newÑ(args);
    }
    
    private String name;
    private String abb;
    private String des;
    private String author;
    private LocalDate date;
    
    private ArrayList<Disjunction> disjunctions;
    
    public Amuyana() {
        name = "Nueva Tabla de Deducciones";
        abb = "_NTD";
        des = "Este es un sistema lógico";
        author = "Dirección email del autor";
        date = LocalDate.now();
        
        disjunctions = new ArrayList<>();
        Disjunction root = new Disjunction();
        disjunctions.add(root);
    }
    
    public Amuyana(boolean b){ }

    public void setName(String n) { name = n; }
    public String getName() { return name; }
    
    public void setAbb(String a) { abb = a; }
    public String getAbb() { return abb; }
    
    public void setDes(String d) { des = d; }
    public String getDes() { return des; }
    
    public void setAuthor(String a){ author = a; }
    public String getAuthor(){ return author; }
    
    public void setDate(LocalDate d){ date = d; }
    public String getDate(){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public ArrayList<Disjunction> getDisjunctions() { 
        return disjunctions;
    }
    
    // esta función la utiliza solamente GSON si no me equivoco
    public void setDisjunctions(ArrayList<Disjunction> d){
        disjunctions = d;
    }
    
    
    /*
    * METODOS DE LA INTERFAZ
    */
    
    // Estos métodos de la Tabla (o de la Amuyaña directamente) están repetidos
    // pero los ponemos porque en la interfaz hay esos nombres que nos permiten
    // diferenciarlos de las otras clases.
    public void setTableName(String name){ this.name = name; }
    public void setTableAbb(String abb){ this.abb = abb; }
    public void setTableDes(String des){ this.des = des;  }
    public void setTableAuthor(String author){ this.author = author;}
    public void setTableDate(LocalDate date){this.date = date;}
    
    public String getTableName(){return this.name;}
    public String getTableAbb(){return this.abb;}
    public String getTableDes(){return this.des;}
    public String getTableAuthor(){return this.author;}
    public String getTableDate(){return this.date.toString();}
    
    public Disjunction createRamification() {
        Disjunction d = new Disjunction();
        disjunctions.add(d);
        return d;
    }
    
    
// <<<<<<<<<----------------- Transladame
    public void deleteRamification(Disjunction d) {
        disjunctions.remove(disjunctions.indexOf(d));
    }
    
    public Disjunction cloneRamification(Disjunction d) {
    Disjunction d1 = new Disjunction();
    
    // Disjunction
    d1.setName(d.getName());
    d1.setAbb(d.getAbb());
    
    // Parents
    // TODO, fix bug
//    d1.setpParents(d.getpParents());
//    d1.setnParents(d.getnParents());
//    d1.setsParents(d.getsParents());
    
    // Phenomena1
    d1.getConjunction().getPhenomena().get(0).setName
        (d.getConjunction().getPhenomena().get(0).getName());
    d1.getConjunction().getPhenomena().get(0).setAbb
        (d.getConjunction().getPhenomena().get(0).getAbb());
    d1.getConjunction().getPhenomena().get(0).setDes
        (d.getConjunction().getPhenomena().get(0).getDes());
    
    // Phenomena2
    d1.getConjunction().getPhenomena().get(1).setName
        (d.getConjunction().getPhenomena().get(1).getName());
    d1.getConjunction().getPhenomena().get(1).setAbb
        (d.getConjunction().getPhenomena().get(1).getAbb());
    d1.getConjunction().getPhenomena().get(1).setDes
        (d.getConjunction().getPhenomena().get(1).getDes());
    
    // Positive conjunction
    d1.getConjunction().getPositive().setName
        (d.getConjunction().getPositive().getName());
    d1.getConjunction().getPositive().setAbb
        (d.getConjunction().getPositive().getAbb());
    d1.getConjunction().getPositive().setDes
        (d.getConjunction().getPositive().getDes());
    
    // Negative conjunction
    d1.getConjunction().getNegative().setName
        (d.getConjunction().getNegative().getName());
    d1.getConjunction().getNegative().setAbb
        (d.getConjunction().getNegative().getAbb());
    d1.getConjunction().getNegative().setDes
        (d.getConjunction().getNegative().getDes());
    
    // Symmetric conjunction
    d1.getConjunction().getSymmetric().setName
        (d.getConjunction().getSymmetric().getName());
    d1.getConjunction().getSymmetric().setAbb
        (d.getConjunction().getSymmetric().getAbb());
    d1.getConjunction().getSymmetric().setDes
        (d.getConjunction().getSymmetric().getDes());
    
    // F1A & F2P
    d1.getConjunction().getPositive().getF1A().setP
        (d.getConjunction().getPositive().getF1A().getP());
    d1.getConjunction().getPositive().getF2P().setQ
        (d.getConjunction().getPositive().getF2P().getQ());
    
    // F1P & F2A
    d1.getConjunction().getNegative().getF1P().setP
        (d.getConjunction().getNegative().getF1P().getP());
    d1.getConjunction().getNegative().getF2A().setQ
        (d.getConjunction().getNegative().getF2A().getQ());
    
    // F1T & F2T
    d1.getConjunction().getSymmetric().getF1T().setP
        (d.getConjunction().getSymmetric().getF1T().getP());
    d1.getConjunction().getSymmetric().getF2T().setQ
        (d.getConjunction().getSymmetric().getF2T().getQ());
    
    // Add it to the list of disjunctions!
    disjunctions.add(d1);
    
    return d1;
    }
    
    public void setDisjName(Disjunction d, String n){
        d.setName(n);
    }
    
    public void setDisjAbb(Disjunction d, String n){
        d.setAbb(n);
    }
    
    public String getDisjName(Disjunction d){
        return d.getName();
    }
    
    public String getDisjAbb(Disjunction d) {
        return d.getAbb();
    }
    
    public ArrayList<Conjunction.Positive> getDisjPParents(Disjunction d){
        return d.getpParents();
    }
    
    public ArrayList<Conjunction.Negative> getDisjNParents(Disjunction d){
        return d.getnParents();
    }
    
    public ArrayList<Conjunction.Symmetric> getDisjSParents(Disjunction d){
        return d.getsParents();
    }

        // CONJUNCIONES DE LA PESTAÑA RAMIFICACIONES
    public void setCon1Name(Disjunction d, String n){
        d.conjunction.getPositive().setName(n);
    }
    
    public void setCon2Name(Disjunction d, String n){
        d.conjunction.getNegative().setName(n);
    }
    
    public void setCon3Name(Disjunction d, String n){
        d.conjunction.getSymmetric().setName(n);
    }
    
    //
    public void setCon1Abb(Disjunction d, String n){
        d.conjunction.getPositive().setAbb(n);
    }
    public void setCon2Abb(Disjunction d, String n){
        d.conjunction.getNegative().setAbb(n);
    }
    public void setCon3Abb(Disjunction d, String n){
        d.conjunction.getSymmetric().setAbb(n);
    }
    
    //
    public void setCon1Des(Disjunction d, String n){
        d.conjunction.getPositive().setDes(n);
    }
    
    public void setCon2Des(Disjunction d, String n){
        d.conjunction.getNegative().setDes(n);
    }
    
    public void setCon3Des(Disjunction d, String n){
        d.conjunction.getSymmetric().setDes(n);
    }
    
    //
    public String getCon1Name(Disjunction d){
        return d.getConjunction().getPositive().getName();
    }
    
    public String getCon2Name(Disjunction d){
        return d.getConjunction().getNegative().getName();
    }
    
    public String getCon3Name(Disjunction d){
        return d.getConjunction().getSymmetric().getName();
    }
    
    //
    public String getCon1Abb(Disjunction d){
        return d.getConjunction().getPositive().getAbb();
    }
    
    public String getCon2Abb(Disjunction d){
        return d.getConjunction().getNegative().getAbb();
    }
    
    public String getCon3Abb(Disjunction d){
        return d.getConjunction().getSymmetric().getAbb();
    }
    
    //
    public String getCon1Des(Disjunction d){
        return d.getConjunction().getPositive().getDes();
    }
    
    public String getCon2Des(Disjunction d){
        return d.getConjunction().getNegative().getDes();
    }
    public String getCon3Des(Disjunction d){
        return d.getConjunction().getSymmetric().getDes();
    }
    
    // LASS CONJUNCIONES PADRES
    public ArrayList<String> getAllParentsNames(Disjunction d){
        ArrayList<String> l = new ArrayList<>();
        for(Conjunction.Positive cp : d.getpParents()){
            l.add(cp.getName());
        }
        for(Conjunction.Negative cn : d.getnParents()){
            l.add(cn.getName());
        }
        for(Conjunction.Symmetric cs : d.getsParents()){
            l.add(cs.getName());
        }
        return l;
    }
    
    /**
     * Obtener los índices donde se encuentran las conjunciones
     * contradiccionales que son padres de la disyunción d.
     * @param d La disyunción de la cual se quiere conocer los
     * índices de sus padres
     * @return Array de integers conteniendo la hubicación de las
     * conjunciones contradiccionales padres. Ej. d4 tiene padres
     * cp de d1 y cn de d2 y d3 => [1, 5, 8]
     */

    public int[] getParentsIndices(Disjunction d){
        int[] indices = new int[getAllParentsNames(d).size()];
        // para cada 
        for (int x = 0; x < indices.length;x++){
            for(Disjunction j : disjunctions){
                if(d.getpParents().contains(j.getConjunction().getPositive())){
                    indices[x]=(disjunctions.indexOf(j)*3);
                    x++;
                }
                if(d.getnParents().contains(j.getConjunction().getNegative())){
                    indices[x]=((disjunctions.indexOf(j)*3)+1);
                    x++;
                }
                if(d.getsParents().contains(j.getConjunction().getSymmetric())){
                    indices[x]=((disjunctions.indexOf(j)*3)+2);
                    x++;
                }
            }
        }
        return indices;
    }
    
    public void setParents(Disjunction d, int[] indices){

        d.getpParents().clear();
        d.getnParents().clear();
        d.getsParents().clear();
        
// Ej. int[] conjs = {0, 5, 13, 20}

//        0/3: 0 and 0%3: 0
//        5/3: 1 and 5%3: 2
//        13/3: 4 and 13%3: 1
//        20/3: 6 and 20%3: 2

        for(int x:indices){
            if (x%3==0){
                d.addPParent(disjunctions.get(x/3).
                        getConjunction().getPositive());
            }
            if (x%3==1){
                d.addNParent(disjunctions.get(x/3).
                        getConjunction().getNegative());
            }
            if (x%3==2){
                d.addSParent(disjunctions.get(x/3).
                        getConjunction().getSymmetric());
            }
        }
    }
    
    /*
     * CONJUNCTION AND PHENOMENON TAB
     * CONJUNCTION AND PHENOMENON TAB
     */
    
    public void setF1Name(Disjunction d, String n){
        d.getConjunction().getPhenomena().get(0).setName(n);
    }
    
    public void setF2Name(Disjunction d, String n){
        d.getConjunction().getPhenomena().get(1).setName(n);
    }
    
    public String getF1Name(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getName();
    }
    
    public String getF2Name(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getName();
    }
    
    public void setF1Abb(Disjunction d, String a){
        d.getConjunction().getPhenomena().get(0).setAbb(a);
    }
    
    public void setF2Abb(Disjunction d, String a){
        d.getConjunction().getPhenomena().get(1).setAbb(a);
    }
    
    public String getF1Abb(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getAbb();
    }
    
    public String getF2Abb(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getAbb();
    }
    
    public void setF1Des(Disjunction d, String e){
        d.getConjunction().getPhenomena().get(0).setDes(e);
    }
    
    public void setF2Des(Disjunction d, String e){
        d.getConjunction().getPhenomena().get(1).setDes(e);
    }
    
    public String getF1Des(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getDes();
    }
    
    public String getF2Des(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getDes();
    }
    
    public ArrayList<Conjunction.Positive> getPParents(Disjunction d){
        return d.getpParents();
    }
    
        public ArrayList<Conjunction.Negative> getNParents(Disjunction d){
        return d.getnParents();
    }
        
    public ArrayList<Conjunction.Symmetric> getSParents(Disjunction d){
        return d.getsParents();
    }
    
    public void addPParent(Disjunction d, Conjunction.Positive cp){
        d.addPParent(cp);
    }
    
    public void addNParent(Disjunction d, Conjunction.Negative np){
        d.addNParent(np);
    }
        
    public void addSParent(Disjunction d, Conjunction.Symmetric sp){
        d.addSParent(sp);
    }
    
    // OTHER METHODS
    
    public Disjunction root(){
        return disjunctions.get(0);
    }
    
    public void resetCounter(){
        Disjunction.setCount(0);
        Conjunction.setCount(0);
        Phenomenon.setCount(0);
        Phenomenon.setCount2(0);
    }
}
    