package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cyclist {
    private String name;
    private String firtsLastName;
    private String secondLastName;
    private LocalDate brithdate;
    private char gender;
    private Team team;
    private Time totalTime;

    public Cyclist(String name, String firtsLastName, String secondLastName, LocalDate brithdate, char gender, Team team, Time totalTime) {
        this.name = name;
        this.firtsLastName = firtsLastName;
        this.secondLastName = secondLastName;
        this.brithdate = brithdate;
        this.gender = gender;
        this.team = team;
        this.totalTime = totalTime;
    }

    public int getAge() {
        return LocalDate.now().getYear() - brithdate.getYear();
    }

    public String getName() {
        return name;
    }

    public String getFirtsLastName() {
        return firtsLastName;
    }

    public String getSecondlastName() {
        return secondLastName;
    }

    public char getGender() {
        return gender;
    }

    public Team getTeam() {
        return team;
    }

    public Time getTotalTime() {
        return totalTime;
    }

    public static void main(String[] args) {
        Cyclist cyclist = new Cyclist("julian", "Ardila", "Arguello", LocalDate.of(2000, 8, 07), 'M', Team.INEOS, new Time(LocalTime.of(2,24,15)));
        System.out.println(cyclist.getAge());
    }
}
