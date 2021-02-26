package presenter;

import models.*;
import view.JFMainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class PresenterApp implements ActionListener {

    private JFMainWindow jfMainWindow;
    private DatasRunners datasRunners;

    public PresenterApp() {
        this.datasRunners = new DatasRunners();
        this.jfMainWindow = new JFMainWindow(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())){
            case C_SHOW_SIGN_IN:
                this.addPanelSignIn();
            break;
            case C_SHOW_BEST_TIME_TABLE:
                //table
                this.showBestTime(datasRunners.generateDatas().get(1).getCyclist().getTotalTime());
                break;
            case C_SHOW_AVERAGES:
                this.averageMale(datasRunners.averageMale(Gender.M), datasRunners.averageMale(Gender.F));
                break;
            case C_SHOW_BEST_TIME_RUNNER:
                Cyclist cyclist = datasRunners.bestRunner().getCyclist();
                this.bestTimeRunner(cyclist.getName(),cyclist.getTotalTime());
                break;
            default:
                break;
        }
    }

    public void bestTimeRunner(String name, LocalTime time){
        jfMainWindow.bestTimeRunner(name,time);
    }

    public void averageMale(LocalTime timeMale, LocalTime timeFemale){
        jfMainWindow.averageMale(timeMale, timeFemale);
    }

    private void showBestTime(LocalTime time) {
        jfMainWindow.showBestTime(time);
    }


    public void addPanelSignIn(){
        jfMainWindow.addPanelSignIn();
    }

    public static void main(String[] args) {
        new PresenterApp();
    }
}
