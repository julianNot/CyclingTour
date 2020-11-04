package models;

public class GenerateBib {
    private Dorsal [] dorsals;

    public GenerateBib(Dorsal [] dorsals) {
        this.dorsals = dorsals;
    }

    public void generate(){
        for (int i = 0; i < dorsals.length; i++) {
            if (dorsals[i].getCyclist().getName() != null ){
                dorsals[i].setNumberDorsal(i);
            }
        }
    }

    /*public void test(){
        //System.out.println(cyclists.length);
        generate();
        System.out.println(dorsals.length);
        System.out.println(dorsals[0].getNumberDorsal());
        System.out.println(dorsals[1].getNumberDorsal());
        //System.out.println(dorsals[1].getCyclist().getAge());
    }*/

    /*public static void main(String[] args) {
        GenerateBib generate = new GenerateBib(new Dorsal[]{
                new Dorsal(new Cyclist("julian","Ardila","Arguello",LocalDate.of(2000,8,07),'M',Team.INEOS,new Time(LocalTime.of(2,34,12)))),
                new Dorsal(new Cyclist("j","a","e",LocalDate.of(1996,3,2),'F',Team.EMIRATES,new Time(LocalTime.of(1,45,13)))),
                new Dorsal(new Cyclist("robert","musk","rhoads",LocalDate.of(1995,5,1),'M',Team.DECEUNINCK, new Time(LocalTime.of(3,50,23)))),
        });
        generate.generate();
        System.out.println(generate.dorsals[0].getCyclist().getName() +" "+ generate.dorsals[0].getNumberDorsal());
        System.out.println(generate.dorsals[1].getCyclist().getName() +" "+ generate.dorsals[1].getNumberDorsal());
    }*/
}
