/* EXTERNAL SOURCES
 * Libraries: GSON - Google GSON parser
 * Classes : ScreenImage.java (*Rob Camick)
 *           AlphaContainer.java (*Rob Camick)
 * TUTORIALS
 * THE java tutorial
 * JLeo - "Tutorial de Programacion Java - 50 - JFileChooser" - https://www.youtube.com/watch?v=PIOP3VHJdLg
 * ismailzd - "Java Tutorial | File Filter in JFileChooser" - https://www.youtube.com/watch?v=vlFC-UyNgLg
 * Aruna Karunarathna - "How to build a fat jar using Netbeans" - http://arunasujith.blogspot.be/2011/08/how-to-build-fat-jar-using-netbeans.html
 * Darryl Burke - "Stretch Icon" - https://tips4java.wordpress.com/2012/03/31/stretch-icon/
 * Rob Camick - "Backgrounds with transnparency" - https://tips4java.wordpress.com/2009/05/31/backgrounds-with-transparency/    
 * Rob Camick - "Screen Image" - https://tips4java.wordpress.com/2008/10/13/screen-image/
 * Jeff Friesen - "Styling swing components with Java CSS" - http://www.quepublishing.com/articles/article.aspx?p=1390174&seqNum=2
 */
package amuyaña;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Amuyaña implements Operations{
    
    public static void main(String[] args) throws IOException {
        // This will start Ñ which is the intermediate between Amuyaña and GUI
        ñ.Ñ.newÑ(args);
    }
    
    private String name;
    private String abb;
    private String des;
    private String author;
    private LocalDate date;
    private final LocalDate DATE;
    
    private ArrayList<Disjunction> disjunctions;
    
    public Amuyaña() {
        name = "Nombre del sistema";
        abb = "_NTD";
        des = "Este es un sistema lógico";
        author = "Dirección email del autor";
        DATE = LocalDate.now();
        date = LocalDate.now();
        disjunctions = new ArrayList<>();
        Disjunction root = new Disjunction();
        disjunctions.add(root);
    }

    public void setName(String n) { name = n; }
    public String getName() { return name; }
    
    public void setAbb(String a) { abb = a; }
    public String getAbb() { return abb; }
    
    public void setDes(String d) { des = d; }
    public String getDes() { return des; }
    
    public void setAuthor(String a){ author = a; }
    public String getAuthor(){ return author; }
    
    public String getDATE(){
        return DATE.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
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
    public String getTableDate(){return getDate();}
    
    public Disjunction createRamification() {
        Disjunction d = new Disjunction();
        disjunctions.add(d);
        return d;
    }

    public void deleteRamification(Disjunction d) {
        disjunctions.remove(disjunctions.indexOf(d));
    }
    
    public Disjunction cloneRamification(Disjunction d) {
    Disjunction newD = new Disjunction();
    
    // Disjunction
    newD.setName(d.getName());
    newD.setAbb(d.getAbb());

    // Parents
    newD.setParents(d.getParents());

    // Phenomena1: name, abb, des
    newD.getConjunction().getPhenomena().get(0).setName
        (d.getConjunction().getPhenomena().get(0).getName());
    newD.getConjunction().getPhenomena().get(0).setAbb
        (d.getConjunction().getPhenomena().get(0).getAbb());
    newD.getConjunction().getPhenomena().get(0).setDes
        (d.getConjunction().getPhenomena().get(0).getDes());
    
    // Phenomena2
    newD.getConjunction().getPhenomena().get(1).setName
        (d.getConjunction().getPhenomena().get(1).getName());
    newD.getConjunction().getPhenomena().get(1).setAbb
        (d.getConjunction().getPhenomena().get(1).getAbb());
    newD.getConjunction().getPhenomena().get(1).setDes
        (d.getConjunction().getPhenomena().get(1).getDes());
    
    // Positive conjunction
    newD.getConjunction().getPositive().setName
        (d.getConjunction().getPositive().getName());
    newD.getConjunction().getPositive().setAbb
        (d.getConjunction().getPositive().getAbb());
    newD.getConjunction().getPositive().setDes
        (d.getConjunction().getPositive().getDes());
    
    // Negative conjunction
    newD.getConjunction().getNegative().setName
        (d.getConjunction().getNegative().getName());
    newD.getConjunction().getNegative().setAbb
        (d.getConjunction().getNegative().getAbb());
    newD.getConjunction().getNegative().setDes
        (d.getConjunction().getNegative().getDes());
    
    // Symmetric conjunction
    newD.getConjunction().getSymmetric().setName
        (d.getConjunction().getSymmetric().getName());
    newD.getConjunction().getSymmetric().setAbb
        (d.getConjunction().getSymmetric().getAbb());
    newD.getConjunction().getSymmetric().setDes
        (d.getConjunction().getSymmetric().getDes());
    
    // F1A & F2P: copy position and magnitud
        // F1A
    newD.getConjunction().getPhenomena().get(0).getA().setPosition
        (d.getConjunction().getPhenomena().get(0).getA().getPosition());
    newD.getConjunction().getPhenomena().get(0).getA().setMagnitud
        (d.getConjunction().getPhenomena().get(0).getA().getMagnitud());
    
        // F2P
    newD.getConjunction().getPhenomena().get(1).getP().setPosition
        (d.getConjunction().getPhenomena().get(1).getP().getPosition());
    newD.getConjunction().getPhenomena().get(1).getP().setMagnitud
        (d.getConjunction().getPhenomena().get(1).getP().getMagnitud());
    
    // F1P & F2A: copy position and magnitud
        // F1A
    newD.getConjunction().getPhenomena().get(0).getP().setPosition
        (d.getConjunction().getPhenomena().get(0).getP().getPosition());
    newD.getConjunction().getPhenomena().get(0).getP().setMagnitud
        (d.getConjunction().getPhenomena().get(0).getP().getMagnitud());
    
        // F2P
    newD.getConjunction().getPhenomena().get(1).getA().setPosition
        (d.getConjunction().getPhenomena().get(1).getA().getPosition());
    newD.getConjunction().getPhenomena().get(1).getA().setMagnitud
        (d.getConjunction().getPhenomena().get(1).getA().getMagnitud());
    
    // F1T & F2T: copy position and magnitud
        // F1A
    newD.getConjunction().getPhenomena().get(0).getT().setPosition
        (d.getConjunction().getPhenomena().get(0).getT().getPosition());
    newD.getConjunction().getPhenomena().get(0).getT().setMagnitud
        (d.getConjunction().getPhenomena().get(0).getT().getMagnitud());
    
        // F2P
    newD.getConjunction().getPhenomena().get(1).getT().setPosition
        (d.getConjunction().getPhenomena().get(1).getT().getPosition());
    newD.getConjunction().getPhenomena().get(1).getT().setMagnitud
        (d.getConjunction().getPhenomena().get(1).getT().getMagnitud());
    
    
    // Add it to the list of disjunctions!
    disjunctions.add(newD);
    
    return newD;
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
    
    // LAS CONJUNCIONES PADRES
    public ArrayList<String> parentsIndicesToNames(Disjunction d){
        ArrayList<String> parentsNames = new ArrayList<>();
        
        for (int subC :d.getParents()){
            switch (subC%3) {
                case 0:
                    parentsNames.add(disjunctions.get(subC/3).conjunction.getPositive().getName());
                    break;
                case 1:
                    parentsNames.add(disjunctions.get(subC/3).conjunction.getNegative().getName());
                    break;
                case 2:
                    parentsNames.add(disjunctions.get(subC/3).conjunction.getSymmetric().getName());
                    break;
                default: // Should never get here
                    break;
            }
        }
        return parentsNames;
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

    public ArrayList<Integer> getParentsIndices(Disjunction d){
        return d.getParents();
    }
    
    public void setParentsIndices(Disjunction d, ArrayList<Integer> parents){
        d.setParents(parents);
    }
    
    /*
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
    
    // Valores Position and Quantum
    public void setF1PA(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getA().setPosition(pos);
    }
    public void setF1PP(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getP().setPosition(pos);
    }
    public void setF1PT(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getT().setPosition(pos);
    }
    public void setF2PA(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getA().setPosition(pos);
    }
    public void setF2PP(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getP().setPosition(pos);
    }
    public void setF2PT(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getT().setPosition(pos);
    }
    
    
    public void setF1QA(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getA().setMagnitud(pos);
    }
    public void setF1QP(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getP().setMagnitud(pos);
    }
    public void setF1QT(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(0).getT().setMagnitud(pos);
    }
    public void setF2QA(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getA().setMagnitud(pos);
    }
    public void setF2QP(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getT().setMagnitud(pos);
    }
    public void setF2QT(Disjunction d, double pos){
        d.getConjunction().getPhenomena().get(1).getT().setMagnitud(pos);
    }
    
    
    
    public double getF1PA(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getA().getPosition();
    }
    public double getF1PP(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getP().getPosition();
    }
    public double getF1PT(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getT().getPosition();
    }
    public double getF2PA(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getA().getPosition();
    }
    public double getF2PP(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getP().getPosition();
    }
    public double getF2PT(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getT().getPosition();
    }
    
    public double getF1QA(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getA().getMagnitud();
    }
    public double getF1QP(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getP().getMagnitud();
    }
    public double getF1QT(Disjunction d){
        return d.getConjunction().getPhenomena().get(0).getT().getMagnitud();
    }
    public double getF2QA(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getA().getMagnitud();
    }
    public double getF2QP(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getP().getMagnitud();
    }
    public double getF2QT(Disjunction d){
        return d.getConjunction().getPhenomena().get(1).getT().getMagnitud();
    }
    
    // OTHER METHODS
    
    public Disjunction getRoot(){
        return disjunctions.get(0);
    }
    
    public void resetCounter(){
        Disjunction.setCount(1);
        Positive.setCount(1);
        Negative.setCount(1);
        Symmetric.setCount(1);
        Phenomenon.setCount(1);
        Phenomenon.setCount2(1);
    }
    
    /*
    METHODS FOR LUPASCO TABULATOR
    */
    
    /**
     *  How many children does disjunction have for each subconjunction?. 
     * @param disjunction
     * @param rootIncluded Is root considered a child? Yes means true.
     * @return Returns number of disjunctions that are child of positive, 
     * negative and symmetric subconjunction respectively.
     */
    public int[] howManyChildren(Disjunction disjunction, boolean rootIncluded){
        int[] children = new int[3];
        
        int c0=0;
        int c1=0;
        int c2=0;
        
        int newIndex = disjunctions.indexOf(disjunction)*3;

        for (Disjunction d:disjunctions){
            if ((disjunctions.indexOf(d) == 0) && !(rootIncluded)){
                continue;
            } 
                // the result of the multiplication gives the index of the disjunction 
                if (d.getParents().contains(newIndex)){
                    c0++;
                }
                else if (d.getParents().contains(newIndex+1)){
                    c1++;
                }
                else if (d.getParents().contains(newIndex+2)){
                    c2++;
                }
        }
        
        children[0]=c0;
        children[1]=c1;
        children[2]=c2;
        return children;
    }

    @Override
    public boolean isChild(Disjunction d, int i, Disjunction c) {
        return c.getParents().contains(disjunctions.indexOf(d)*3+i);
    }


    public boolean isUniqueChild(Disjunction d, int i, Disjunction c) {  
        // if subconjunction i of d is among the parents of c, or
        // if c is child of d at subconjunction i
        if (c.getParents().contains(disjunctions.indexOf(d)*3+i)){
            // and if there is no other disjunction that has d among its parents
            for (Disjunction child2 : disjunctions){
                // exclude disjunction c from the test
                if (child2.equals(c)) continue;
                if (child2.getParents().contains(disjunctions.indexOf(d)*3+i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isTerminal(Disjunction d, boolean rootIncluded) {
        boolean terminal=true;
        
        for (int i : howManyChildren(d, rootIncluded)){
            if (i > 0) terminal=false;
        }
        return terminal;
    }
    
    public boolean hasParent(Disjunction d){
        boolean parent;
        
        if (d.getParents().isEmpty())
            return false;
        return true;
    }
    
    public ArrayList<Disjunction> getWop() {
        // build the list of disjunctions WOP
        ArrayList<Disjunction> tempWop = new ArrayList<>();
        
        // find the WOP disjunctions (excluding root since it is in rootPanel already
        for(Disjunction d:disjunctions){
            if (d.equals(getRoot()))
                continue;
            if (!hasParent(d))
                tempWop.add(d);
        }
        return tempWop;
    }

    public ArrayList<Disjunction> getMultiply() {
        ArrayList<Disjunction> tempMultiply = new ArrayList<>();
        
        // for each disjunction, Is there another disjunction that has the same subconjunction parent as d?
        for(Disjunction d:disjunctions){
            // this condition is now being evaluated at the moment of building
            // the panels, e.g. LupascoPanel.buildMultiply()
//            if (d.equals(getRoot())){continue;}
                
            for(Disjunction dis : disjunctions){
                if (dis.equals(getRoot())){continue;}
                for (int i:getParentsIndices(dis)){
                    // Do not evaluate the disjunction with itself (d = dis)
                    if (dis.equals(d)) continue;
                            
                    if (getParentsIndices(d).contains(i)){
                        
                        //if it is already in the list ignore it
                        if (tempMultiply.contains(d)){
                            continue;
                        } else if (!tempMultiply.contains(d)){
                            tempMultiply.add(d);
                        }
                        
                        if (tempMultiply.contains(dis)){
                            continue;
                        } else if (!tempMultiply.contains(dis)){
                            tempMultiply.add(dis);
                        }
                    }
                        
                }
                
            }
        }
        return tempMultiply;
    }

    public ArrayList<Disjunction> getUnite() {
        ArrayList<Disjunction> tempUnite = new ArrayList<>();
        
        // for each disjunction d, check if it has more than one parent
        for (Disjunction d:disjunctions){
            // Do not take into account root
//            if (d.equals(root())) continue;
            
            if (getParentsIndices(d).size()>1)
                tempUnite.add(d);
        }
        return tempUnite;
    }
}