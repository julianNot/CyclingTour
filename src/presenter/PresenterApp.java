package presenter;

import view.JFMainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class PresenterApp implements ActionListener {

    private JFMainWindow jfMainWindow;

    public PresenterApp() {
        this.jfMainWindow = new JFMainWindow(this)  ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())){
            case C_SHOW_SIGN_IN:
                this.addPanelSignIn();
            break;
            case C_SHOW_BEST_TIME:
                this.showBestTime(LocalTime.now());
            default:
                break;
        }
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
