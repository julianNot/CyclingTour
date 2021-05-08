package controller;

import models.*;
import persistence.HandlerLanguage;
import utils.ManagerFiles;
import utils.Utilities;
import view.ConstantsIU;
import view.JFMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PresenterApp implements ActionListener {

    public static final String CHECK_GENDER_FILE = "Masculino";


    private static final String FILE = "resources/config/config.init";
    private static final String SPANISH_ROUTE = "resources/languages/languageES.properties";
    private static final String ENGLISH_ROUTE = "resources/languages/languageUS.properties";

    private static final String FILE_ROUTE = "resources/archives/Corredores.bike";


    private JFMainWindow jfMainWindow;
    private DatasRunners datasRunners;
    private ManagerFiles managerFiles;
    private HandlerLanguage config;

    public PresenterApp() {
        loadConfiguration();
        this.datasRunners = new DatasRunners();
        this.jfMainWindow = new JFMainWindow(this);
        managerFiles = new ManagerFiles();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())){
            case C_SHOW_BEST_TIME_TABLE:
                this.showTableRunners();
                break;
            case C_SHOW_AVERAGES:
                this.averageMale(datasRunners.averageMale(Gender.M), datasRunners.averageMale(Gender.F));
                break;
            case C_SHOW_BEST_TIME_RUNNER:
                Cyclist cyclist = datasRunners.bestRunner().getCyclist();
                this.bestTimeRunner(cyclist.getName(),cyclist.getTotalTime());
                break;
            case C_SHOW_ADD_CYCLIST:
                this.addJDialog();
                break;
            case C_CLOSE_DIALOG:
                this.closeDialog();
                break;
            case C_SIGN_IN_BUTTON:
                Dorsal dorsal = new Dorsal(registerCyclist());
                datasRunners.getManager().addOnlyDorsal(dorsal);
                this.addCyclist(dorsal.toObjectVector());
                datasRunners.orderByLessTime();
                this.closeDialog();
                this.clearTable();
                break;
            case C_REFRESH_TABLE:
                this.clearTable();
                this.showTableRunners();
                break;
            case C_CLEAR_TABLE:
                this.clearTable();
                this.resetTimeRunner();
                this.resetAverageMale();
                break;
                //Cambio de lenguaje
            case C_CHANGE_ENGLISH:
                manageChangeLanguageUS();
                break;
            case C_CHANGE_SPANISH:
                manageChangeLanguageES();
                break;
            case C_RAID_FILE:
                try {
                    initFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                clearTable();
                showTableRunners();
                break;
            default:
                break;
        }
    }

    public void addJDialog(){
        jfMainWindow.addJDialog();
    }

    public void closeDialog(){
        jfMainWindow.closeDialog();
    }

    public void showTableRunners(){
        for (int i = 0; i < datasRunners.getManager().sizeRunnersList(); i++) {
            addCyclist(datasRunners.getManager().getCyclist(i).toObjectVector());
        }
    }

    public String fileChoosertest(){
        return jfMainWindow.fileChoosertest();

    }

    public void clearTable(){
        jfMainWindow.clearTable();
    }

    public void bestTimeRunner(String name, LocalTime time){
        jfMainWindow.bestTimeRunner(name,time);
    }

    public void averageMale(LocalTime timeMale, LocalTime timeFemale){
        jfMainWindow.averageMale(timeMale, timeFemale);
    }

    public void addCyclist(Object [] cyclist){
        jfMainWindow.addCyclist(cyclist);
    }

    public Cyclist registerCyclist(){
        return jfMainWindow.registerCyclist();
    }

    /**
     * Metodo encargados de borrar los datos en footer
     */
    public void resetTimeRunner(){
        jfMainWindow.resertTimeRunner();
    }
    public void resetAverageMale(){
        jfMainWindow.resetAverageMale();
    }

    /**
     * Multi lenguaje
     */

    public void loadConfiguration(){
        if(config == null){
            config = new HandlerLanguage(FILE);
        }
        try{
            config.loadLanguage();
        }catch(IOException e){
//			JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private void manageChangeLanguageUS(){
        try {
            changeToEnglish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
        }
        manageChangeLanguage();
    }

    private void manageChangeLanguageES(){
        try {
            changeToSpanish();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(jfMainWindow, e1.getMessage());
        }
        manageChangeLanguage();
    }

    private void manageChangeLanguage(){
        jfMainWindow.changeLanguage();
    }
    
    public void loadLanguage(){
        try {
            config.loadLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
        }
    }

    public void saveConfig(){
        try {
            new HandlerLanguage(FILE).saveLanguage();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jfMainWindow, e.getMessage());
        }
    }

    public void changeToEnglish() throws IOException{
        HandlerLanguage.language = ENGLISH_ROUTE;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException{
        HandlerLanguage.language = SPANISH_ROUTE;
        saveConfig();
        loadLanguage();
    }

    /**
     * Lectura de archivos
     */
    public void splitLines(ArrayList<String> lines){
        for (String line : lines) {
            String [] temp = Utilities.splitLine(line);
            LocalDate localDate = getDataOfString(temp[4]);
            datasRunners.filtersByAgeAndLetters(new Dorsal(new Cyclist(temp[1],temp[2],temp[3],localDate,(temp[5].equals(CHECK_GENDER_FILE)? Gender.M:Gender.F),temp[6],LocalTime.parse(temp[7]))));

        }
    }

    public LocalDate getDataOfString(String data){
        String temp [] = data.split("/");
        return LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
    }

    public void initFile() throws IOException{
        clearTable();
        ArrayList<String> strings = managerFiles.readFile(fileChoosertest());
        splitLines(strings);
    }

    
    public static void main(String[] args) {
        new PresenterApp();
    }
}
