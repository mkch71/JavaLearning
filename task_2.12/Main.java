/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 10 чисел, Enter, после каждого ");
        int[] arr = new int[10];
        for (int i=0; i<10; i++) {
            arr[i] = scan.nextInt();
        }
       int count = 1;
       int maxcount =1;
       for (int i = 0; i <  arr.length-1; i++){
           if(arr[i]==arr[i+1]) {
               count++;
           }
           else {
               maxcount = Math.max(count,maxcount);
               count = 1;
           }
       }
       maxcount = Math.max(count,maxcount); //если все элементы одинаковы
       System.out.println(maxcount);
    }
