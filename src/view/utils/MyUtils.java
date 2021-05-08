package view.utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyUtils {

    public static void setButtonForImages(JButton jButton, ImageIcon imageIcon){
        jButton.setIcon(imageIcon);
        jButton.setBackground(null);
        jButton.setBorder(null);
        jButton.setForeground(Color.WHITE);
        jButton.setHorizontalTextPosition( SwingConstants.CENTER );
        jButton.setVerticalTextPosition( SwingConstants.BOTTOM );
        jButton.setBorder(new EmptyBorder(15,15,10,15));
    }

    /**
     * Cambio de lenguajes
     */
    public static Properties setLanguageProperties(String file) throws IOException{
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);
        return properties;
    }

    public static void saveLanguageProperties(Properties properties, String file) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream,null);
        fileOutputStream.close();
    }

}
