package view;

import view.singIn.SingIn;

import javax.swing.*;
import java.awt.*;

public class JFMainWindow extends JFrame {

    public static final int SIZE_WIDTH = 900;
    public static final int SIZE_HIGH = 700;

    private JPMainPanel jpMainPanel;

    public JFMainWindow(){
        setSize(SIZE_WIDTH,SIZE_HIGH);
        setLocationRelativeTo(null);
        //setIconImage(new ImageIcon(getClass().getResource(/*ruta imagen*/)).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(ConstantsIU.TITTLE);
        setBackground(Color.RED);
        initComponents();
        setVisible(true);
    }

    public void initComponents(){
        jpMainPanel = new JPMainPanel();
        this.add(jpMainPanel);
    }

    public static void main(String[] args) {
        new JFMainWindow();
    }
}
