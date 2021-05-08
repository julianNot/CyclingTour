package view.foot;

import persistence.HandlerLanguage;
import view.ConstantsIU;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class JPFoot extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    private JLabel jlAverageMale;
    private JLabel timeMale;
    private JLabel jlAverageFemale;
    private JLabel timeFemale;


    private JLabel bestRunnerTime;
    private JLabel nameRunner;
    private JLabel nameBestRunner;

    public JPFoot() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setBackground(new Color(253,205,0));
        initComponents();
    }

    /**
     * Metodo que inicializa el panel del pie con todos sus subpanels
     */
    private void initComponents() {
        addElementsFirstPanel();

        JPanel tempBorderMale = addPanel(jlAverageMale, timeMale);
        tempBorderMale.setBackground(new Color(253,205,0));
        tempBorderMale.setBorder(BorderFactory.createEmptyBorder(5,50,5,10));
        this.add(tempBorderMale);
        JPanel temBorderFemale = addPanel(jlAverageFemale, timeFemale);
        temBorderFemale.setBorder(BorderFactory.createEmptyBorder(5,50,5,10));
        this.add(temBorderFemale);

        addElementsSecondPanel();
        JPanel jPBestRunner = addPanel(nameRunner, nameBestRunner);
        jPBestRunner.setBackground(new Color(253,205,0));
        jPBestRunner.add(bestRunnerTime);
        jPBestRunner.setBorder(BorderFactory.createEmptyBorder(5,170,5,10));
        this.add(jPBestRunner);
    }

    /**
     * Metodo que muestra el mejor tiempo de las corredoras
     * @param time mejor tiempo mujeres
     */
    public void bestTimeRunner(String name,LocalTime time){
        nameBestRunner.setText(name);
        bestRunnerTime.setText(time+"");
    }

    public void resetTimeRunner(){
        nameBestRunner.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_NAME));
        bestRunnerTime.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
    }

    /**
     * Metodo que agregar los elementos con valores por defecto y con bordes
     */
    public void addElementsSecondPanel(){
        nameRunner = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_BEST_TIME));
        nameRunner.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        bestRunnerTime = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        bestRunnerTime.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        nameBestRunner = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_NAME));
        nameBestRunner.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
    }

    /**
     * Metodo que muestra el promedio de tiempo de Hombres y Mujeres
     * @param averageMale tiempo promedio hombres
     * @param averageFemale tiempo promedio mujeres
     */
    public void averageMale(LocalTime averageMale, LocalTime averageFemale){
        timeMale.setText(averageMale+"");
        timeFemale.setText(averageFemale+"");
    }

    public void resetAverageMale(){
        timeMale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        timeFemale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
    }

    /**
     * Metodo encargado de agregar en un panel cada Jlabel de los tiempos
     * @param name Jlabel con etiqueta
     * @param time Jlaber con tiempo promedi
     * @return panel a agregar
     */
    public JPanel addPanel(JLabel name, JLabel time){
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp,BoxLayout.Y_AXIS));
        temp.setBackground(new Color(253,205,0));

        temp.add(name);
        temp.add(time);
        return temp;
    }

    /**
     * Metodo que agregar los elementos con valores por defecto y con bordes
     */
    public void addElementsFirstPanel(){
        jlAverageMale = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_AVERAGE_FEMALE));
        jlAverageMale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
        timeMale = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        timeMale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));

        jlAverageFemale = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_AVERAGE_MALE));
        jlAverageFemale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
        timeFemale = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        timeFemale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
    }

    public void changeLanguage(){
        jlAverageMale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_AVERAGE_FEMALE));
        timeMale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        jlAverageFemale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_AVERAGE_MALE));
        timeFemale.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        bestRunnerTime.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_TIME));
        nameRunner.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_BEST_TIME));
        nameBestRunner.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_RUNNER_NAME));
    }
}
