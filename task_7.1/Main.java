import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {


        try {
         FileInputStream fin = new FileInputStream("d:\\JavaLearning\\proxy.txt");

         String proxy ="";
         int i;
            while ((i=fin.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    //checkProxy(ip,Integer.parseInt(port));
                    //3- способ на вэбинаре
                    Thread thread3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(checkProxy(ip,Integer.parseInt(port),"3-й способ"));
                        }
                    });
                    //1-й способ наследование класса Thread
                    Thread thread1 = new ChekProxy(ip,Integer.parseInt(port));
                    //2-й способ через Интерфейс implements Runnable
                    Thread thread2 = new Thread(new CheckProxyRunnable(ip,Integer.parseInt(port)));

                    thread1.start();
                    thread2.start();
                    thread3.start();
                    proxy ="";
                } else if(i!=9) {
                   proxy += (char) i;
                } else
                {
                    proxy +=":";
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        };



    }

    public static String checkProxy(String ip, int port,String comment) {
        try {
            System.out.println(comment+" "+"Проверяю ip: "+ ip+" || port: "+port);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip,port));
            //URLConnection urlConnection = new URL("http://mkch71.beget.tech/php/ip/").openConnection(proxy);
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc=reader.read())!=-1){
                sb.append((char) rc);
            }
            return comment+" "+"IP: "+ip+":"+port+ANSI_GREEN+" работает"+ANSI_RESET;
        }
        catch (IOException e) {
            return comment+" "+"IP: "+ ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET;
        }catch (NoSuchElementException e) {
            //e.printStackTrace();
            return comment+" "+"Хрень!!! IP: "+ ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET;
        }

    }

}
//1-й способ наследование класса Thread
class ChekProxy extends Thread{
    private String ip;
    private int port;

    public ChekProxy(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println(Main.checkProxy(ip,port,"1-й способ"));
    }
}

//2-й способ через Интерфейс implements Runnable

class CheckProxyRunnable implements Runnable{
    private String ip;
    private int port;

    public CheckProxyRunnable(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println(Main.checkProxy(ip,port ,"2-й способ"));
    }
}
