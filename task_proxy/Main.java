import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.Buffer;


public class Main {
    public static void main(String[] args)  {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaLearning\\proxy.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\JavaLearning\\good_proxy.txt"));
           
            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null) {
                String ip = readLine.split("\t")[0].trim();
                int port = Integer.parseInt(readLine.split("\t")[1].trim());
                if (checkProxy(ip, port)) {

                    System.out.println(ip + " - Адрес рабочий");
                    String result = ip + ":" + port;

                    try {
                        bufferedWriter.write(result);
                        //System.out.println(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else
                    System.out.println(ip + " - нерабочий");
            }

            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static boolean checkProxy(String ip, int port){
        Proxy proxyHost = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
        try {
            URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxyHost);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
         
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
