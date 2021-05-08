package view;

import models.Cyclist;
import controller.PresenterApp;
import persistence.HandlerLanguage;

import javax.swing.*;
import java.time.LocalTime;

public class JFMainWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPMainPanel jpMainPanel;

    public static final int WIDTH = 1050;
    public static final int HIGH  = 700;

    public JFMainWindow(PresenterApp presenterApp){
        setSize(WIDTH,HIGH);
        setLocationRelativeTo(null);
        setTitle(ConstantsIU.TITLE_APP);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage(new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_PRINCIPAL)).getImage());
        initComponents(presenterApp);
        setVisible(true);

    }

    public void addJDialog(){
        jpMainPanel.addJDialog();
    }

    public void closeDialog(){
        jpMainPanel.closeDialog();
    }

    public void clearTable(){
        jpMainPanel.clearTable();
    }

    public void bestTimeRunner(String name, LocalTime time){
        jpMainPanel.bestTimeRunner(name,time);
    }

    public void averageMale(LocalTime timeMale, LocalTime timeFemale){
        jpMainPanel.averageMale(timeMale, timeFemale);
    }

    public void initComponents(PresenterApp presenterApp){
        jpMainPanel = new JPMainPanel(presenterApp);
        this.add(jpMainPanel);
    }

    public String fileChoosertest(){
        return jpMainPanel.fileChoosertest();
    }

    public void addCyclist(Object [] cyclist){
        jpMainPanel.addCyclist(cyclist);
    }

    public Cyclist registerCyclist(){
        return jpMainPanel.registerCyclist();
    }

    /**
     * Metodo que reinician footer
     */
    public void resertTimeRunner(){
        jpMainPanel.resertTimeRunner();
    }
    public void resetAverageMale(){
        jpMainPanel.resetAverageMale();
    }

    /**
     * Muliti lenguaje
     */
    public void changeLanguage(){
        this.setTitle( HandlerLanguage.languageProperties.getProperty(ConstantsIU.TITLE_APP ));
        jpMainPanel.changeLanguage();
    }
}
