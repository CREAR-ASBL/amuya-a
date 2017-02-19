
package tabulator;

import amuyaña.Disjunction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.text.html.StyleSheet;

final class TreePanel extends JPanel{
    private JPanel treePanel;
    private JPanel prePanel;
    private JPanel branchsPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    
    static MatteBorder themedBorder;

    LupascoWritter writter; // An instance of this class is a JLabel
    
    final ArrayList<Disjunction> disjunctions;
    public final ArrayList<Integer> parentSeq;
    
    static int postfixCount1;
    static int postfixCount2;
    static int postfixCount3;

    TreePanel(ArrayList<Disjunction> disjunctions, ArrayList<Integer> parentSeq){
        this.disjunctions=disjunctions;
        this.parentSeq=parentSeq;
        
        this.writter = new LupascoWritter(disjunctions,parentSeq);
        
        initComponents(); // initializes JLabels and JPanels
        embedPanels();
    }
    
    void initComponents(){

        postfixCount1=0;
        postfixCount2=0;
        postfixCount3=0;
        // Tree panel and the main panel
        
        treePanel = new JPanel(new GridBagLayout()){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        
        if (disjunctions.size() == 1){
            MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.black);
            treePanel.setBorder(border);
        }
        
        this.setLayout(new GridBagLayout());
        
        // Subpanels
        prePanel = new JPanel(new GridBagLayout());
        branchsPanel = new JPanel(new GridBagLayout());
        topPanel = new JPanel(new GridBagLayout());
        middlePanel = new JPanel(new GridBagLayout());
        bottomPanel = new JPanel(new GridBagLayout());

        /*
        Setting properties: Backgrounds
        */
        this.setOpaque(false);
        treePanel.setOpaque(false);
        prePanel.setOpaque(false);
        branchsPanel.setOpaque(false);
        topPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        
        /*
        Border of branch panel
        */
        
        themedBorder = new MatteBorder(0, 3, 0, 0, Color.black);
        /*
        0 - Negro y Blanco
        1 - Gris oscuro
        2 - Gris claro
        3 - Violeta
        4 - Azul
        5 - Cian
        6 - Verde
        7 - Amarillo
        8 - Naranja
        9 - Rojo
        */
        switch(LupascoPanel.COLOR){ 
            case (0):{ 
                treePanel.setBackground(new Color(255, 255, 255, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, Color.black);
                break;
            } case (1):{
                treePanel.setBackground(new Color(50, 50, 50, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, Color.black);
                break;
            } case (2):{
                treePanel.setBackground(new Color(100, 100, 100, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, Color.black);
                break;
            } case (3):{
                treePanel.setBackground(new Color(186,85,211, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(75,0,130));
                break;
            } case (4):{
                treePanel.setBackground(new Color(0, 0, 255, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(25,25,112));
                break;
            } case (5):{
                treePanel.setBackground(new Color(0, 255, 255, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(0,128,128));
                break;
            } case (6):{
                treePanel.setBackground(new Color(0, 255, 0, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(0,128,0));
                break;
            } case (7):{
                treePanel.setBackground(new Color(255, 255, 0, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(128,128,0));
                break;
            } case (8):{
                treePanel.setBackground(new Color(255, 165, 0, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(255,69,0));
                break;
            } case (9):{
                treePanel.setBackground(new Color(255, 0, 0, 100));
                themedBorder = new MatteBorder(0, 3, 0, 0, new Color(128,0,0));
                break;
            } 
        }
        
        /*
        Border of branchsPanel
        */

        branchsPanel.setBorder(themedBorder);
        
    }
    
    void embedPanels(){
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(0,0,0,5);
        c.gridx = 0;
        c.gridy = 0;
        
        topPanel.add(writter.getSubconjunctionLabel(0),c);
        
        middlePanel.add(writter.getSubconjunctionLabel(1),c);
        
        bottomPanel.add(writter.getSubconjunctionLabel(2),c);
        
        c.insets = new Insets(0,0,0,0);
        c.gridx = 0;
        c.gridy = 0;
        treePanel.add(prePanel, c);
        
        c.gridx = 1;
        c.gridy = 0;
        treePanel.add(branchsPanel, c);
        
        c.insets = new Insets(6,6,6,6); // For three subpanels of branchsPanels
        c.anchor = GridBagConstraints.WEST;
        
        c.gridx = 0;
        c.gridy = 0;
        branchsPanel.add(topPanel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        branchsPanel.add(middlePanel, c);
        
        c.gridx = 0;
        c.gridy = 2;
        branchsPanel.add(bottomPanel, c);
        
        c.gridx=0;
        c.gridy=0;
        this.add(treePanel);
    }
    
    /*
    Embeding next TreePanels (following ramifications), the disjunctions
    this subconjunction-branch is parent of.
    ! separate this three cases in three methods and call them to add
    a treepanel containing the child 
    */
    void embed(TreePanel treePanel, int position){
    
        GridBagConstraints c = new GridBagConstraints();
        switch (position) {
            case 0:
                c.gridx = 1;
                c.gridy = 0;
                topPanel.add(treePanel, c);
                break;
            case 1:
                c.gridx = 1;
                c.gridy = 0;
                middlePanel.add(treePanel, c);
                break;
            case 2:
                c.gridx = 1;
                c.gridy = 0;
                bottomPanel.add(treePanel, c);
                break;
            default:
                break;
        }
    }
    
        
    /*
        METHODS FROM LupascoPanel.getTree()
    */
    void addPrefix(Disjunction disjunction){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets=new Insets(0,5,0,5);
        prePanel.add(writter.getConjunction(disjunction, true),c);
    }
    
    void addPostfix(Disjunction disjunction, int fromSubconjunction){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,6,0,0);
        
        switch (fromSubconjunction) {
            case 0:
                c.gridx = 1+postfixCount1;
                c.gridy = 0;
                topPanel.add(writter.getConjunction(disjunction,false), c);
                postfixCount1++;
                break;
            case 1:
                c.gridx = 1+postfixCount2;
                c.gridy = 0;
                middlePanel.add(writter.getConjunction(disjunction,false), c);
                postfixCount2++;
                break;
            case 2:
                c.gridx = 1+postfixCount3;
                c.gridy = 0;
                bottomPanel.add(writter.getConjunction(disjunction,false), c);
                postfixCount3++;
                break;
            default:
                break;
        }
    }

    static StyleSheet loadStyleSheet(InputStream is) throws IOException{
        StyleSheet s = new StyleSheet();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        s.loadRules(br, null);
        br.close();

        return s;
    }
}
