package familyTree;

public class Main {
    public static void main(String[] args) {
        Person nina = new Person("Нина", 60,null,null);
        Person kolya = new Person("Коля", 65,null,null);
        Person olga = new Person("Ольга",35,nina,kolya);

        Person irina = new Person("Ирина", 62,null,null);
        Person anton = new Person("Антон", 70,null,null);
        Person oleg = new Person("Олег",40,irina,anton);

        Person igor = new Person("Игорь",13, olga, oleg);
        //System.out.println(oleg.name);
        //System.out.println(oleg.getHp());
        //System.out.println(igor.getMother().getMother().getName());
        igor.getInfo();
        oleg.getInfo();

    }
}

class Person{
    private String name;
    private int age;
    private int hp;
    private Person mother;
    private Person father;

    public Person(String name, int age, Person mother, Person father) {
        this.name = name;
        this.age = age;
        this.hp = 100;
        this.mother = mother;
        this.father = father;
    }
    public void getInfo(){
        String info = "Меня зовут: "+ this.name+"\n";

        if (this.mother!=null) {
            info += "Мою маму зовут: " + this.mother.name + "\n";
            if (this.mother.mother != null) {
                info += "Бабушку по маме зовут: " + this.mother.mother.name + "\n";
            }
            if (this.mother.father != null) {
                info += "Дедушку по маме зовут: " + this.mother.father.name + "\n";
            }
        }

        if (this.father != null) {
            info += "Моего папу зовут: " + this.father.name + "\n";
            if (this.father.mother != null) {
                info += "Бабушку по папе зовут: " + this.father.mother.name + "\n";
            }
            if (this.father.father != null) {
                info += "Дедушку по папе зовут: " + this.father.father.name + "\n";
            }
        }
        System.out.println(info);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(this.hp + hp > 100) this.hp=100;
        else this.hp += hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }
}
