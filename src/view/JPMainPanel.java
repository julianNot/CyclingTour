package view;

import presenter.PresenterApp;
import view.foot.Foot;
import view.header.SingIn;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class JPMainPanel extends JPanel {

    private SingIn singIn;
    private Foot foot;
    private JPMenuTour jpMenuTour;

    public JPMainPanel(PresenterApp presenterApp) {
        setLayout(new BorderLayout());
        initComponents(presenterApp);
    }

    private void initComponents(PresenterApp presenterApp) {
        jpMenuTour = new JPMenuTour(presenterApp);
        this.add(BorderLayout.NORTH,jpMenuTour);

        foot = new Foot();
        this.add(BorderLayout.SOUTH,foot);



        singIn = new SingIn();
        //this.add(BorderLayout.CENTER,singIn);
    }

    public void bestTimeRunner(String name, LocalTime time) {
        foot.bestTimeRunner(name,time);
    }

    public void averageMale(LocalTime timeMale, LocalTime timeFemale){
        foot.averageMale(timeMale,timeFemale);
    }

    public void showBestTime(LocalTime time){
        singIn.showBestTime(time);
    }

    public void addPanelSignIn(){
        singIn.addPanelSignIn();
    }
}
