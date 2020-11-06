package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GenerateBib {
    public static final int MINIMUM_AGE = 15;
    public static final int MAX_AGE = 40;

    private Dorsal [] dorsals;
    private ArrayList<Dorsal> runners;

    public GenerateBib(Dorsal [] dorsals) {
        this.dorsals = dorsals;
        runners = new ArrayList<>();
    }

    public void generate(){
        for (int i = 0; i < runners.size(); i++) {
            if (runners.get(i).getCyclist().getName() != null ){
                runners.get(i).setNumberDorsal(i+1);
            }
        }
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

    public LocalTime maleAverage() {
        int result = 0;
        int quantity = 0;
        for (int i = 0; i < runners.size(); i++) {
            Cyclist cyclist = runners.get(i).getCyclist();
            if (cyclist.getGender() == Gender.M) {
                LocalTime tempTime = cyclist.getTotalTime();
                result += (tempTime.getHour() * 3600) + (tempTime.getMinute() * 60) + (tempTime.getSecond());
                result += cyclist.getTotalTime().getSecond();
                quantity++;
            }
        }
        result /= quantity;
        return LocalTime.of(result/3600, (result/60) % 60, result % 60) ;
    }

    public ArrayList<Dorsal> getRunners() {
        return runners;
    }

    public void test(){
        generate();
        System.out.println(dorsals.length);
        System.out.println(dorsals[0].getNumberDorsal());
        //System.out.println(dorsals[1].getNumberDorsal());
        //System.out.println(dorsals[1].getCyclist().getAge());
    }

    public static void main(String[] args) {
        GenerateBib generate = new GenerateBib(new Dorsal[]{
                new Dorsal(new Cyclist("Cristian","Ocampo","Arguello", LocalDate.of(2000,8,07),Gender.M,Team.INEOS, LocalTime.of(2,34,12))),
                new Dorsal(new Cyclist("Camilo","Abella","Araque", LocalDate.of(1996,3,2),Gender.M,Team.EMIRATES, LocalTime.of(1,45,13))),
                new Dorsal(new Cyclist("Robert","Musk","Rhoads", LocalDate.of(1995,5,1),Gender.M,Team.DECEUNINCK, LocalTime.of(3,50,23))),
                new Dorsal(new Cyclist("Rubiela", "Cristancho", "Carapaz", LocalDate.of(2003,6,14), Gender.F, Team.ASTANA, LocalTime.of(4,27,10))),

        });
        generate.filtersByAgeAndLetters();
        System.out.println(generate.runners.size());
        for (int i = 0; i < generate.runners.size(); i++) {
            Cyclist temp = generate.runners.get(i).getCyclist();
            System.out.println( "N° Ciclista: "+ generate.runners.get(i).getNumberDorsal() + " " + temp.getName() + " " + temp.getAge());
        }
    }
}
