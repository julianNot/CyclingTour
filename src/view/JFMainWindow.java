package view;

import presenter.PresenterApp;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class JFMainWindow extends JFrame {

    public static final int SIZE_WIDTH = 900;
    public static final int SIZE_HIGH = 700;

    private JPMainPanel jpMainPanel;

    public JFMainWindow(PresenterApp presenterApp){
        setSize(SIZE_WIDTH,SIZE_HIGH);
        setLocationRelativeTo(null);
        //setIconImage(new ImageIcon(getClass().getResource(/*ruta imagen*/)).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(ConstantsIU.TITTLE);
        setBackground(Color.RED);
        initComponents(presenterApp);
        setVisible(true);
    }

    public void initComponents(PresenterApp presenterApp){
        jpMainPanel = new JPMainPanel(presenterApp);
        this.add(jpMainPanel);
    }

    public void showBestTime(LocalTime time){
        jpMainPanel.showBestTime(time);
    }

    public void addPanelSignIn(){
        jpMainPanel.addPanelSignIn();
    }
}
