package models;

public class Dorsal {
    private Cyclist cyclist;
    private int numberDorsal = 0;

    public Dorsal() {

    }

    public int generateDorsal(){
        return numberDorsal++;
    }
}
