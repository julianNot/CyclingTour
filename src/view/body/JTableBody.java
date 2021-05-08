package view.body;

import persistence.HandlerLanguage;
import view.ConstantsIU;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableBody extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private DefaultTableModel defaultTableModel;
    private JTable jTable;
    private JScrollPane jScroll;

    public JTableBody() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        String [] list = {HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_DORSAL),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_TIME),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_NAME),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_LASTNAME),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_SECOND_NAME),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_AGE),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_GENDER),
                HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_TEAM),};

        defaultTableModel = new DefaultTableModel();
        jTable = new JTable();

        defaultTableModel.setColumnIdentifiers(list);

        jTable.setModel(defaultTableModel);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setFillsViewportHeight(true);
        jTable.setRowHeight(35);

        jTable.getTableHeader().setForeground(new Color(0x030303));
        jTable.getTableHeader().setBackground(new Color(0x2EA082));
        jTable.getTableHeader().setPreferredSize(new Dimension(0,60));
        //jTable.getTableHeader().

        jScroll = new JScrollPane(jTable);
        jScroll.setAlignmentX(LEFT_ALIGNMENT);

        this.add(jScroll);
    }

    public void clearTable(){
        for (int i = 0; i < jTable.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
            i-=1;
        }
    }

    public void addCyclist(Object [] cyclist){
        defaultTableModel.addRow(cyclist);
    }

    public void changeLanguage(){
        defaultTableModel.setColumnIdentifiers( new String [] {
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_DORSAL),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_TIME),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_NAME),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_LASTNAME),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_SECOND_NAME),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_AGE),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_GENDER),
            HandlerLanguage.languageProperties.getProperty(ConstantsIU.TABLE_HEAD_TEAM),
        });
    }
}
