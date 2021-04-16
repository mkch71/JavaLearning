/*
Помогите коту обрести имя с помощью метода setName.
Требования:
•	Класс Cat должен содержать только одну переменную name.
•	Переменная name должна иметь модификатор доступа private и тип String.
•	Метод setName класса Cat должен устанавливать значение переменной private String name равным переданному параметру String name.
*/


public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        //System.out.println(cat.name); только через get name по условию private
        System.out.println(cat.getName());
    }
}

class Cat {
    private String name = "безымянный кот";

    public void setName(String name) {
       this.name=name;
    }
    public String getName(){
        return this.name;
    }

}
