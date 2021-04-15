/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,6,4,2,4,5,6,3,1,3,5,6};
        for (int i = 0; i<arr.length-1; i++){
            if (arr[i] == arr[i+1]) {
                System.out.println("да");
                return;
            }
        }
        System.out.println("нет");

    }
}
