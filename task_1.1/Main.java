/* 
Напиши программу, которая в методе main объявляет такие переменные:
name типа String, age типа int и city типа String.
Примечание: "объявить переменную" - значит то же, что и "создать переменную".
Требования:
•
Объяви переменную name типа String.
•
Объяви переменную age типа int.
•
Объяви переменную city типа String.
•
Должны быть объявлены 3 переменные.
*/

public class Main {
    public static void main(String[] args) {
        int age;
        String city, name;
        age = 35;
        city = "Moscow";
        name = "Michael";
        System.out.println("city = " + city + "; name = " + name + "; age = " + age);
    }
}
