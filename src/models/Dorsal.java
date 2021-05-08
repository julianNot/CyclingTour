package models;

public class Dorsal {
    private Cyclist cyclist;
    private int numberDorsal = 0;

    public Dorsal(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setNumberDorsal(int numberDorsal) {
        this.numberDorsal = numberDorsal;
    }

    public int getNumberDorsal() {
        return numberDorsal;
    }


    public Object[] toObjectVector() {
        return new Object[] {getNumberDorsal(),cyclist.getTotalTime(),cyclist.getName(), cyclist.getFirstLastName(),
                cyclist.getSecondLastName(), cyclist.getAge(), cyclist.getGender(), cyclist.getTeam()};
    }

}
