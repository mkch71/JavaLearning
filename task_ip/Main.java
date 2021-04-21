/*
Прочитать файл, вывести в консоль
sout("ip: "+ip+"port: "+ port)
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

        String str;
       
        while ((str=buff.readLine())!=null){
            System.out.println("ip: "+str.replace("\t"," port: "));
        }
        buff.close();
    }
}
