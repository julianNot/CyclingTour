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
                //
                break;
            case View.AVERAGE_MALE_AND_fEMALE:
                getAverages();
                //
                break;
            case View.RUNNER_BEST_TIME:
                getBestRunner();
                break;
            case View.ADD_CYCLIST:

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
        //manager.
    }


    public void createUsers(){
        manager.addDorsals(
        new Dorsal[]{
                new Dorsal(new Cyclist("Cristian", "Ocampo", "Arguello", LocalDate.of(2000, 8, 07), Gender.M, Team.INEOS, LocalTime.of(2, 34, 12))),
                new Dorsal(new Cyclist("Camilo", "Abella", "Araque", LocalDate.of(1996, 3, 2), Gender.M, Team.EMIRATES, LocalTime.of(1, 45, 13))),
                new Dorsal(new Cyclist("Robert", "Musk", "Rhoads", LocalDate.of(1995, 5, 1), Gender.M, Team.DECEUNINCK, LocalTime.of(3, 50, 23))),
                new Dorsal(new Cyclist("Rubiela", "Cristancho", "Carapaz", LocalDate.of(2003, 6, 14), Gender.F, Team.ASTANA, LocalTime.of(4, 27, 10))),
                new Dorsal(new Cyclist("Matias", "Rupestre", "Chicamocha", LocalDate.of(2004, 02, 28), Gender.M, Team.BORA, LocalTime.of(2, 31, 05))),
                new Dorsal(new Cyclist("Isabella","Perez","Arguello", LocalDate.of(2003,10,05),Gender.F, Team.LOTTO, LocalTime.of(1,30,25)))
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
