/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Введите число: ");
        int[] arr = {2, 3, 4, 5};
        int productarr = 1;
        for (int i=0; i<arr.length; i++) productarr*=arr[i];
        System.out.println("Произведение всх элементов массива = " + productarr);
    }
}
