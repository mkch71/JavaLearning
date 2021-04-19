/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //тупой вариант
        List<String> listFamily = new ArrayList<>();
        List<String> listCity = new ArrayList<>();

        while (true) {
            String city = scanner.nextLine();
            if (city.isEmpty()) {
                break;
            }
            String family = scanner.nextLine();
            if (family.isEmpty()) {
                break;
            }

            listFamily.add(family);
            listCity.add(city);
        }

        /*// Read the house number
        int houseNumber = scanner.nextInt();
        if (0 <= houseNumber && houseNumber < list.size()) {
            String familyName = list.get(houseNumber);
            System.out.println(familyName);
        }*/
        // Read the city
        String cityCheck = scanner.nextLine();

        int i = listCity.indexOf(cityCheck);
        if (i<0) {
            System.out.println("В списке нет семьи которая живет в городе: "+cityCheck);

        }
        else {
            String familyName = listFamily.get(i);
            System.out.println(familyName);
        }
        //Map
        Map <String, String> list = new HashMap<String,String>();
        while (true) {
            String city = scanner.nextLine();
            if (city.isEmpty()) {
                break;
            }
            String family = scanner.nextLine();
            if (family.isEmpty()) {
                break;
            }

            list.put(city,family);

        }
        // Read the city
        cityCheck = scanner.nextLine();

        if (list.keySet().contains(cityCheck)){
            System.out.println(list.get(cityCheck));
        }
        else {
            System.out.println("В городе "+ cityCheck+" никто не живет!");
        }
    }
}
