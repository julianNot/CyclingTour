package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
    public static Properties generateProperties(String pathFile ) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(pathFile);
        properties.load( input );
        return properties;
    }

    public static void saveProperties( Properties properties, String pathFile ) throws IOException{
        FileOutputStream output = new FileOutputStream(pathFile);
        properties.store(output, null);
        output.close();
    }

    /**
     * Metodo encargado de obtener los elementos de la lineas del
     * archivo evitango los signos '?'
     * @param string routa del archivo
     * @return lista de elementos ya separados
     */
    public static String[] splitLine(String string){
        return string.split("\\?+");
    }
}
