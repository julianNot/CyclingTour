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

    public static void main(String[] args) {
        Cyclist cyclist = new Cyclist("julian", "Ardila", "Arguello", LocalDate.of(2000, 8, 07), Gender.M, Team.INEOS, LocalTime.of(2,24,15));
        System.out.println(cyclist.getAge());
    }
}
