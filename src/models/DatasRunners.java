package models;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DatasRunners {
    public static final int MINIMUM_AGE = 15;
    public static final int MAX_AGE = 40;

    private Manager manager;

    private ArrayList<Dorsal> rejected;

    public DatasRunners() {
        manager = new Manager();
        initComponents();
    }

    public void initComponents() {
        addDorsal();
        manager.generate();
        manager.filtersByAgeAndLetters();
        manager.orderByLessTime();
        rejected = new ArrayList<>();
    }

    public void orderByLessTime(){
        manager.orderByLessTime();
    }


    public ArrayList<Dorsal> generateDatas(){
        return manager.getRunners();
    }

    public LocalTime averageMale(Gender gender){
        return manager.average(gender);
    }

    public Dorsal bestRunner(){
        return manager.bestRunner();
    }

    public void filtersByAgeAndLetters(Dorsal dorsal) {
        Cyclist temp = dorsal.getCyclist();
        int tempAge = temp.getAge();
        if (temp != null){
            if (tempAge >= MINIMUM_AGE && tempAge <= MAX_AGE &&  temp != null) {
                manager.add(dorsal);
            }else {
                rejected.add(dorsal);
            }
        }

    }


    private void addDorsal() {
        manager.addDorsals(
                new Dorsal[]{
                        new Dorsal(new Cyclist("Cristian", "Ocampo", "Arguello", LocalDate.of(2000, 8, 07), Gender.M, Team.INEOS, LocalTime.of(2, 34, 12))),
                        new Dorsal(new Cyclist("Camilo", "Abella", "Araque", LocalDate.of(1996, 3, 2), Gender.M, Team.EMIRATES, LocalTime.of(1, 45, 13))),
                        new Dorsal(new Cyclist("Robert", "Musk", "Rhoads", LocalDate.of(1995, 5, 1), Gender.M, Team.DECEUNINCK, LocalTime.of(3, 50, 23))),
                        new Dorsal(new Cyclist("Rubiela", "Cristancho", "Carapaz", LocalDate.of(2003, 6, 14), Gender.F, Team.ASTANA, LocalTime.of(4, 27, 10))),
                        new Dorsal(new Cyclist("Matias", "Rupestre", "Chicamocha", LocalDate.of(2004, 02, 28), Gender.M, Team.BORA, LocalTime.of(2, 31, 05))),
                        new Dorsal(new Cyclist("Isabella","Perez","Arguello", LocalDate.of(2003,10,05),Gender.F, Team.LOTTO, LocalTime.of(1,30,25))),
                        new Dorsal(new Cyclist("Yilver","Mota","Gustamante", LocalDate.of(1995,1,02),Gender.M, Team.MACLAREN, LocalTime.of(2,42,12))),
                        new Dorsal(new Cyclist("Juliana","Calderon","Ramirez", LocalDate.of(2005,11,8),Gender.F, Team.SCOTT, LocalTime.of(1,50,45))),
                        new Dorsal(new Cyclist("Fernando","Silva","Mojica", LocalDate.of(1999,12,12),Gender.M, Team.INEOS, LocalTime.of(3,33,5))),
                        new Dorsal(new Cyclist("Rodrigo","Vasquez","Perez", LocalDate.of(1995,5,21),Gender.M, Team.EF, LocalTime.of(1,23,59))),
                        new Dorsal(new Cyclist("Martin","Gomez","Roldan", LocalDate.of(2003,9,1),Gender.M, Team.INEOS, LocalTime.of(2,32,23))),
                        new Dorsal(new Cyclist("Alexandra","Suaterna","Ardila", LocalDate.of(1995,8,7),Gender.F, Team.DECEUNINCK, LocalTime.of(3,42,13))),
                        new Dorsal(new Cyclist("Mariana","Taborda","Smith", LocalDate.of(2003,4,27),Gender.F, Team.SCOTT, LocalTime.of(4,5,3))),
                        new Dorsal(new Cyclist("Gerardo","Gutierrez","Pinzon", LocalDate.of(1995,1,15),Gender.M, Team.MOVISTAR, LocalTime.of(1,50,33))),
                        new Dorsal(new Cyclist("Jennifer","Gallego","Hernandez", LocalDate.of(1997,6,24),Gender.F, Team.MOVISTAR, LocalTime.of(2,50,53))),
                });
    }

    public Manager getManager() {
        return manager;
    }
}
