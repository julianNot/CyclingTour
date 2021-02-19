package view;

import models.Cyclist;
import models.Dorsal;
import models.Gender;
import models.Team;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public final static int BEST_TIME_TABLE = 1;
    public final static int AVERAGE_MALE_AND_fEMALE = 2;
    public final static int RUNNER_BEST_TIME = 3;
    public final static int ADD_CYCLIST = 4;
    public final static int EXIT = 0;

    public final static String DORSAL_NUMBER = "N° Dorsal";
    public final static String TOTAL_TIME = "Total Tiempo";
    public final static String NAME = "Nombre";
    public final static String LAST_NAME = "1° Apellido";
    public final static String SECOND_NAME = "2° Apellido";
    public final static String AGE = "Edad";
    public final static String TEAM = "Equipo";

    public final static String AVERAGE_MALE = "PROMEDIO MASCULINO: ";
    public final static String AVERAGE_FEMALE = "PROMEDIO FEMENINO: ";


    public final static String ERROR_INSUFICENT = "Error";

    public final static String FORMAT = "%1$-10s %2$-20s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s";
    public static final Object[] HEADERS = {DORSAL_NUMBER, TOTAL_TIME, NAME, LAST_NAME, SECOND_NAME, AGE, TEAM};

    public final static String FORMAT_AVERAGES = "%1$-20s %2$-20s";


    public View(){
        scanner = new Scanner(System.in);
    }

    public int showMenu(){
        System.out.println("TOUR UPTC");
        System.out.println("1. Tabla Mejor tiempo Masculino \n 2. Promedios Masculino y Femeninos \n 3. Corredora con mejor tiempo \n 4. Agregar corredor \n 0. Salir ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showHeader(){
        System.out.println(String.format(FORMAT,HEADERS));
        System.out.println("============================================================================================================");
    }

    public void showAverages(LocalTime timeMale, LocalTime timeFemale){
        Object [] averagesMale = {AVERAGE_MALE, timeMale};
        System.out.println(String.format(FORMAT_AVERAGES,averagesMale));
        Object [] averagesFemale = {AVERAGE_FEMALE, timeFemale};
        System.out.println(String.format(FORMAT_AVERAGES,averagesFemale));

    }

    public void showBestRunner(Dorsal cyclist){
        Cyclist temp = cyclist.getCyclist();
        Object[] dates = {cyclist.getNumberDorsal(), temp.getTotalTime(), temp.getName() , temp.getFirstLastName(), temp.getSecondLastName(),
                temp.getAge(), temp.getTeam()};
        System.out.println(String.format(FORMAT, dates));
    }

    public void showListDatas(Object[][] dataList) {
        if(dataList != null) {
            showHeader();
            for (int i = 0; i < dataList.length; i++) {
                Object[] dataObject = dataList[i];
                System.out.println(String.format(FORMAT, dataObject));
            }
        }else
            System.err.println(ERROR_INSUFICENT);
    }

    public String nameCyclist(){
        System.out.println("Ingrese Nombre:");
        return scanner.nextLine();
    }

    public String getFirstLastName(){
        System.out.println("Ingrese Apellido");
        return scanner.nextLine();
    }

    public String getSecondName(){
        System.out.println("Ingrese segundo Apellido");
        return scanner.nextLine();
    }

    public LocalDate getBirthdate(){
        System.out.println("Ingrese fecha de nacimiento");
        System.out.println("Año \n Mes \n Dia");
        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year,month,day);
    }

    public Gender getGender(){
        System.out.println("Ingrese sexo M o F");
        String gender = scanner.nextLine().toUpperCase().trim();
        return Gender.valueOf(gender);
    }

    public Team getTeam(){
        System.out.println("Ingrese Nombre del Equipo");
        System.out.println("ASTANA, BORA, DECEUNINCK, EF, LOTTO, SCOTT, MOVISTAR, MACLAREN, INEOS, EMIRATES");
        String team = scanner.nextLine().toUpperCase().trim();
        return models.Team.valueOf(team);
    }

    public LocalTime getTotalTime(){
        System.out.println("Ingrese Tiempo total de recorrido");
        System.out.println("Hora \n Minutos  \n Segundos");
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int seconds = Integer.parseInt(scanner.nextLine());
        return LocalTime.of(hour, minutes, seconds);
    }
}
