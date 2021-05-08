package models;

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
        runners = new ArrayList<>();
    }

    public void addDorsals(Dorsal []  dorsals){
        this.dorsals = dorsals;
    }

    public void addOnlyDorsal(Dorsal dorsal){
        dorsal.setNumberDorsal(runners.size()+1);
        runners.add(dorsal);
    }

    public void filtersByAgeAndLetters() {
        for (int i = 0; i < dorsals.length; i++) {
            int tempAge = dorsals[i].getCyclist().getAge();
            if (tempAge >= MINIMUM_AGE && tempAge <= MAX_AGE && isUppercaseLetters(dorsals[i]) && dorsals[i] != null) {
                runners.add(dorsals[i]);
            }
            generate();
        }
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
        for (int i = 0; i < runners.size(); i++) {
            if (runners.get(i).getCyclist().getGender() == Gender.F){
                return runners.get(i);
            }
        }
        return null;
    }

    public void add(Dorsal dorsal){
        int age = dorsal.getCyclist().getAge();
        if (isUppercaseLetters(dorsal) && age >= MINIMUM_AGE && age <= MAX_AGE ){
            dorsal.setNumberDorsal(runners.size()+1);
            runners.add(dorsal);
        }
    }

    public ArrayList<Dorsal> getRunners() {
        return runners;
    }

    public Dorsal getCyclist(int index){
        return runners.get(index);
    }

    public int sizeRunnersList(){
        return runners.size();
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
}
