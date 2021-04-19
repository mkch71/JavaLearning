/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {12,3,234,4,5,6,8,9,6,4};
        List<Integer> nums =  Arrays.asList(arr);
        List<Integer> numsNew = new ArrayList<Integer>();
        System.out.println(nums);
        for( Integer n:nums){
            if (n>0 && n<10) numsNew.add(n);
        }
        //или
        System.out.println(numsNew);
        numsNew.clear();
        System.out.println(nums.stream().filter((p)->(p>0&&p<10)).collect(Collectors.toList()));
    }
}
