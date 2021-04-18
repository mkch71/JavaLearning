/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main {
    public static void main(String[] args) {
        Horse simpleHorse = new Horse("РжуНеМогу", (byte) 4, true, "ПростоКонь");
        Pegasus horseWithWing = new Pegasus("РжуНеМогу", (byte) 4, true, "КоньОгонь");
        simpleHorse.run();
        horseWithWing.fly();
    }
}
abstract class Animal{
    String speak;
    byte pows;
    boolean vegetarian;

    public Animal(String speak, byte pows,boolean veg){
        this.speak = speak;
        this.pows = pows;
        this.vegetarian = veg;
    }

}
class Horse extends Animal {
    String breed;
    public Horse(String speak, byte pows,boolean veg, String breed){
        super(speak, pows, veg);
        this.breed = breed;
    }
    public void run(){ System.out.println("Игого, я поскакал(а)"); }
}

class Pegasus extends Horse{
    public Pegasus(String speak, byte pows,boolean veg, String breed){
        super(speak, pows, veg, breed);

    }
    public void fly(){ System.out.println("Игого, я полетел(а)"); }
}
