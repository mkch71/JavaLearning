/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat1.age = 5;
        cat1.strength=3;
        cat1.weight=20;
        cat2.age = 10;
        cat2.strength=3;
        cat2.weight=15;
        cat3.age = 4;
        cat3.strength=7;
        cat3.weight=25;
        System.out.println(cat1.age + " | " +cat1.strength+ " | "+ cat1.weight);
        System.out.println(cat2.age + " | " +cat2.strength+ " | "+ cat2.weight);
        System.out.println(cat3.age + " | " +cat3.strength+ " | "+ cat3.weight);
        System.out.println(cat3.fight(cat2));
        System.out.println(cat2.fight(cat3));
        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
        System.out.println(cat1.fight(cat3));
        System.out.println(cat3.fight(cat1));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        return(rate(this.age,anotherCat.age) +
                rate(this.strength,anotherCat.strength) +
                rate(this.weight,anotherCat.weight)) >= 0;
    }
    static int rate(int paramCat, int paramAnotherCat){
        if (paramCat-paramAnotherCat >0 ) return 1;
        else if (paramCat-paramAnotherCat<0) return -1;
        else return 0;
    }
}
