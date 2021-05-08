package view.header;

import controller.Commands;
import controller.PresenterApp;
import persistence.HandlerLanguage;
import view.utils.MyUtils;
import view.ConstantsIU;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class JPMenuTour extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton bestTime;
    private JButton averageMale;
    private JButton runnerBestTime;
    private JButton addRunner;
    private JButton refresh;
    private JButton clear;
    private JButton file;

    public JPMenuTour(PresenterApp presenterApp) {
        /**
         * cambios prueba
         */
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        initComponents(presenterApp);
    }

    private void initComponents(PresenterApp presenterApp) {
        addPanelCenter(presenterApp);
        addButtonsLanguages(presenterApp);
    }

    public void addPanelCenter(PresenterApp presenterApp){
        JPanel menuOptions = new JPanel();
        menuOptions.setLayout(new BoxLayout(menuOptions,BoxLayout.X_AXIS));
        menuOptions.setBackground(Color.BLACK);
        /**
         * Muestra el mejor tiempo
         */
        bestTime = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_BEST_TIME));
        bestTime.setActionCommand(Commands.C_SHOW_BEST_TIME_TABLE.toString());
        MyUtils.setButtonForImages(bestTime,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_TABLE)));
        bestTime.addActionListener(presenterApp);

        averageMale = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_AVERAGES));
        averageMale.setActionCommand(Commands.C_SHOW_AVERAGES.toString());
        MyUtils.setButtonForImages(averageMale,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_AVERAGE)));
        averageMale.addActionListener(presenterApp);

        runnerBestTime = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_BEST_RUNNER));
        runnerBestTime.setActionCommand(Commands.C_SHOW_BEST_TIME_RUNNER.toString());
        MyUtils.setButtonForImages(runnerBestTime,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_RUNNER)));
        runnerBestTime.addActionListener(presenterApp);

        addRunner = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_ADD_RUNNER));
        addRunner.setActionCommand(Commands.C_SHOW_ADD_CYCLIST.toString());
        MyUtils.setButtonForImages(addRunner,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_ADD)));
        addRunner.addActionListener(presenterApp);

        refresh = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_REFRESH_TABLE));
        refresh.setActionCommand(Commands.C_REFRESH_TABLE.toString());
        MyUtils.setButtonForImages(refresh,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_REFRESH)));
        refresh.addActionListener(presenterApp);

        clear = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_CLEAR_TABLE));
        clear.setActionCommand(Commands.C_CLEAR_TABLE.toString());
        MyUtils.setButtonForImages(clear,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_CLEAR)));
        clear.addActionListener(presenterApp);

        file = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsIU.READ_DOC));
        file.setActionCommand(Commands.C_RAID_FILE.toString());
        file.addActionListener(presenterApp);

        menuOptions.add(bestTime);
        menuOptions.add(averageMale);
        menuOptions.add(runnerBestTime);
        menuOptions.add(addRunner);
        menuOptions.add(refresh);
        menuOptions.add(clear);
        menuOptions.add(file);

        this.add(menuOptions);
    }

    public void addButtonsLanguages(PresenterApp presenterApp){
        JPanel temp = new JPanel();
        BoxLayout boxLayout = new BoxLayout(temp,BoxLayout.Y_AXIS);
        temp.setLayout(boxLayout);
        temp.setBackground(Color.BLACK);
        temp.setBorder(new EmptyBorder(5,5,0,50));

        JButton spanish = new JButton();
        spanish.setToolTipText(ConstantsIU.TEXT_SPANISH);
        MyUtils.setButtonForImages(spanish,new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_MENU_SPANISH)));
        spanish.setActionCommand(Commands.C_CHANGE_SPANISH.toString());
        spanish.addActionListener(presenterApp);

        JButton english = new JButton();
        english.setToolTipText(ConstantsIU.TEXT_ENGLISH);
        MyUtils.setButtonForImages(english, new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.iCON_MENU_ENGLISH)));
        english.setActionCommand(Commands.C_CHANGE_ENGLISH.toString());
        english.addActionListener(presenterApp);

        temp.add(spanish);
        temp.add(english);

        this.add(temp,BorderLayout.WEST);
    }

    public void changeLanguage(){
        bestTime.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_BEST_TIME));
        averageMale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_AVERAGES));
        runnerBestTime.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_BEST_RUNNER));
        addRunner.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_ADD_RUNNER));
        refresh.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_REFRESH_TABLE));
        clear.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.MENU_CLEAR_TABLE));
        file.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.READ_DOC));
    }

    public String fileChoosertest(){
        JFileChooser fc=new JFileChooser();
        int seleccion=fc.showOpenDialog(this);
        String aux;
        aux = " ";

        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
            aux = fichero.getAbsolutePath();
        }
        return aux;
    }

    public String saveChooser(){
        JFileChooser fcs=new JFileChooser();
        String aux = "";

        int seleccion=fcs.showSaveDialog(this);

        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fcs.getSelectedFile();
            aux = fichero.getAbsolutePath();
        }
        return aux;
    }
}
