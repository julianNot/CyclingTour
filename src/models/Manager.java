package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Manager {
    public static final int MINIMUM_AGE = 15;
    public static final int MAX_AGE = 40;
    public static final int SECONDS_IN_HOUR = 3600;
    public static final int SECONDS_IN_MINUTE = 60;


    private Dorsal [] dorsals;
    private ArrayList<Dorsal> runners;

    public Manager() {
        this.dorsals = dorsals;
        runners = new ArrayList<>();
    }

    public void addDorsals(Dorsal []  dorsals){
        this.dorsals = dorsals;
    }

    /**
     * Metodo encargado de filtrar los corredores por la edad
     */
    public void filtersByAgeAndLetters(){
        for (int i = 0; i < dorsals.length; i++) {
            int tempAge = dorsals[i].getCyclist().getAge();
            if (tempAge >= MINIMUM_AGE && tempAge <= MAX_AGE && isUppercaseLetters(dorsals[i]) && dorsals[i] != null){
                runners.add(dorsals[i]);
            }
        }
        generate();
    }

    public boolean isUppercaseLetters(Dorsal dorsal){
        Cyclist tempCyclist = dorsal.getCyclist();
        if (Character.isUpperCase(tempCyclist.getName().charAt(0)) && Character.isUpperCase(tempCyclist.getFirstLastName().charAt(0))
                && Character.isUpperCase(tempCyclist.getSecondLastName().charAt(0))) {
            return true;
        }
        return false;
    }

    public void generate(){
        for (int i = 0; i < runners.size(); i++) {
            if (runners.get(i).getCyclist().getName() != null ){
                runners.get(i).setNumberDorsal(i+1);
            }
        }
    }

    public LocalTime average(Gender gender) {
        int result = 0;
        int quantity = 0;
        for (int i = 0; i < runners.size(); i++) {
            Cyclist cyclist = runners.get(i).getCyclist();
            if (cyclist.getGender() == gender) {
                LocalTime tempTime = cyclist.getTotalTime();
                result += (tempTime.getHour() * SECONDS_IN_HOUR) + (tempTime.getMinute() * SECONDS_IN_MINUTE) + (tempTime.getSecond());
                result += cyclist.getTotalTime().getSecond();
                quantity++;
            }
        }
        if (quantity > 0){
            result /= quantity;
        }
        return LocalTime.of(result/SECONDS_IN_HOUR, (result/SECONDS_IN_MINUTE) % SECONDS_IN_MINUTE, result % SECONDS_IN_MINUTE) ;
    }

    public void orderByLessTime(){
        runners.sort(new Comparator<Dorsal>() {
            @Override
            public int compare(Dorsal o1, Dorsal o2) {
                return o1.getCyclist().getTotalTime().compareTo(o2.getCyclist().getTotalTime());
            }
        });
    }

    public Dorsal bestRunner(){
        //orderByLessTime();
        for (int i = 0; i < runners.size(); i++) {
            if (runners.get(i).getCyclist().getGender() == Gender.F){
                return runners.get(i);
            }
        }
        return null;
    }

    public  Object[][] toMatrixVec(){
        Object[][] dataMatrix = null;
        int sizeColumns = runners.get(0).toObjectVector().length;
        if (runners.size() > 0){
            dataMatrix = new Object[runners.size()][sizeColumns];
            for (int i=0; i <dataMatrix.length;i++){
                dataMatrix[i] = runners.get(i).toObjectVector();
            }
        }
        return dataMatrix;
    }

    public ArrayList<Dorsal> getRunners() {
        return runners;
    }



   /* public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addDorsals(new Dorsal[]{
                new Dorsal(new Cyclist("Cristian", "Ocampo", "Arguello", LocalDate.of(2000, 8, 07), Gender.M, Team.INEOS, LocalTime.of(2, 34, 12))),
                new Dorsal(new Cyclist("Camilo", "Abella", "Araque", LocalDate.of(1996, 3, 2), Gender.M, Team.EMIRATES, LocalTime.of(1, 45, 13))),
                new Dorsal(new Cyclist("Robert", "Musk", "Rhoads", LocalDate.of(1995, 5, 1), Gender.M, Team.DECEUNINCK, LocalTime.of(3, 50, 23))),
                new Dorsal(new Cyclist("Rubiela", "Cristancho", "Carapaz", LocalDate.of(2003, 6, 14), Gender.F, Team.ASTANA, LocalTime.of(4, 27, 10))),
                new Dorsal(new Cyclist("Matias", "Rupestre", "Chicamocha", LocalDate.of(2004, 02, 28), Gender.M, Team.BORA, LocalTime.of(2, 31, 05)))
        });

        manager.filtersByAgeAndLetters();
        manager.orderByLessTime();
        System.out.println("Lista de Corredores: ");
        for (int i = 0; i < manager.runners.size(); i++) {
            Cyclist temp = manager.runners.get(i).getCyclist();
            System.out.println( "N° Ciclista: "+ manager.runners.get(i).getNumberDorsal() + " " + temp.getName() + " " + temp.getAge());
        }
        System.out.println("Promedio masculino " + manager.average(Gender.M));
        System.out.println("Promedio feminino  " + manager.average(Gender.F));
        System.out.println(manager.bestRunner().getCyclist().getName());
    }*/
}
