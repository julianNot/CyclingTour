package view.singIn;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class SingIn extends JPanel {

    private JLabel bestTime;

    public SingIn() {
        setLayout( new BoxLayout(this,BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        addPanelSignIn();
        JLabel test = new JLabel("Prueba");
        //this.add(test);
        bestTime = new JLabel("Mejor Tiempo");
        this.add(bestTime);
    }

    public void showBestTime(LocalTime time){
        bestTime.setText(time+"");
        this.add(bestTime);
    }

    public void addPanelSignIn(){
        JPanel jPanel = new JPanel(new GridLayout(3,2));

        JButton singIn = new JButton("Registrar");

        JLabel name = new JLabel("Primer Nombre");
        JTextField nameText = new JTextField(10);
        JLabel lastName = new JLabel("Primer Apellido");
        JTextField lastNameText = new JTextField(10);
        JLabel lastName2 = new JLabel("Segundo Apellido");
        JTextField lastNameText2 = new JTextField(10);

        jPanel.add(name);
        jPanel.add(nameText);
        jPanel.add(lastName);
        jPanel.add(lastNameText);
        jPanel.add(lastName2);
        jPanel.add(lastNameText2);

        //this.add(jPanel);
        //this.add(singIn);
    }
}
