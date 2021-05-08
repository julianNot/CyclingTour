package view;

import models.Cyclist;
import controller.PresenterApp;
import view.body.JpBody;
import view.foot.JPFoot;
import view.header.JPMenuTour;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class JPMainPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPFoot foot;
    private JPMenuTour jpMenuTour;
    private JpBody jpBody;
    private JdSingIn jdSingIn;

    public JPMainPanel(PresenterApp presenterApp) {
        setLayout(new BorderLayout());
        initComponents(presenterApp);
    }

    private void initComponents(PresenterApp presenterApp) {
        jpMenuTour = new JPMenuTour(presenterApp);
        this.add(BorderLayout.NORTH,jpMenuTour);

        jpBody = new JpBody();
        this.add(jpBody);

        foot = new JPFoot();
        this.add(BorderLayout.SOUTH,foot);

        jdSingIn = new JdSingIn(presenterApp);

        //this.add(BorderLayout.CENTER,singIn);
    }

    public String fileChoosertest(){
        return jpMenuTour.fileChoosertest();
    }

    public void addJDialog(){
        jdSingIn.setVisible(true);
    }

    public void closeDialog(){
        jdSingIn.dispose();
    }

    public Cyclist registerCyclist(){
        return jdSingIn.registrerCyclist();
    }

    public void clearTable(){
        jpBody.clearTable();
    }

    public void bestTimeRunner(String name, LocalTime time) {
        foot.bestTimeRunner(name,time);
    }

    public void averageMale(LocalTime timeMale, LocalTime timeFemale){
        foot.averageMale(timeMale,timeFemale);
    }


    public void addCyclist(Object [] cyclist){
        jpBody.addCyclist(cyclist);
    }

    /**
     * Metodos que reinician los datos mostrados en el footer
     */
    public void resertTimeRunner(){
        foot.resetTimeRunner();
    }
    public void resetAverageMale(){
        foot.resetAverageMale();
    }

    /**
     * Multi lenguaje
     */
    public void changeLanguage(){
        jpMenuTour.changeLanguage();
        foot.changeLanguage();
        jpBody.changeLanguage();
        jdSingIn.changeLanguage();
    }
}
