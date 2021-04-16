/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.
*/

public class Main {
    public static boolean compareSum(int a, int b) {
        return (a + b)>10;
    }

    public static void main(String[] args) {
        System.out.println(compareSum(2, 5));
        System.out.println(compareSum(3, 7));
        System.out.println(compareSum(67, 3));

    }
}
