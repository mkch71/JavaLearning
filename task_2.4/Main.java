/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму вклада: ");
        double sumDeposit = scan.nextDouble();
        System.out.println("Введите процент: ");
        double percent = scan.nextDouble();
        System.out.println("Вклад на начало периода | Ставка % | Сумма процентов | Вклад на конец периода");
        for (int i = 1; i<5;i++) {
            System.out.println(sumDeposit +" | "+ percent+" | "+ sumDeposit*percent/100 +" | " + (sumDeposit*=(1+percent/100)));
        }
    }
}
