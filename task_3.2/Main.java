/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static boolean compare(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(compare(2, 5));
        System.out.println(compare(3, 7));
        System.out.println(compare(3, 3));

    }
}
