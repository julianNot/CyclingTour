package models;

import java.util.ArrayList;

public class Checker {
    private ArrayList<Dorsal> runners;
    private Dorsal[] dorsals;

    public static final int MINIMUM_AGE = 15;
    public static final int MAX_AGE = 40;

    public Checker(Dorsal[] dorsals) {
        this.dorsals = dorsals;
    }

    /**
     * Metodo encargado de filtrar los corredores por la edad
     */
    public void filterByeAge(){
        for (int i = 0; i < dorsals.length; i++) {
            int tempAge = dorsals[i].getCyclist().getAge();
            if (tempAge >= MINIMUM_AGE && tempAge <= MAX_AGE){
                runners.add(dorsals[i]);
            }
        }
    }




}
