/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/
import java.util.Arrays;
public class Main {
    public static void say(int[] arr) {
        System.out.println(arr[0]);
        if (arr.length>1){
            say(Arrays.copyOfRange(arr, 1, arr.length));}
        else return;
    }

    public static void main(String[] args) {
        int num[] = {4,2,6,2,65,456};
        say(num);
    }
}
