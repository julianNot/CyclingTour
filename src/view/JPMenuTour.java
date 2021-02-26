package view;

import presenter.Commands;
import presenter.PresenterApp;

import javax.swing.*;
import java.awt.*;

public class JPMenuTour extends JPanel {

    public JPMenuTour(PresenterApp presenterApp) {
        initComponents(presenterApp);
    }

    private void initComponents(PresenterApp presenterApp) {
        addPanelCenter(presenterApp);
    }

    public void addPanelCenter(PresenterApp presenterApp){
        JPanel menuOptions = new JPanel();
        menuOptions.setLayout(new BoxLayout(menuOptions,BoxLayout.X_AXIS));
        /**
         * Muestra el mejor tiempo
         */
        JButton bestTime = new JButton(ConstantsIU.MENU_BEST_TIME);
        bestTime.setActionCommand(Commands.C_SHOW_BEST_TIME_TABLE.toString());
        bestTime.addActionListener(presenterApp);

        JButton averageMale = new JButton(ConstantsIU.MENU_AVERAGES);
        averageMale.setActionCommand(Commands.C_SHOW_AVERAGES.toString());
        averageMale.addActionListener(presenterApp);

        JButton runnerBestTime = new JButton(ConstantsIU.MENU_BEST_RUNNER);
        runnerBestTime.setActionCommand(Commands.C_SHOW_BEST_TIME_RUNNER.toString());
        runnerBestTime.addActionListener(presenterApp);

        JButton addRunner = new JButton(ConstantsIU.MENU_ADD_RUNNER);
        addRunner.setActionCommand(Commands.C_SHOW_SIGN_IN.toString());
        addRunner.addActionListener(presenterApp);

        menuOptions.add(bestTime);
        menuOptions.add(averageMale);
        menuOptions.add(runnerBestTime);
        menuOptions.add(addRunner);

        this.add(menuOptions);
    }

}
