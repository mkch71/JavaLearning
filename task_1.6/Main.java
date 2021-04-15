/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double UserData = scan.nextDouble();
        System.out.println(UserData*=1.15);
/*
При вводе 100 выдает 114.9999..
Нагуглил что можно использовать BigDecimal - но ниаслил разораться(((
Можно конечно и округление просто приделать ...
*/
    }
}
