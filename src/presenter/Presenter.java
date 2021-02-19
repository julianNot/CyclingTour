package presenter;

import models.*;
import view.View;

import java.time.LocalDate;
import java.time.LocalTime;

public class Presenter {
    private Manager manager;
    private View console;

    public Presenter() {
        manager = new Manager();
        console = new View();
    }

    public void showMenu(){
        int option = console.showMenu();
        switch (option){
            case View.BEST_TIME_TABLE:
                getTableOfDates();
                break;
            case View.AVERAGE_MALE_AND_fEMALE:
                getAverages();
                break;
            case View.RUNNER_BEST_TIME:
                getBestRunner();
                break;
            case View.ADD_CYCLIST:
                addCyclistForList();
                break;
            case View.EXIT:
                return;
        }
        showMenu();
    }

    public void getTableOfDates(){
        console.showListDatas(manager.toMatrixVec());
    }

    public void getAverages(){
        LocalTime timeMale = manager.average(Gender.M);
        LocalTime timeFemale = manager.average(Gender.F);
        console.showAverages(timeMale, timeFemale);
    }

    public void getBestRunner(){
        Dorsal dorsal = manager.bestRunner();
        console.showHeader();
        console.showBestRunner(dorsal);
    }

    public void addCyclistForList(){
        manager.add(new Dorsal(new Cyclist(console.nameCyclist(),console.getFirstLastName(),console.getSecondName(),console.getBirthdate(),console.getGender(),console.getTeam(),console.getTotalTime())));
        manager.orderByLessTime();
    }


    public void createUsers(){
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
                new Dorsal(new Cyclist("Alexandra","Suaterna","Ardila", LocalDate.of(2000,8,7),Gender.F, Team.DECEUNINCK, LocalTime.of(3,42,13))),
                new Dorsal(new Cyclist("Mariana","Taborda","Smith", LocalDate.of(2003,4,27),Gender.F, Team.SCOTT, LocalTime.of(4,5,3))),
                new Dorsal(new Cyclist("Gerardo","Gutierrez","Pinzon", LocalDate.of(1995,1,15),Gender.M, Team.MOVISTAR, LocalTime.of(1,50,33))),
                new Dorsal(new Cyclist("Jennifer","Gallego","Hernandez", LocalDate.of(1997,6,24),Gender.F, Team.MOVISTAR, LocalTime.of(2,50,53))),
        });
        manager.filtersByAgeAndLetters();
        manager.orderByLessTime();
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.createUsers();
        presenter.showMenu();
    }
}
