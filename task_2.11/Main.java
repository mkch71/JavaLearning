/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,7,9,0,3,2,1};
        //int[] arr={1,2,4};
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum > 10){
                System.out.println("Необходимо сложить первые "+ (i+1) + " элементов массива");
                return;
            };

        }
        System.out.println("Сумма всех элементов массива меньше 10 и равна " + sum);
    }
}
