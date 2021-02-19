package view;

import javax.swing.*;
import java.awt.*;

public class JPMenuTour extends JPanel {

    public JPMenuTour() {
        initComponents();
    }

    private void initComponents() {
        addPanelCenter();
        this.add(addPanelCenter());
    }

    public JPanel addPanelCenter(){
        JPanel menuOptions = new JPanel();
        menuOptions.setLayout(new BoxLayout(menuOptions,BoxLayout.X_AXIS));

        JButton bestTime = new JButton(ConstantsIU.MENU_BEST_TIME);
        JButton averages = new JButton(ConstantsIU.MENU_AVERAGES);
        JButton runnerBestTime = new JButton(ConstantsIU.MENU_BEST_RUNNER);
        JButton addRunner = new JButton(ConstantsIU.MENU_ADD_RUNNER);

        menuOptions.add(bestTime);
        menuOptions.add(averages);
        menuOptions.add(runnerBestTime);
        menuOptions.add(addRunner);

        return menuOptions;
    }

}
