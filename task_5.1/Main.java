/*
 * Дана коллекция имён.
 * 1) удалить все повторяющиеся имена из коллекции
 * 2) вывести коллекцию на экран
 * */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        ArrayList<String> names2 = new ArrayList();
        ArrayList<String> names3 = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");
        names2.addAll(names);
        names3.addAll(names);
        System.out.println(names);
        System.out.println(names2);
        System.out.println(names3);
        //1 вар
        Set<String> set = new HashSet<>(names);
        names.clear();
        names.addAll(set);
        System.out.println(names);
        //ArrayList<String> tmp = new ArrayList();
        //2 вар
        List<String> tmp = names2.stream().distinct().collect(Collectors.toList());
        names2.clear();
        names2.addAll(tmp);
        //3 вар
        tmp.clear();
        System.out.println(names2);
        for (String s:names3) {
            if (!tmp.contains(s)){
                tmp.add(s);
            }

        }
        names3.clear();
        names3.addAll(tmp);
        System.out.println(names3);



        
    }
}
