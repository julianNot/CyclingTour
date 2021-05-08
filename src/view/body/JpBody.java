package view.body;

import javax.swing.*;
import java.awt.*;

public class JpBody extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTableBody jTableBody;

    public JpBody() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        jTableBody = new JTableBody();
        this.add(BorderLayout.CENTER,jTableBody);
    }

    public void clearTable(){
        jTableBody.clearTable();
    }

    public void addCyclist(Object [] cyclist){
        jTableBody.addCyclist(cyclist);
    }

    public void changeLanguage(){
        jTableBody.changeLanguage();
    }

}
