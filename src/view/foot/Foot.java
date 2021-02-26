package view.foot;

import javax.swing.*;
import java.time.LocalTime;

public class Foot extends JPanel {

    private JLabel jlAverageMale;
    private JLabel timeMale;
    private JLabel jlAverageFemale;
    private JLabel timeFemale;


    private JLabel bestRunnerTime;
    private JLabel nameRunner;
    private JLabel nameBestRunner;

    public Foot() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        initComponents();
    }

    /**
     * Metodo que inicializa el panel del pie con todos sus subpanels
     */
    private void initComponents() {
        addElementsFirstPanel();

        JPanel tempBorderMale = addPanel(jlAverageMale, timeMale);
        tempBorderMale.setBorder(BorderFactory.createEmptyBorder(5,50,5,10));
        this.add(tempBorderMale);
        JPanel temBorderFemale = addPanel(jlAverageFemale, timeFemale);
        temBorderFemale.setBorder(BorderFactory.createEmptyBorder(5,50,5,10));
        this.add(temBorderFemale);

        addElementsSecondPanel();
        JPanel jPBestRunner = addPanel(nameRunner, nameBestRunner);
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

    /**
     * Metodo que agregar los elementos con valores por defecto y con bordes
     */
    public void addElementsSecondPanel(){
        nameRunner = new JLabel("Corredora con mejor tiempo: ");
        nameRunner.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        bestRunnerTime = new JLabel("Time");
        bestRunnerTime.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        nameBestRunner = new JLabel("Name");
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

    /**
     * Metodo encargado de agregar en un panel cada Jlabel de los tiempos
     * @param name Jlabel con etiqueta
     * @param time Jlaber con tiempo promedi
     * @return panel a agregar
     */
    public JPanel addPanel(JLabel name, JLabel time){
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp,BoxLayout.Y_AXIS));

        temp.add(name);
        temp.add(time);
        return temp;
    }

    /**
     * Metodo que agregar los elementos con valores por defecto y con bordes
     */
    public void addElementsFirstPanel(){
        jlAverageMale = new JLabel("Promedio Masculino:");
        jlAverageMale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
        timeMale = new JLabel("Time");
        timeMale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));

        jlAverageFemale = new JLabel("Promedio Femenino:");
        jlAverageFemale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
        timeFemale = new JLabel("Time");
        timeFemale.setBorder( BorderFactory.createEmptyBorder(10,10,20,10));
    }
}
