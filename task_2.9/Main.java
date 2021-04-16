/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Введите число: ");
        int[] arr = {2, 3, 4, 15, 43};
        for (int i=0; i<arr.length; i++) {
            if(arr[i] == 5){
                System.out.println("Массив содержит эелемент равный 5");
                return;
            }
        }

        System.out.println("Массив не содержит элемет равный 5");

    }
}
