package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cyclist {
    private String name;
    private String firstLastName;
    private String secondLastName;
    private LocalDate birthdate;
    private Gender gender;
    private Team team;
    private LocalTime totalTime;

    public Cyclist(String name, String firstLastName, String secondLastName, LocalDate birthdate, Gender gender, Team team, LocalTime totalTime) {
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.team = team;
        this.totalTime = totalTime;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthdate.getYear();
    }

    /**
     * prueba
     * @return tiempo
     */
    public LocalTime timeTest(){
        return LocalTime.now();
    }

    public String getName() {
        return name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Team getTeam() {
        return team;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

}
