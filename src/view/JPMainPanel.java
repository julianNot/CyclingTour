package view;

import view.singIn.SingIn;

import javax.swing.*;
import java.awt.*;

public class JPMainPanel extends JPanel {

    private SingIn singIn;
    private JPMenuTour jpMenuTour;

    public JPMainPanel() {
        //setLayout();
        initComponents();
    }

    private void initComponents() {
        jpMenuTour = new JPMenuTour();
        this.add(BorderLayout.NORTH,jpMenuTour);

        singIn = new SingIn();
        this.add(BorderLayout.CENTER,singIn);

    }
}
