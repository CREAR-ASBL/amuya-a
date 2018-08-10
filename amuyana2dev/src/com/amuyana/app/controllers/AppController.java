package com.amuyana.app.controllers;

import com.amuyana.app.Module;
import com.amuyana.app.data.CClass;
import com.amuyana.app.data.CClassHasFcc;
import com.amuyana.app.data.Conexion;
import com.amuyana.app.data.Conjunction;
import com.amuyana.app.data.Element;
import com.amuyana.app.data.Fcc;
import com.amuyana.app.data.FccHasLogicSystem;
import com.amuyana.app.data.General;
import com.amuyana.app.data.Inclusion;
import com.amuyana.app.data.InclusionHasSyllogism;
import com.amuyana.app.data.Syllogism;
import com.amuyana.app.data.Log;
import com.amuyana.app.data.LogicSystem;
import com.amuyana.app.data.User;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppController {
    
    private Conexion conexion;
    
    @FXML private SplitPane stpeContents;
    
    // CONTROLLERS
    @FXML private LogicSystemController logicSystemController;
    @FXML private DualitiesController dualitiesController;
    @FXML private InclusionController inclusionController;
    @FXML private CClassController cClassController;
    @FXML private TodController todController;
    @FXML private DialecticController dialecticController;
    @FXML private StcController stcController;
    @FXML private SyllogismController syllogismController;
    @FXML private StatsController statsController;
    @FXML private SettingsController settingsController;
    
    // MAIN TABS
    @FXML Tab tbLogicSystem;
    @FXML Tab tbDualities;
    @FXML Tab tbInclusions;
    @FXML Tab tbClasses;
    @FXML Tab tbSyllogism;
    @FXML Tab tbTod;
    @FXML Tab tbDialectic;
    @FXML Tab tbStc;
    @FXML Tab tbStats;
    @FXML Tab tbSettings;
    
    // Why is it instantiated this one?
    private final ObservableList<Log> listLog = FXCollections.observableArrayList();
    
    // FOR LOG
    @FXML private MenuItem muimShowHideLog;
    
    private ScrollPane slpeLog;
    private TableView tevwLog;
    
    TableColumn<Log, Timestamp> tecnDate;
    TableColumn<Log, String> tecnType;
    TableColumn<Log, String> tecnMessage;


        
    
    public void initialize() throws IOException {
        initLog();
        
        this.conexion = new Conexion();
        
        loadModules();
        
        settingsController.autoClicks();
        addLog("System", "Welcome to Amuyaña! Waiting for user actions.");
    }
    
    public ObservableList<LogicSystem> getListLogicSystem(){
        return logicSystemController.getListLogicSystem();
    }
    
    public ObservableList<Fcc> getListFcc(){
        return dualitiesController.getListFcc();
    }
    
    public ObservableList<FccHasLogicSystem> getListFccHasLogicSystem(){
        return dualitiesController.getListFccHasLogicSystem();
    }
    
    public ObservableList<Element> getListElements(){
        return dualitiesController.getListElement();
    }
    
    public ObservableList<Conjunction> getListConjunctions(){
        return dualitiesController.getListConjunction();
    }
    
    public ObservableList<CClassHasFcc> getListCClassHasFcc() {
        return cClassController.getListCClassHasFcc();
    }
    
    public ObservableList<Inclusion> getListInclusions(){
        return inclusionController.getListInclusions();
    }
    
    public ObservableList<General> getListGenerals(){
        return inclusionController.getListGenerals();
    }
    
    public ObservableList<User> getListUser(){
        return settingsController.getListUser();
    }
    
    public Conexion getConexion(){
        return this.conexion;
    }
    
    public ObservableList<Log> getListLog() {
        return listLog;
    }
    
    public AppController getAppController(){
        return this;
    }
    
    private void loadModules() throws IOException {
        for(Module m:Module.values()){
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(m.getUrl()));
            
            Node node = loader.load();
            m.setNode(node);
            
            switch(m){
                case LOGIC_SYSTEM:{
                    this.logicSystemController = loader.getController();
                    this.logicSystemController.setAppController(this);
                    this.tbLogicSystem.setContent(m.getNode());
                    break;
                }
                case DUALITIES:{
                    this.dualitiesController = loader.getController();
                    this.dualitiesController.setAppController(this);
                    this.tbDualities.setContent(m.getNode());
                    break;
                }
                case INCLUSIONS:{
                    this.inclusionController = loader.getController();
                    this.inclusionController.setAppController(this);
                    this.tbInclusions.setContent(m.getNode());
                    break;
                }
                case CLASSES:{
                    this.cClassController = loader.getController();
                    this.cClassController.setAppController(this);
                    this.tbClasses.setContent(m.getNode());
                    break;
                }
                case SYLLOGISM:{
                    this.syllogismController = loader.getController();
                    this.syllogismController.setAppController(this);
                    this.tbSyllogism.setContent(m.getNode());
                    break;
                }
                case TOD:{
                    this.todController = loader.getController();
                    this.todController.setAppController(this);
                    this.tbTod.setContent(m.getNode());
                    break;
                }
                case DIALECTIC:{
                    this.dialecticController = loader.getController();
                    this.dialecticController.setAppController(this);
                    this.tbDialectic.setContent(m.getNode());
                    break;
                }
                case STC:{
                    this.stcController = loader.getController();
                    this.stcController.setAppController(this);
                    this.tbStc.setContent(m.getNode());
                    break;
                }
                case STATS:{
                    this.statsController = loader.getController();
                    this.statsController.setAppController(this);
                    this.tbStats.setContent(m.getNode());
                    break;
                }
                case SETTINGS:{
                    this.settingsController = loader.getController();
                    this.settingsController.setAppController(this);
                    this.tbSettings.setContent(m.getNode());
                    break;
                }
            }
        }
    }

    public void loadData() {
        this.conexion.establecerConexion();

//        Dialectic.loadList(conexion.getConnection(), listDialectic);
//        Register.loadList(conexion.getConnection(), listRegister);
//        Space.loadList(conexion.getConnection(), listSpace);
//        Time.loadList(conexion.getConnection(), listTime);
//        Quantum.loadList(conexion.getConnection(), listQuantum);

        
        for(Module m:Module.values()){
            switch(m){
                case LOGIC_SYSTEM:{
                    LogicSystem.loadList(this.conexion.getConnection(), logicSystemController.getListLogicSystem());
                    logicSystemController.fillData();
                    break;
                }
                case DUALITIES:{
                    Fcc.loadList(this.conexion.getConnection(), dualitiesController.getListFcc());
                    
                    FccHasLogicSystem.loadList(this.conexion.getConnection(), 
                            dualitiesController.getListFccHasLogicSystem(), 
                            dualitiesController.getListFcc(), 
                            logicSystemController.getListLogicSystem());
                    
                    Element.loadList(this.conexion.getConnection(), 
                            dualitiesController.getListElement(), 
                            dualitiesController.getListFcc());
                    
                    Conjunction.loadData(this.conexion.getConnection(), 
                            dualitiesController.getListConjunction(),
                            dualitiesController.getListFcc());
                    
                    dualitiesController.fillData();
                    
                    break;
                }
                case INCLUSIONS:{
                    Inclusion.loadList(this.conexion.getConnection(), 
                            inclusionController.getListInclusions(), 
                            dualitiesController.getListConjunction());
                    
                    General.loadList(this.conexion.getConnection(),
                            inclusionController.getListGenerals(),
                            dualitiesController.getListConjunction(),
                            inclusionController.getListInclusions());
                    
                    inclusionController.fillData();
                    break;
                }
                case CLASSES:{
                    CClass.loadList(this.conexion.getConnection(), 
                            cClassController.getListCClass());
                    
                    CClassHasFcc.loadList(this.conexion.getConnection(),
                            cClassController.getListCClassHasFcc(),
                            cClassController.getListCClass(),
                            dualitiesController.getListFcc());
                    
                    cClassController.fillData();
                    break;
                }
                case SYLLOGISM:{
  
                    Syllogism.loadList(this.conexion.getConnection(), 
                            syllogismController.getListSyllogisms());
                    
                    InclusionHasSyllogism.loadList(this.conexion.getConnection(),
                            syllogismController.getListIHS(),
                            inclusionController.getListInclusions(),
                            syllogismController.getListSyllogisms() );
                    
                    syllogismController.fillData();
                    break;
                }
                case TOD:{
                    todController.fillData();
                    break;
                }
//                case DIALECTIC:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case STC:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case SYLLOGISM:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
//                case STATS:{
//                    this.listLogicSystem = FXCollections.observableArrayList();
//                    logicSystemController.fillData(conexion, this.listLogicSystem);
//                    break;
//                }
                case SETTINGS:{
                    User.loadList(this.conexion.getConnection(), settingsController.getListUser());
                    break;
                }
            }
        }    
        
        conexion.cerrarConexion();
    }
    
    @FXML public void showHideLog(){
        System.out.println("muimShowHideLog.toString(): " + muimShowHideLog.toString());
        System.out.println("muimShowHideLog.getText(): " + muimShowHideLog.getText());
        if("Show Log panel".equals(muimShowHideLog.getText())) {
            stpeContents.getItems().add(slpeLog);
            muimShowHideLog.setText("Hide Log panel");
            
        } else if ("Hide Log panel".equals(muimShowHideLog.getText())){
            stpeContents.getItems().remove(stpeContents.getItems().size()-1);
            muimShowHideLog.setText("Show Log panel");
        }
    }
    
    public void clearLists(){
        logicSystemController.getListLogicSystem().clear();
        
    }
    
    public void initLog(){
        
        tevwLog = new TableView(listLog);
        
        slpeLog = new ScrollPane(tevwLog);
        slpeLog.setFitToWidth(true);
        slpeLog.setFitToHeight(true);
        
        tecnDate = new TableColumn<>("Date");
        tecnType = new TableColumn<>("Type");
        tecnMessage = new TableColumn<>("Message");
        
        tecnDate.setCellValueFactory(new PropertyValueFactory<Log,Timestamp>("date"));
        tecnType.setCellValueFactory(new PropertyValueFactory<Log,String>("type"));
        tecnMessage.setCellValueFactory(new PropertyValueFactory<Log,String>("message"));
        
        tevwLog.getColumns().addAll(tecnDate,tecnType,tecnMessage);
        
        //listLog = FXCollections.observableArrayList();
        tevwLog.setItems(listLog);
        
//        tevwLog.getSelectionModel().selectedItemProperty().addListener(
//				new ChangeListener<Log>() {
//					@Override
//					public void changed(ObservableValue<? extends Log> arg0,
//							Log valorAnterior, Log valorSeleccionado) {
//                                            // TODO
//                                            System.out.println("selection was " + valorAnterior + " y ahora es: " + valorSeleccionado);
//                                    }
//                                }
//		);
        
        
    }
    
    public void addLog(String type, String message){
        listLog.add(new Log(Timestamp.valueOf(LocalDateTime.now()), type, message));
    }
    
    public Element elementOf(int polarity, Fcc fcc){
        for(Element e:getListElements()){
            if(e.getFcc().equals(fcc)){
                if(e.getPolarity()==polarity){
                    return e;
                }
            }
        }
        return null;
    }
    
    public Conjunction conjunctionOf(int orientation, Fcc fcc){
        for(Conjunction c:getListConjunctions()){
            if(c.getFcc().equals(fcc)){
                if(c.getOrientation()==orientation){
                    return c;
                }
            }
        }
        return null;
    }
    
    //Called from LogicSystemController
    public ArrayList<Fcc> fccOf(LogicSystem ls){
        ArrayList<Fcc> list = new ArrayList<>();
        
        for(FccHasLogicSystem fhls:getListFccHasLogicSystem()){
            if(fhls.getLogicSystem().equals(ls)){
                list.add(fhls.getFcc());
            }
        }
        return list;
    }
    
    public ArrayList<Fcc> fccOf(CClass cClass){
        ArrayList<Fcc> list = new ArrayList<>();
        
        for(CClassHasFcc chf:getListCClassHasFcc()){
            if(cClass.equals(chf.getCClass())){
                list.add(chf.getFcc());
            }
        }
        return list;
    }

    public ArrayList<Conjunction> generalsOf(Fcc fcc) {
        ArrayList<Conjunction> listGeneralsOf = new ArrayList<>();
        for(Inclusion i:getListInclusions()){
            if(i.getConjunction().equals(conjunctionOf(0, fcc))||
                    i.getConjunction().equals(conjunctionOf(1, fcc))||
                    i.getConjunction().equals(conjunctionOf(2, fcc))){
                for(General g:getListGenerals()){
                    if(g.getInclusion().equals(i)){
                        listGeneralsOf.add(g.getConjunction());
                    }
                }
            }
        }
        return listGeneralsOf;
    }
    
    public ArrayList<CClass> cClassOf(Fcc fcc){
        ArrayList<CClass> listCClassOf = new ArrayList<>();
        
        for(CClassHasFcc cchf:cClassController.getListCClassHasFcc()){
            if(cchf.getFcc()==fcc){
                listCClassOf.add(cchf.getCClass());
            }
        }
        
        return listCClassOf;
    }
}
