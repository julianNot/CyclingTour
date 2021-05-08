package view;

import com.toedter.calendar.JDateChooser;
import models.*;
import controller.Commands;
import controller.PresenterApp;
import persistence.HandlerLanguage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalTime;
import java.time.ZoneId;

public class JdSingIn extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel jpContainer;
    private JLabel jtText;
    private JTextField jtFirsName;
    private JTextField jtSecondName;
    private JTextField jtLastName;
    private JTextField jtTime;
    private JTextField jtGender;
    private JTextField jtTeam;
    private JDateChooser jDBornDate;
    private JButton jSummint;
    private JButton jCancel;
    //private RoundedJButton jBCreate, jBCancelCreate;


    public JdSingIn(PresenterApp presenterApp) {
        setModal(true);
        setSize(400,550);
        setTitle(ConstantsIU.TITLE_APP);
        setLocationRelativeTo(null);
        setBackground(Color.white);
        this.setIconImage(new ImageIcon(getClass().getResource(ConstantsIU.ICON_ADD_CYCLIST)).getImage());
        //setSize(Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height/2);
        //setVisible(true);
        initComponents(presenterApp);
    }

    public void initComponents(PresenterApp presenterApp){
        jpContainer = new JPanel();
        jpContainer.setBackground(Color.white);
        GridLayout gridLayout = new GridLayout(10, 1);
        gridLayout.setVgap(10);
        jpContainer.setLayout(gridLayout);
        jpContainer.setBorder( new EmptyBorder( 25,25,25,25));

        jtText = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_SING_IN));
        jtText.setForeground(new Color(215,47,57));
        jtText.setFont(new Font("Arial",Font.PLAIN,20));
        jtText.setBorder(new EmptyBorder(10,120,10,30));
        jpContainer.add(jtText);

        jtFirsName = new JTextField();
        jtFirsName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_NAME)));
        jpContainer.add(jtFirsName);

        jtSecondName = new JTextField();
        jtSecondName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_SECOND_NAME)));
        jpContainer.add(jtSecondName);


        jtLastName = new JTextField();
        jtLastName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_LAST_NAME)));
        jpContainer.add( jtLastName );

        jtTime = new JTextField();
        jtTime.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_TIME)));
        jpContainer.add(jtTime);

        jtGender = new JTextField();
        jtGender.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_GENDER)));
        jpContainer.add(jtGender);

        jtTeam = new JTextField();
        jtTeam.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_TEAM)));
        jpContainer.add(jtTeam);

        jDBornDate = new JDateChooser();
        jpContainer.add( jDBornDate );

        jSummint = new JButton();
        jSummint.setActionCommand(Commands.C_SIGN_IN_BUTTON.toString());
        jSummint.addActionListener(presenterApp);
        jSummint.setIcon(new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_ACCEPTED)));
        jSummint.setBackground(null);
        jSummint.setBorder(null);
        jpContainer.add(jSummint);

        jCancel = new JButton();
        jCancel.setIcon(new ImageIcon(new ImageIcon().getClass().getResource(ConstantsIU.ICON_CANCEL)));
        jCancel.setActionCommand(Commands.C_CLOSE_DIALOG.toString());
        jCancel.addActionListener(presenterApp);
        jCancel.setBackground(null);
        jCancel.setBorder(null);
        jpContainer.add(jCancel);


        this.add( jpContainer );
    }


    public Cyclist registrerCyclist(){
        Cyclist temp = new Cyclist(jtFirsName.getText(),jtLastName.getText(),jtSecondName.getText(),jDBornDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),Gender.valueOf(jtGender.getText()), Team.valueOf(jtTeam.getText()) , LocalTime.parse(jtTime.getText()));
        return temp;
    }

    public void changeLanguage(){
        setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TITLE_APP));
        jtText.setText(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_SING_IN));
        jtFirsName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_NAME)));
        jtSecondName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_SECOND_NAME)));
        jtLastName.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_LAST_NAME)));
        jtTime.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_TIME)));
        jtGender.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_GENDER)));
        jtTeam.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsIU.TEXT_TEAM)));
    }

}
