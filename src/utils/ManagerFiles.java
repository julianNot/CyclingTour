package utils;

import java.io.*;
import java.util.ArrayList;

public class ManagerFiles {
    FileReader fileReader;
    FileWriter fileWriter;
    File file;

    public ArrayList<String> readFile(String file) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineRead;

        while ((lineRead = bufferedReader.readLine())!= null){
            lines.add(lineRead);
        }
        bufferedReader.close();
        return lines;
    }

    public void writeNewfile(String pathToSave, String cyclistBad){
        file = new File(pathToSave);
        try(FileWriter fw=new FileWriter(pathToSave)){

            fw.write(cyclistBad);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
