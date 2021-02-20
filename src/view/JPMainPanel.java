package view;

import presenter.PresenterApp;
import view.singIn.SingIn;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class JPMainPanel extends JPanel {

    private SingIn singIn;
    private JPMenuTour jpMenuTour;

    public JPMainPanel(PresenterApp presenterApp) {
        //setLayout();
        initComponents(presenterApp);
    }

    private void initComponents(PresenterApp presenterApp) {
        jpMenuTour = new JPMenuTour(presenterApp);
        this.add(BorderLayout.NORTH,jpMenuTour);

        singIn = new SingIn();
        this.add(BorderLayout.CENTER,singIn);
    }

    public void showBestTime(LocalTime time){
        singIn.showBestTime(time);
    }

    public void addPanelSignIn(){
        singIn.addPanelSignIn();
    }
}
