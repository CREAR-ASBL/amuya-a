/*
 * Recibe como argumento propiedades especificadas en la gui: size, color, words, full
 * y envia un string con el código latex de la Tabla.
 * Se basa en gran parte en el código de LupascoPanel
 */
package tabulator;

import amuyaña.Disjunction;
import java.util.ArrayList;

/**
 *
 * @author ayar
 */
public abstract class LupascoTex {

    static final amuyaña.Operations AMUYAÑA = ñ.Ñ.amuyaña;

    static boolean SIGNS;
    static boolean FULL;
    static int COLOR;
    static int SIZE;
    
    static String fontSize;
    static String baseColor;
    
    private String lupascoTex;
    
    private static final String HEADER = 
"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% README %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
"% Plain latex code generated automatically by Amuyaña, application that\n" +
"% designs Tables of deductions (developped by Ayar Portugal).\n" +
"% Important notice: Add the following packages to your preambule.\n" +
"%" +
"% \\usepackage{amsmath} % For the array environment\n" + 
"% \\usepackage{mathtools} % For \n" +
"% \\usepackage{graphicx} % For the /scalebox \n" +
"%" +
"% Also have in mind that the Table won't fit in a standard paper, \n" +
"% and it might not compile if the final output is very large, so you\n" + 
"% may need to rescale the output. To do that you can change the \n " +
"% parameter 1 in \\scalebox{1}{...}' below to anything between 0 and 1.\n" +
"% You can change some individual setting inside the code below (at your\n"+
"% own risk) like colors and text sizes for specific disjunctions.\n" +
"% Accents in names and abbreviations have been transformed to tex format.\n" +
"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n" +
"\\newcommand{\\PIMP}{\\supset} % PIMP = positive implication.\n" +
"\\newcommand{\\NIMP}{\\mkern1.5mu\\overline{\\mkern-1.5mu\\supset\\mkern-1.5mu}\\mkern 1.5mu}"
+ " % NIMP = negative implication.\n"+
"\\newcommand{\\AC}{\\mathsf{A}}\n"+
"\\newcommand{\\PO}{\\mathsf{P}}\n"+
"\\newcommand{\\TE}{\\mathsf{T}}\n" +
"\\def\\arraystretch{1.5}\n\n";
            
    
    static String getTreeForExport(Disjunction d, boolean signs, boolean full, int color, int size) {
        LupascoTex.SIGNS=signs;
        LupascoTex.FULL=full;
        LupascoTex.COLOR=color;
        LupascoTex.SIZE=size;
        
        ArrayList<Disjunction> firstList = new ArrayList<>();
        ArrayList<Integer> emptyList = new ArrayList<>();
        firstList.add(d);
        
        init();
        return HEADER + "\\scalebox{1} % Adjust this to scale the entire Table\n"
                + "{" + buildTex(firstList,emptyList) + "}";
    }

    private static String buildTex(ArrayList<Disjunction> disjunctions, ArrayList<Integer> parents) {
        
        ArrayList<Disjunction> tempList = disjunctions;
        ArrayList<Integer> tempParents = parents;
        
        Disjunction disjunction = tempList.get(tempList.size()-1);
        
        LupascoTexWritter writter = new LupascoTexWritter(tempList, tempParents);
        
        // If it is the very first one, add its abreviation in the form of (e.e)
        if (tempList.indexOf(disjunction) == 0){
            writter.addLabel(disjunction);
        }
        
        boolean remove;
        
        for(Disjunction d : AMUYAÑA.getDisjunctions()){
            
            // by default, do not modify the lists at the end of one iteration 
            // (that's what means remove = false),
            // exception occurs when it returns from an interation in which case
            // the temporary lists need to be adjusted, i.e. the last element 
            // (the disjunction whose iteration has finished) needs to be removed
            remove = false;
            
            // without this there's an error (stackoverflow)
            if(disjunction.equals(d)) continue;
            
            for (int i=0; i<3;i++){
                
                // if it is a child, check further conditions before embeding a 
                // tree or adding a postfix
                if(AMUYAÑA.isChild(disjunction, i, d)){
                    // root is not ignored here but in the building of the 
                    // panels wopPanel, mutliplyPanel and unitePanel, however
                    // we still need to add a -special- reference to root.
                    if (d.equals(AMUYAÑA.getRoot())){
                        writter.addPostfix(d, i);
                        
                        continue;
                    }
                    // if it is a multiply disjunction, add its reference at branch i
                    if (AMUYAÑA.getMultiply().contains(d)){
                        writter.addPostfix(d, i);

                        continue;
                    }
                    
                    // if it is a unite disjunction, add its reference at branch i
                    if (AMUYAÑA.getUnite().contains(d)){
                        writter.addPostfix(d, i);

                        continue;
                    }
                    
                    // do not embed root
                    if (d.equals(AMUYAÑA.getRoot())) continue;
                    
                    // The following code will be done if there is another Tree 
                    // (Disjunction d) that emerges from branch 'int i' of
                    // 'Disjunction disjunction'. This is the case if any of the
                    // previous if conditions has been met.
                    // It imply that the iteration needs to continue for d.
                    
                    tempList.add(d);
                    tempParents.add(i);
                    writter.embed(buildTex(tempList,tempParents), i);
                    remove = true;
                } else if(!AMUYAÑA.isChild(disjunction, i, d)){
                    // Do nothing, add nothing, it should end and return 
                    // the tree to the previous iteration. (obvious continue;)
                }
            }
            
            // After one TreePanel is built, it will return from -> in that case
            // remove it because the next disjunction might not need it.
            // if the disjunction tested was not a child, there should be
            // nothing to remove.
            if (remove){
                tempList.remove(tempList.size()-1);
                tempParents.remove(tempParents.size()-1);
            }
            
        }
        return changeAccents(writter.getTexString());
    }
    
        private static String changeAccents(String texString) {
        texString = texString.replace("á", "\\'a");
        texString = texString.replace("é", "\\'e");
        texString = texString.replace("í", "\\'i");
        texString = texString.replace("ó", "\\'o");
        texString = texString.replace("ú", "\\'u");
        texString = texString.replace("à", "\\`a");
        texString = texString.replace("è", "\\`e");
        texString = texString.replace("ì", "\\`i");
        texString = texString.replace("ò", "\\`o");
        texString = texString.replace("ù", "\\`u");
        texString = texString.replace("ä", "\\\"a");
        texString = texString.replace("ë", "\\\"e");
        texString = texString.replace("ï", "\\\"i");
        texString = texString.replace("ö", "\\\"o");
        texString = texString.replace("ü", "\\\"u");
        texString = texString.replace("Ä", "\\\"A");
        texString = texString.replace("Ë", "\\\"E");
        texString = texString.replace("Ï", "\\\"I");
        texString = texString.replace("Ö", "\\\"O");
        texString = texString.replace("Ü", "\\\"U");
        texString = texString.replace("Á", "\\'A");
        texString = texString.replace("É", "\\'E");
        texString = texString.replace("Í", "\\'I");
        texString = texString.replace("Ó", "\\'O");
        texString = texString.replace("Ú", "\\'U");
        texString = texString.replace("À", "\\`A");
        texString = texString.replace("È", "\\`E");
        texString = texString.replace("Ì", "\\`I");
        texString = texString.replace("Ò", "\\`O");
        texString = texString.replace("Ù", "\\`U");
        texString = texString.replace("ñ", "\\~n");
        texString = texString.replace("Ñ", "\\~N");
        texString = texString.replace("ç", "\\c c");
        texString = texString.replace("Ç", "\\c C");
        texString = texString.replace("œ", "\\oe{}");
        return texString;
    }
    
    private static void init() {
        
        switch(LupascoTex.SIZE){
            case (0):{
                fontSize="\\tiny ";
                break;
            }
            case (1):{
                fontSize="\\footnotesize ";
                break;
            }
            case (2):{
                fontSize="\\small ";
                break;
            }
        }
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
        switch(LupascoTex.COLOR){
            case 0:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0,0,0.00}";
                break;
            }
            case 1:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0,0,0.60}";
                break;
            }
            case 2:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0,0,0.40}";
                break;
            }
            case 3:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0.12,0.6,0,0.17}";
                break;
            }
            case 4:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0.9,0.9,0,0.00}";
                break;
            }
            case 5:{baseColor = "\\definecolor{backgroundColor}{cmyk}{1,0,0,0.00}";
                break;
            }
            case 6:{baseColor = "\\definecolor{backgroundColor}{cmyk}{1,0,1,0.00}";
                break;
            }
            case 7:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0,1,0.00}";
                break;
            }
            case 8:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0.35,1,0.00}";
                break;
            }
            case 9:{baseColor = "\\definecolor{backgroundColor}{cmyk}{0,0.9,0.9,0.00}";
                break;
            }
        }
    }
}
