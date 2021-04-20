/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String filePath = buff.readLine();
        buff.close();
        buff = new BufferedReader(new FileReader(filePath));
        List<Integer> nums = new ArrayList<Integer>();
        String str;
        while ((str=buff.readLine())!=null){
            nums.add(Integer.parseInt (str.trim()));
        }

        List<Integer> numsNew = new ArrayList<Integer>();
        numsNew.addAll(nums.stream().sorted().filter((p)->(p%2==0)).collect(Collectors.toList()));
        for (Integer n:numsNew) {
            System.out.println(n);
        }
    }
}
