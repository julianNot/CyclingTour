package tests;

import models.*;
import controller.PresenterApp;
import view.JdSingIn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TestManager {

    private Manager manager;
    private Scanner scanner;
    private PresenterApp presenterApp;
    private JdSingIn jdSingIn;

    public TestManager() {
        this.manager = new Manager();
        this.scanner = new Scanner(System.in);
        this.presenterApp = new PresenterApp();

    }

    public void addDorsal(){
        manager.addDorsals(
                new Dorsal[]{
                        new Dorsal(new Cyclist("Cristian", "Ocampo", "Arguello", LocalDate.of(2000, 8, 07), Gender.M, Team.INEOS, LocalTime.of(2, 34, 12))),
                        new Dorsal(new Cyclist("Camilo", "Abella", "Araque", LocalDate.of(1996, 3, 2), Gender.M, Team.EMIRATES, LocalTime.of(1, 45, 13))),
                        new Dorsal(new Cyclist("Robert", "Musk", "Rhoads", LocalDate.of(1995, 5, 1), Gender.M, Team.DECEUNINCK, LocalTime.of(3, 50, 23)))
                });
    }

    public void add(){
        addDorsal();
        manager.generate();
        manager.filtersByAgeAndLetters();
        ArrayList<Dorsal> temp = manager.getRunners();
        for (int i =0; i < temp.size(); i++){
            System.out.println(temp.get(i).getCyclist().getName() + " Tiempo: " + temp.get(i).getCyclist().getTotalTime());
        }
    }


}
