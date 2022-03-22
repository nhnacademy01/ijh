package oop.oop2;

public class Computer {
    DvdDrive dvdDrive = new DvdDrive();
    public static void main(String[] args) {
        Cd bugsCd = new Cd("bugs");
        Computer computer = new Computer();
        computer.play(bugsCd);
    }

    void play(Cd cd) {
        dvdDrive.play(cd);
    }

    void play(Dvd dvd) {
        dvdDrive.play(dvd);
    }
}

class CdDrive {

    void play(Cd cd) {
        // TODO:
        System.out.println(cd.getName());
    }
}

class DvdDrive extends CdDrive {

    void play(Dvd dvd) {
    }
}

class Cd {
    String name;

    public Cd(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dvd {

}
