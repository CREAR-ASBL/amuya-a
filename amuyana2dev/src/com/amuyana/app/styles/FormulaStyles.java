
package com.amuyana.app.styles;

public enum FormulaStyles {
    SIMPLE("Simple","/com/amuyana/app/styles/formulaSimple.css"),
    NO_LABELS("No labels","/com/amuyana/app/styles/formulaNoLabels.css"),
    DEFAULT("Default","/com/amuyana/app/styles/formulaDefault.css"),
    DEFAULT_REDUCED("Default reduced","/com/amuyana/app/styles/formulaDefaultReduced.css"),
    PHRASES("Phrases","/com/amuyana/app/styles/formulaPhrases.css");

    private final String label;
    private final String url;
    
    private FormulaStyles(String label,String url) {
        this.label=label;
        this.url=url;
    }
    
    public String getCssUrl(){
        return this.url;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    @Override
    public String toString(){
        return this.label;
    }
    
}
