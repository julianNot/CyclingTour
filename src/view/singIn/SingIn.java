package view.singIn;

import javax.swing.*;

public class SingIn extends JPanel {

    public SingIn() {
        setLayout( new BoxLayout(this,BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        JButton singIn = new JButton("Registrar");

        JLabel name = new JLabel("Primer Nombre");
        JTextField nameText = new JTextField(10);
        JLabel lastName = new JLabel("Primer Apellido");
        JTextField lastNameText = new JTextField(10);
        JLabel lastName2 = new JLabel("Segundo Apellido");
        JTextField lastNameText2 = new JTextField(10);

        this.add(name);
        this.add(nameText);
        this.add(lastName);
        this.add(lastNameText);
        this.add(lastName2);
        this.add(lastNameText2);

        this.add(singIn);
    }
}
