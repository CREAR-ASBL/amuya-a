
package tabulator;

import amuyaña.Disjunction;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import static ñ.Ñ.amuyaña;

public abstract class LupascoPanel extends JPanel {
    private static JPanel mainPanel;
    private static JPanel rootPanel;
    private static JPanel wopPanel;
    private static JPanel multiplyPanel;
    private static JPanel unitePanel;
    
    static boolean SIGNS;
    static boolean FULL;
    static int COLOR;
    static int SIZE;

    static StyleSheet s;
    static HTMLEditorKit kit;
    
    static JPanel getPanel(boolean signs, boolean full, int color, int size) throws IOException {
        LupascoPanel.SIGNS=signs;
        LupascoPanel.FULL=full;
        LupascoPanel.COLOR=color;
        LupascoPanel.SIZE=size;
        
        init(); // Initialize variables: JPanels (JLabels are initialized by TreePanel)
        setProperties(); // Set default properties
        buildPanels(); // build each Panel individually (i.e. embed other panels inside them)
        embedPanels(); // Embed root, wop, multiply and unite in mainPanel
        return mainPanel; // Finally return mainPanel
    }
    
    /*
        Creation of the table of deductions
    */
    static void init() {
        try {
            s = loadStyleSheet(new FileInputStream(new File("src/tabulator/style.css")));
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        
        LupascoPanel.kit = new HTMLEditorKit();
        
        kit.setStyleSheet(s);
        
//        s.addRule("#special {position:relative; right:10px; color:blue;}");
        
        mainPanel = new JPanel(new GridBagLayout());
        rootPanel = new JPanel(new GridBagLayout());
        wopPanel = new JPanel(new GridBagLayout());
        multiplyPanel = new JPanel(new GridBagLayout());
        unitePanel = new JPanel(new GridBagLayout());
    }
    
    private static void setProperties(){
        
        MatteBorder border1 = new MatteBorder(1, 1, 1, 1, Color.black);
        
        // MAIN PANEL
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(border1);
        mainPanel.setOpaque(true);
        
        // SUBPANELS
//        rootPanel.setBorder(border3);
        rootPanel.setOpaque(false);
        
//        wopPanel.setBorder(border3);
        wopPanel.setOpaque(false);
        
//        multiplyPanel.setBorder(border3);
        multiplyPanel.setOpaque(false);
        
//        unitePanel.setBorder(border3);
        unitePanel.setOpaque(false);
    }

    private static void buildPanels(){
        buildRoot();
        buildWOP();
        buildMultiply();
        buildUnite();
    }
    
    private static void buildRoot() {

        GridBagConstraints c = new GridBagConstraints();
        
        ArrayList<Disjunction> list = new ArrayList<>();
        ArrayList<Integer> parentSeq = new ArrayList<>();
        
        list.add(amuyaña.getRoot());
        
        c.gridx = 0;
        c.gridy = 0;
        rootPanel.add(getTree(list, parentSeq),c);
    }

    private static void buildWOP() {
        // build the list of disjunctions WOP
        ArrayList<Disjunction> tempList;
        ArrayList<Integer> parentSeq;
                
        // if the list is non empty, just build the empty WOP Panel
        if (amuyaña.getWop().isEmpty()){
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            wopPanel.add(LupascoWritter.getEmptyMessage(),c);
        } else if (!amuyaña.getWop().isEmpty()){
            // for each disjunction that has not parents build a treePanel and 
            // add it next to the previous one in wopPanel
            int countx=0;
            int county=0;
            for (Disjunction d:amuyaña.getWop()){
                
                // reset the tempList
                tempList=new ArrayList<>();
                parentSeq = new ArrayList<>();
                
                tempList.add(d);

                GridBagConstraints c = new GridBagConstraints();

                c.gridx = 0+countx;
                c.gridy = 0+county;
                c.insets = new Insets(10,0,10,20);
                c.anchor= GridBagConstraints.WEST;
                wopPanel.add(getTree(tempList, parentSeq),c);

                countx++;
                
                // if there are two panels already in a row, add another row
                if (countx==2){
                    countx=0;
                    county++;
                }
            }
        }
    }

    private static void buildMultiply() {
        ArrayList<Disjunction> tempList;
        ArrayList<Integer> parentSeq;

        // if the list is non empty, just build the empty WOP Panel
        if (amuyaña.getMultiply().isEmpty()){
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            multiplyPanel.add(LupascoWritter.getEmptyMessage(),c);
        } else if (!amuyaña.getMultiply().isEmpty()){
            
            int countx=0;
            int county=0;
            for (Disjunction d:amuyaña.getMultiply()){
                if (d.equals(amuyaña.getRoot())) continue;
                
                // reset the tempList
                tempList=new ArrayList<>();
                parentSeq = new ArrayList<>();
                
                tempList.add(d);

                GridBagConstraints c = new GridBagConstraints();

                c.gridx = 0+countx;
                c.gridy = 0+county;
                c.insets = new Insets(10,0,10,20);
                c.anchor= GridBagConstraints.WEST;
                multiplyPanel.add(getTree(tempList, parentSeq),c);
                
                countx++;
                // if there are two elements in a row, add another row
                if(countx==2){
                    countx=0;
                    county++;
                }
            }
        }
    }

    private static void buildUnite() {
        ArrayList<Disjunction> tempList;
        ArrayList<Integer> parentSeq;// if the list is non empty, just build the empty WOP Panel
        
        // if there are no disjunctions in the getUnite list, print a message
        if (amuyaña.getUnite().isEmpty()){
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            unitePanel.add(LupascoWritter.getEmptyMessage(),c);
        } else if (!amuyaña.getUnite().isEmpty()){
            // for each disjunction that has not parents build a treePanel and 
            // add it next to the previous one in wopPanel
            int countx=0;
            int county=0;
            for (Disjunction d:amuyaña.getUnite()){
                if (d.equals(amuyaña.getRoot())) continue;
                // reset the tempList
                tempList=new ArrayList<>();
                parentSeq = new ArrayList<>();
                
                tempList.add(d);

                GridBagConstraints c = new GridBagConstraints();

                c.gridx = 0+countx;
                c.gridy = 0+county;
                c.insets = new Insets(10,0,10,20);
                c.anchor= GridBagConstraints.WEST;
                unitePanel.add(getTree(tempList, parentSeq),c);

                countx++;
                if(countx==2){
                    countx=0;
                    county++;
                }
            }
        }
    }

    static void embedPanels() throws FileNotFoundException, IOException{
        GridBagConstraints c = new GridBagConstraints();
        
        LupascoWritter writter = new LupascoWritter();

        JPanel mainTitlePanel = new JPanel(new GridBagLayout());
        JPanel rootTitlePanel = new JPanel(new GridBagLayout());
        JPanel wopTitlePanel = new JPanel(new GridBagLayout());
        JPanel multiplyTitlePanel = new JPanel(new GridBagLayout());
        JPanel uniteTitlePanel = new JPanel(new GridBagLayout());
        
        mainTitlePanel.setOpaque(false);
        rootTitlePanel.setOpaque(false);
        wopTitlePanel.setOpaque(false);
        multiplyTitlePanel.setOpaque(false);
        uniteTitlePanel.setOpaque(false);

        c.anchor = GridBagConstraints.WEST;
        
        c.insets = new Insets(10,1,2,0); // For three subpanels of branchsPanels
        mainTitlePanel.add(writter.getMainTitle(), c);
        rootTitlePanel.add(writter.getTitle(0), c);
        wopTitlePanel.add(writter.getTitle(1), c);
        multiplyTitlePanel.add(writter.getTitle(2), c);
        uniteTitlePanel.add(writter.getTitle(3), c);
        
        c.insets = new Insets(10,20,10,0);
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(mainTitlePanel,c);
        
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(rootTitlePanel,c);
        
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(rootPanel,c);
        
        c.gridy = 3;
        mainPanel.add(wopTitlePanel,c);
        
        c.gridy = 4;
        mainPanel.add(wopPanel,c);
        
        c.gridy = 5;
        mainPanel.add(multiplyTitlePanel,c);
        
        c.gridy = 6;
        mainPanel.add(multiplyPanel,c);
        
        c.gridy = 7;
        mainPanel.add(uniteTitlePanel,c);
        
        c.gridy = 8;
        mainPanel.add(unitePanel,c);
    }
        
    /*
        OTHER METHODS
    */

    static TreePanel getTree(ArrayList<Disjunction> treePanelList, ArrayList<Integer> parentSeq){
        ArrayList<Disjunction> tempList = treePanelList;
        
        ArrayList<Integer> tempParentSeq = parentSeq;

        TreePanel treePanel = new TreePanel(tempList, tempParentSeq);
        
        
        Disjunction disjunction = tempList.get(tempList.size()-1);

        boolean remove;
         
        // in the first iteration we want the label of the disjunction, just like
        // it will be referenced later by terminal branches
        if (tempList.indexOf(disjunction) == 0){
            treePanel.addPrefix(disjunction);
        }

        for(Disjunction d : amuyaña.getDisjunctions()){
            
            // by default, do not modify the lists at the end of one iteration
            // except if it is returning from an interation in which case
            // the temporary lists need to be adjusted, i.e. the last element 
            // (the disjunction whose iteration has finished) needs to be removed
            remove = false;
            
            if(disjunction.equals(d)) continue;
            
            for (int i=0; i<3;i++){
                
                // if it is a child, check further conditions before embeding a 
                // tree or adding a postfix
                if(amuyaña.isChild(disjunction, i, d)){
                    // root is not ignored here but in the building of the 
                    // panels wopPanel, mutliplyPanel and unitePanel, however
                    // we still need to add a -special- reference to root.
                    if (d.equals(amuyaña.getRoot())){
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    // if it is a multiply disjunction, add its reference at branch i
                    if (amuyaña.getMultiply().contains(d)){
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    
                    // if it is a unite disjunction, add its reference at branch i
                    if (amuyaña.getUnite().contains(d)){
                        
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    if (d.equals(amuyaña.getRoot())) continue;
                    
                    // these things will be done if there is another Tree from i
                    // They imply that the iteration needs to continue 
                    // (unless the for loop has reached the last element)
                    tempList.add(d);
                    tempParentSeq.add(i);
                    treePanel.embed(getTree(tempList,tempParentSeq), i);
                    remove = true;
                } else if(!amuyaña.isChild(disjunction, i, d)){
                    // Do nothing, add nothing, it should end and return 
                    // the tree to the previous iteration.
                }
            }
            
            // After one TreePanel is built, it will return from -> in that case
            // remove it because the next disjunction might not need it.
            // if the disjunction tested was not a child, there should be
            // nothing to remove.
            if (remove){
                tempList.remove(tempList.size()-1);
                tempParentSeq.remove(tempParentSeq.size()-1);
            }
            
        }
        return treePanel;
    }
    
    static TreePanel getTreeForExport(Disjunction disjunctionForExport, boolean signs, boolean full, int color, int size){
        LupascoPanel.SIGNS=signs;
        LupascoPanel.FULL=full;
        LupascoPanel.COLOR=color;
        LupascoPanel.SIZE=size;
        
        ArrayList<Disjunction> tempList = new ArrayList<>();
        
        tempList.add(disjunctionForExport);
        
        ArrayList<Integer> tempParentSeq = new ArrayList<>();

        TreePanel treePanel = new TreePanel(tempList, tempParentSeq);
        
        Disjunction disjunction = tempList.get(tempList.size()-1);

        boolean remove;
         
        // in the first iteration we want the label of the disjunction, just like
        // it will be referenced later by terminal branches
        if (tempList.indexOf(disjunction) == 0){
            treePanel.addPrefix(disjunction);
        }

        for(Disjunction d : amuyaña.getDisjunctions()){
            
            // by default, do not modify the lists at the end of one iteration
            // except if it is returning from an interation in which case
            // the temporary lists need to be adjusted, i.e. the last element 
            // (the disjunction whose iteration has finished) needs to be removed
            remove = false;
            
            if(disjunction.equals(d)) continue;
            
            for (int i=0; i<3;i++){
                
                // if it is a child, check further conditions before embeding a 
                // tree or adding a postfix
                if(amuyaña.isChild(disjunction, i, d)){
                    // root is not ignored here but in the building of the 
                    // panels wopPanel, mutliplyPanel and unitePanel, however
                    // we still need to add a -special- reference to root.
                    if (d.equals(amuyaña.getRoot())){
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    // if it is a multiply disjunction, add its reference at branch i
                    if (amuyaña.getMultiply().contains(d)){
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    
                    // if it is a unite disjunction, add its reference at branch i
                    if (amuyaña.getUnite().contains(d)){
                        
                        treePanel.addPostfix(d, i);
                        continue;
                    }
                    if (d.equals(amuyaña.getRoot())) continue;
                    
                    // these things will be done if there is another Tree from i
                    // They imply that the iteration needs to continue 
                    // (unless the for loop has reached the last element)
                    tempList.add(d);
                    tempParentSeq.add(i);
                    treePanel.embed(getTree(tempList,tempParentSeq), i);
                    remove = true;
                } else if(!amuyaña.isChild(disjunction, i, d)){
                    // Do nothing, add nothing, it should end and return 
                    // the tree to the previous iteration.
                }
            }
            
            
            // After one TreePanel is built, it will return from -> in that case
            // remove it because the next disjunction might not need it.
            // if the disjunction tested was not a child, there should be
            // nothing to remove.
            if (remove){
                tempList.remove(tempList.size()-1);
                tempParentSeq.remove(tempParentSeq.size()-1);
            }
            
        }
        return treePanel;
    }
    
    public static StyleSheet loadStyleSheet(InputStream is) throws IOException{
        StyleSheet s = new StyleSheet();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        s.loadRules(br, null);
        br.close();

        return s;
   }
    
}